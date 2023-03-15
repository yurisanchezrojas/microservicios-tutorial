package com.carro1.service1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carro1.service1.entidades.Carro1;
import com.carro1.service1.repositorio.Carro1Repository;

@Service
public class Carro1Service {
	
	@Autowired
	private Carro1Repository carro1Repository;
	

	public List<Carro1> getAll(){
		return carro1Repository.findAll();
	}
	
	public Carro1 getCarro1ById(int id) {
		
		return carro1Repository.findById(id).orElse(null);		
	}
	
	public Carro1 save(Carro1 carro1) {
		
		Carro1 nuevoCarro= carro1Repository.save(carro1);
		return nuevoCarro;
		
	}
	
	public List<Carro1> byUsuarioId(int usuarioId){
		
		return carro1Repository.findByUsuarioId(usuarioId);		
	}

	

}




