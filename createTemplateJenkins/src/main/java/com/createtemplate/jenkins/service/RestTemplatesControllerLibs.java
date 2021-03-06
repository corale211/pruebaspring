package com.createtemplate.jenkins.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createtemplate.jenkins.CreateTemplateJenkinsApplication;
import com.createtemplate.jenkins.model.templates;
import com.createtemplate.jenkins.repo.ITemplateRepo;

@RestController
@RequestMapping("/templatesLibs")
public class RestTemplatesControllerLibs {

	private String correo_lider;
	private String nombre_proyecto;
	private String giturl;
	private String correoqa;
	
	public static Logger LOG = LoggerFactory.getLogger(CreateTemplateJenkinsApplication.class);
	
	@Autowired
	private ITemplateRepo templateslibs;
	
//	@GetMapping
//	public List<templates> listar(){
//		return temp.findAll();
//	}
//	
	@PostMapping
	public void insertar(@RequestBody templates temlibs) {
		templateslibs.save(temlibs);
		Descargaxmlapp();
	}
	
	public void Descargaxmlapp() {
		nombre_proyecto = templateslibs.findAll().get(templateslibs.findAll().size() -1).getNombre_proyecto();
		correo_lider = templateslibs.findAll().get(templateslibs.findAll().size() -1).getCorreo_lider();
		giturl = templateslibs.findAll().get(templateslibs.findAll().size() -1).getUrlgit();
		correoqa = templateslibs.findAll().get(templateslibs.findAll().size() -1).getCorreo_qa();
		
		Process proceso;
		  try {
		   String[] cmd = { "sh", "/home/kali/libs_android", nombre_proyecto, correo_lider, giturl, correoqa};
		   proceso = Runtime.getRuntime().exec(cmd); 
		   proceso.waitFor(); 
		   BufferedReader reader=new BufferedReader(new InputStreamReader(
		    proceso.getInputStream())); 
		   String line; 
		   while((line = reader.readLine()) != null) { 
		    System.out.println(line);
		    LOG.info(line);
		   } 
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (InterruptedException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		
	}
}
