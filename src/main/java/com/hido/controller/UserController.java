package com.hido.controller;

import com.hido.model.User;
import com.hido.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
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

}
