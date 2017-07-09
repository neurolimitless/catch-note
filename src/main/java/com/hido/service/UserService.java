package com.hido.service;

import com.hido.dao.UserServiceDao;
import com.hido.exceptions.InvalidCredentialsException;
import com.hido.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {

  private static final Logger LOG = Logger.getLogger(NoteService.class);

  @Autowired
  UserServiceDao userServiceDao;

  public List<User> getAll() {
    return userServiceDao.findAll();
  }

  public User findById(Long id) {
    return userServiceDao.findById(id);
  }

  public User save(User user) {
    User savedUser = userServiceDao.save(user);
    LOG.info("A new user=[" + savedUser + "] has been saved.");
    return savedUser;
  }

  public User checkLogin(User user) throws InvalidCredentialsException {
    User userFromDb = userServiceDao.findByNameAndPassword(user.getName(), user.getPassword());
    if (userFromDb != null) {
      return userFromDb;
    } else throw new InvalidCredentialsException();
  }
}
