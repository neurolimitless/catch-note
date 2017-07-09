package com.hido.controller;

import com.hido.model.User;
import com.hido.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

  @Autowired
  private UserService userService;

  @RequestMapping(method = RequestMethod.GET)
  public String loginPage() {
    return "login";
  }

  @RequestMapping(value = "/check")
  public Object handleSuccessLogin() {
    if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
      return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    } else {
      return null;
    }
  }

  @RequestMapping(value = "/error")
  public ResponseEntity handleErrorLogin(HttpServletRequest request) {
    AuthenticationException exception = (AuthenticationException) request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    exception.printStackTrace();// todo handle (or log)exception properly
    return ResponseEntity.badRequest().body(exception);
  }

}
