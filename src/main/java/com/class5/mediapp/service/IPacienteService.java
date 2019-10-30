package com.class5.mediapp.service;

import java.util.List;

import com.class5.mediapp.models.entity.Paciente;

public interface IPacienteService {
	Paciente registrar(Paciente paciente);
	Paciente modificar(Paciente paciente);
	List<Paciente> listar();
	Paciente leerPorId(Long id);
	boolean eliminar(Long id);
}
