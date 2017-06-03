package com.hido.dao;

import com.hido.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserServiceDao extends CrudRepository<User, Long> {
  List<User> findAll();

  User findById(Long id);
}
