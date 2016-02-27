package com.catchnote.springmvc.dao;

import com.catchnote.springmvc.model.User;

import java.util.List;

public interface UserDao {
    User findById(int id);
    User findUserByEmail(String email);
    User findUserByName(String name);
    void saveUser(User user);
    void deleteUserByEmail(String email);
    List<User> findAllUsers();
    boolean isValidUser(String username,String password);
    void refresh(User user);
}
