package com.hido.controller;

import com.hido.model.User;
import com.hido.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

  @Autowired
  UserService service;

  @RequestMapping("/users/all")
  @ResponseBody
  public List<User> getAll() {
    return service.getAll();
  }

  @RequestMapping("/users/{id}")
  @ResponseBody
  public User getAll(@PathVariable(name = "id") Long id) {
    User user = service.findById(id);
    return user;
  }

  @RequestMapping("/users/register")
  @ResponseBody
  public User register(@RequestBody User user) {
    return service.save(user);
  }

}
