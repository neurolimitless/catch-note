package com.hido.dao;

import com.hido.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserServiceDao extends CrudRepository<User, Long> {
  List<User> findAll();

  User findById(Long id);
}
