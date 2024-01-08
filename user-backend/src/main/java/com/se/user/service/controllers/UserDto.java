package com.se.user.service.controllers;

import java.util.Date;

public class UserDto {
  private String name;
  private Date date;

  public UserDto(String name, Date date) {
    this.name = name;
    this.date = date;
  }

  public String getName() {
    return name;
  }

  public Date getDate() {
    return date;
  }
}
