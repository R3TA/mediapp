package com.class5.mediapp.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotNull
	@Column(nullable = false, unique = true)
	private String nombre;
	
	@NotNull
	@Column(nullable = false)
	private String password;

	@NotNull
	@Column(nullable = false)
	@Size(max = 1)
	private String enabled;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
		name = "UsuarioRole",
		joinColumns = { @JoinColumn(name = "idUsuario") },
		inverseJoinColumns = { @JoinColumn(name = "idRole") }
	)
	
	List<Role> roles = new ArrayList<Role>();
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	private static final long serialVersionUID = 1L;

}
