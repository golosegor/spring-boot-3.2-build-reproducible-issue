package com.se.template.service.controllers;

import com.se.template.service.repositories.TemplateRepository;
import com.se.shared.libraries.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TemplateController {
  private final TemplateRepository repository;

  TemplateController(TemplateRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/templates")
  List<TemplateDto> all() {
    DateUtil dateUtil = new DateUtil();
    return repository.findAll().stream().map(d -> new TemplateDto(d, dateUtil.getDate())).collect(Collectors.toList());
  }
}
