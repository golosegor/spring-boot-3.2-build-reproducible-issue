package com.se.template.service.controllers;

import com.se.template.service.dao.TemplateJpa;

import java.util.Date;

public class TemplateDto {
  private final TemplateJpa templateJpa;
  private final Date date;

  public TemplateDto(TemplateJpa templateJpa, Date date) {
    this.templateJpa = templateJpa;
    this.date = date;
  }

  public TemplateJpa getTemplateJpa() {
    return templateJpa;
  }

  public Date getDate() {
    return date;
  }
}
