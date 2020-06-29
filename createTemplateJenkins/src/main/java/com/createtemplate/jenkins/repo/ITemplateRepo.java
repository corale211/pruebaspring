package com.createtemplate.jenkins.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createtemplate.jenkins.model.templates;

public interface ITemplateRepo extends JpaRepository<templates, Integer> {
	
}
