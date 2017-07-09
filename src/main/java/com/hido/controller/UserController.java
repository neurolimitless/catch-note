package com.hido.controller;

import com.hido.dto.UserDTO;
import com.hido.model.User;
import com.hido.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

  @Autowired
  UserService service;

  @RequestMapping("/users/{id}")
  @ResponseBody
  public User getAll(@PathVariable(name = "id") Long id) {
    User user = service.findUser(id).get();
    return user;
  }

  @RequestMapping("/users/register")
  @ResponseBody
  public User register(@RequestBody UserDTO user) {
    return service.createUser(user);
  }


}
