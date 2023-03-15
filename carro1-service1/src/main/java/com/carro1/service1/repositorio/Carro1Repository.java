package com.carro1.service1.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carro1.service1.entidades.Carro1;

public interface Carro1Repository  extends JpaRepository<Carro1, Integer>{
	
	List<Carro1> findByUsuarioId(int usuarioId);
		
	

}
