package com.catchnote.springmvc.dao;

import com.catchnote.springmvc.model.User;

import java.util.List;

public interface UserDao {
    User findById(int id);

    void saveUser(User user);

    void deleteUserByEmail(String email);

    List<User> findAllUsers();

    User findUserByEmail(String email);
}
