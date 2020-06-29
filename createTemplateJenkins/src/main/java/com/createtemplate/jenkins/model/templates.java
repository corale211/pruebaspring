package com.createtemplate.jenkins.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class templates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique = true)
	private int idtemplate;
	@Column(name = "nombre_proyecto", length = 150)
	private String nombre_proyecto;
	@Column(name = "Correo_electronico", length = 150)
	private String correo_lider;
	@Column(name = "url_git", length = 200)
	private String urlgit;
	
	
	
	public String getNombre_proyecto() {
		return nombre_proyecto;
	}
	public void setNombre_proyecto(String nombre_proyecto) {
		this.nombre_proyecto = nombre_proyecto;
	}
	public String getCorreo_lider() {
		return correo_lider;
	}
	public void setCorreo_lider(String correo_lider) {
		this.correo_lider = correo_lider;
	}
	public String getUrlgit() {
		return urlgit;
	}
	public void setUrlgit(String urlgit) {
		this.urlgit = urlgit;
	}
	
//	public int getIdtemplate() {
//		return idtemplate;
//	}
//	public void setIdtemplate(int idtemplate) {
//		this.idtemplate = idtemplate;
//	}

	
	
	
}
