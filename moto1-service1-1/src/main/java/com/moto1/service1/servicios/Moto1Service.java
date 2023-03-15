package com.moto1.service1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moto1.service1.entidades.Moto1;
import com.moto1.service1.repositorio.Moto1Repository;

@Service
public class Moto1Service {
	
	@Autowired
	private Moto1Repository moto1Repository;
	
	public List<Moto1> getAll(){
		return moto1Repository.findAll();
	}
	public Moto1 getMotoById(int id) {
		
		return moto1Repository.findById(id).orElse(null);
	}
	public Moto1 save(Moto1 moto) {
		Moto1 nuevaMoto=moto1Repository.save(moto);
		return nuevaMoto;
		
	}
	
	public List<Moto1> byUsuarioId(int usuarioId){
		return moto1Repository.findByUsuarioId(usuarioId);
		
	}


}
