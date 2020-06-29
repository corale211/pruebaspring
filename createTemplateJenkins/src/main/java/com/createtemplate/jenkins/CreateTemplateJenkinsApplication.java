package com.createtemplate.jenkins;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.createtemplate.jenkins.model.templates;
import com.createtemplate.jenkins.repo.ITemplateRepo;

@SpringBootApplication
public class CreateTemplateJenkinsApplication implements CommandLineRunner {

//	public static Logger LOG = LoggerFactory.getLogger(CreateTemplateJenkinsApplication.class);
//	
//	@Autowired
//	private ITemplateRepo repo;
	
	//private String correo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CreateTemplateJenkinsApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		LOG.info("hola consola");
//		//service = new ITemplateServiceImpl();
//		LOG.info("este es el repositorio "+ repo.count());
//		LOG.info("hacendiendo ");
//		
//		for(templates template : repo.findAll()) {
//			LOG.info("hacendiendo correo lider  " + template.getCorreo_lider());
//			LOG.info("hacendiendo nombre proyecto  " + template.getNombre_proyecto());
//			LOG.info("hacendiendo urlgit  " + template.getUrlgit());
//		}
			
	}

}
