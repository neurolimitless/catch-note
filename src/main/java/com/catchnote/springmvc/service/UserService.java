package com.catchnote.springmvc.service;

import com.catchnote.springmvc.model.User;

import java.util.List;

public interface UserService {
    User findById(int id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserByEmail(String email);
    List<User> findAllUsers();
    User findUserByEmail(String email);
    User findUserByName(String name);
    boolean isUserUnique(Integer id, String email, String username);
    boolean isCorrectPassword(String pass,String passFromDb);
    void refresh(User user);
}
