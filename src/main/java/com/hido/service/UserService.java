package com.hido.service;

import com.hido.dto.UserDTO;
import com.hido.model.Roles;
import com.hido.model.User;
import com.hido.repo.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
  public User createUser(UserDTO userDTO) {
    User user = toUserRole(userDTO);
    return userRepository.save(user);
  }

  private User toUserRole(UserDTO userDTO) {
    User user = userDTO.toUser();
//    Role role = new Role();
//    role.setName("ROLE_USER");
    user.setRole(Roles.USER);
    return user;
  }
}
