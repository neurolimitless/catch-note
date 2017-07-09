package com.hido.service;

import com.hido.dto.UserDTO;
import com.hido.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends UserDetailsService {
  User update(User user, UserDTO params);

  Optional<User> findUser(Long id);

  User createUser(UserDTO userDTO);
}
