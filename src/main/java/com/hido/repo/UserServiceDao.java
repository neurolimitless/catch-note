package com.hido.repo;

import com.hido.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserServiceDao extends JpaRepository<User, Long> {

  List<User> findAll();

  User findById(Long id);

  User findByNameAndPassword(String name, String password);

}
