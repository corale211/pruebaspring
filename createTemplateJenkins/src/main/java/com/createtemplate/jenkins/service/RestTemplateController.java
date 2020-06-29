package com.createtemplate.jenkins.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createtemplate.jenkins.CreateTemplateJenkinsApplication;
import com.createtemplate.jenkins.model.templates;
import com.createtemplate.jenkins.repo.ITemplateRepo;

@RestController
@RequestMapping("/templates")
public class RestTemplateController {
	
	private String correo;
	private String nombre;
	private String giturl;
	public static Logger LOG = LoggerFactory.getLogger(CreateTemplateJenkinsApplication.class);
	
	@Autowired
	private ITemplateRepo temp;
	
	@GetMapping
	public List<templates> listra(){
		return temp.findAll();
	}
	
	@PostMapping
	public void insertar(@RequestBody templates tem) {
		temp.save(tem);
		shell();
	}
	
	public void shell() {
		correo = temp.findAll().get(temp.findAll().size() -1).getCorreo_lider();
		nombre = temp.findAll().get(temp.findAll().size() -1).getNombre_proyecto();
		giturl = temp.findAll().get(temp.findAll().size() -1).getUrlgit();
		
//		LOG.info("prueba correo2   "+correo);
//		LOG.info("prueba nombre_Proyecto   "+nombre);
//		LOG.info("prueba giturl   "+giturl);
		
		String command = "curl -X GET https://jenkins-devsecopsms.apps.paasprofuturo-d.r6b1.p1.openshiftapps.com/view/Templates_apk/job/template_motor_dev/config.xml --user profudevops-admin-edit-view:119b3ae03225298d2837b62c27425971e3 -o configdev.xml";
		LOG.info("Curl  "+ command);
		ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
		processBuilder.directory(new File("\\resources\\templates"));
		
		try {
			Process process = processBuilder.start();
			InputStream inputStream = process.getInputStream();
			int exitCode = process.exitValue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	
	
	
}
