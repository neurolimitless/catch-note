package com.hido.repo;

import com.hido.dto.UserDTO;
import com.hido.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByName(String name);

  void save(UserDTO userDTO);
}
