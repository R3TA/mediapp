package com.class5.mediapp.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Menu")
public class Menu implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMenu;
	
	@Size(max = 20)
	private String icono;
	
	@Size(max = 20)
	private String nombre;
	
	@Size(max = 20)
	private String url;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
		name = "MenuRole",
		joinColumns = { @JoinColumn(name = "idMenu") },
		inverseJoinColumns = { @JoinColumn(name = "idRole") }
	)
	
	List<Role> roles = new ArrayList<Role>();
	
	public Long getIdMenu() {
		return idMenu;
	}
	
	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private static final long serialVersionUID = 1L;
}
