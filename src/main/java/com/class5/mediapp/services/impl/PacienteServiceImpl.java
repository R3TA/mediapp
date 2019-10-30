package com.class5.mediapp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.class5.mediapp.models.dao.IPacienteServiceDao;
import com.class5.mediapp.models.entity.Paciente;
import com.class5.mediapp.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	IPacienteServiceDao pacienteServiceDao;
	
	@Override
	@Transactional
	public Paciente registrar(Paciente paciente) {
		return pacienteServiceDao.save(paciente); 
	}

	@Override
	@Transactional
	public Paciente modificar(Paciente paciente) {
		Paciente updated = null;
		Paciente actual = pacienteServiceDao.findById(paciente.getIdPaciente()).orElse(null);
		if(actual != null) {
			actual.setNombres(paciente.getNombres());
			actual.setApellidos(paciente.getApellidos());
			actual.setDni(paciente.getDni());
			actual.setTelefono(paciente.getTelefono());
			actual.setEmail(paciente.getEmail());
			updated = pacienteServiceDao.save(actual);
		}		
		return updated;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Paciente> listar() {
		return pacienteServiceDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Paciente leerPorId(Long id) {
		return pacienteServiceDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public boolean eliminar(Long id) {
		boolean flag = false;
		Paciente actual = pacienteServiceDao.findById(id).orElse(null);
		if(actual != null) {
			flag = true;
		}		
		return flag;
	}
}
