package com.se.template.service.dao;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "templates")
public class TemplateJpa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String payload;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPayload() {
    return payload;
  }
}
