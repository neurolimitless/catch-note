package com.hido.controller;

import com.hido.dto.UserDTO;
import com.hido.model.User;
import com.hido.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserService service;

  @RequestMapping("/{id}")
  @ResponseBody
  public User getAll(@PathVariable(name = "id") Long id) {
    User user = service.findUser(id).get();
    return user;
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  @ResponseBody
  public User register(@RequestBody UserDTO user) throws DataIntegrityViolationException {
    return service.createUser(user);
  }


}
