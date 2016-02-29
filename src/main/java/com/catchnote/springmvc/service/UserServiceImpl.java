package com.catchnote.springmvc.service;


import com.catchnote.springmvc.dao.UserDao;
import com.catchnote.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Transactional
    public User findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    @Transactional
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if (entity != null) {
            entity.setName(user.getName());
            entity.setPass(user.getPass());
            entity.setEmail(user.getEmail());
        }
    }

    @Transactional
    public void deleteUserByEmail(String email) {
        dao.deleteUserByEmail(email);
    }

    @Transactional
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    @Transactional
    public User findUserByEmail(String email) {
        return dao.findUserByEmail(email);
    }

    @Transactional
    public User findUserByName(String name) {
        return dao.findUserByName(name);
    }

    @Transactional
    public boolean isUserUnique(Integer id, String email, String username) {
        User byName = dao.findUserByName(username);
        User user = dao.findUserByEmail(email);
        if (null != byName && byName.getName().equals(username) && byName.getId() != id) return false;
        else if (null != user && user.getEmail().equals(email) && user.getId() != id) return false;
        else return true;
    }

    @Transactional
    public boolean isCorrectPassword(String pass, String passFromDb) {
        return (DigestUtils.md5DigestAsHex(pass.getBytes()).equals(passFromDb));

    }

    public void refresh(User user) {
        dao.refresh(user);
    }



    }




