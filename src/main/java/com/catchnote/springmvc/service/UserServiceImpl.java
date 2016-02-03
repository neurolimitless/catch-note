package com.catchnote.springmvc.service;


import com.catchnote.springmvc.dao.UserDao;
import com.catchnote.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public User findById(int id) {
        return dao.findById(id);
    }

    public void saveUser(User user) {
        dao.saveUser(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if (entity != null) {
            entity.setName(user.getName());
            entity.setJoiningDate(user.getJoiningDate());
            entity.setSalary(user.getSalary());
            entity.setEmail(user.getEmail());
        }
    }

    public void deleteUserByEmail(String email) {
        dao.deleteUserByEmail(email);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    public User findUserByEmail(String email) {
        return dao.findUserByEmail(email);
    }

    public boolean isUserEmailUnique(Integer id, String email) {
        User user = findUserByEmail(email);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

}

