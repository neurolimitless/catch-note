package com.hido.service;

import com.hido.dao.UserServiceDao;
import com.hido.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  UserServiceDao userServiceDao;

  public List<User> getAll() {
    return userServiceDao.findAll();
  }

  public User findById(Long id) {
    return userServiceDao.findById(id);
  }

}
