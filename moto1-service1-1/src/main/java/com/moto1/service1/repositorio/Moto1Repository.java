package com.moto1.service1.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moto1.service1.entidades.Moto1;

public interface Moto1Repository  extends JpaRepository<Moto1, Integer>{
	
	List<Moto1> findByUsuarioId(int usuarioId);

}
