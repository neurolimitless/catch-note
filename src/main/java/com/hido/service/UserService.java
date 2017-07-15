package com.hido.service;

import com.hido.dto.UserDTO;
import com.hido.model.Roles;
import com.hido.model.User;
import com.hido.repo.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserService implements IUserService {

  private static final Logger LOG = Logger.getLogger(NoteService.class);

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final Optional<User> user = userRepository.findByName(username);
    final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    user.ifPresent(detailsChecker::check);
    return user.orElseThrow(() -> new UsernameNotFoundException("user not found."));
  }

  @Override
  public User update(User user, UserDTO params) {
    params.getEmail().ifPresent(user::setEmail);
    params.getEncodedPassword().ifPresent(user::setPassword);
    params.getName().ifPresent(user::setName);
    return userRepository.save(user);
  }

  @Override
  public Optional<User> findUser(Long id) {
    return Optional.of(userRepository.findOne(id));
  }

  @Override
  public User createUser(UserDTO userDTO) throws DataIntegrityViolationException {
    try {
      UserDetails userDetails = loadUserByUsername(userDTO.getName().get());
      if (userDetails != null) {
        throw new DataIntegrityViolationException("User with such username already exists.");
      }
    } catch (UsernameNotFoundException e) {
    }
    User user = toUserRole(userDTO);
    User createdUser = userRepository.save(user);
    LOG.info("New user registered: " + createdUser);
    return createdUser;
  }

  private User toUserRole(UserDTO userDTO) {
    User user = userDTO.toUser();
    user.setRole(Roles.USER);
    return user;
  }
}
