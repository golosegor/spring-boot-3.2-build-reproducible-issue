package com.se.template.service.repositories;

import com.se.template.service.dao.TemplateJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<TemplateJpa, Long> {

}
