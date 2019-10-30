package com.class5.mediapp.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.class5.mediapp.models.entity.Paciente;

public interface IPacienteServiceDao extends JpaRepository<Paciente, Long>{

}
