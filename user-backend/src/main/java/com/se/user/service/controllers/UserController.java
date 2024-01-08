package com.se.user.service.controllers;

import com.se.shared.libraries.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {

  @GetMapping("/user")
  UserDto me() {
    DateUtil dateUtils = new DateUtil();
    Date date = dateUtils.getDate();
    return new UserDto("name", date);
  }
}
