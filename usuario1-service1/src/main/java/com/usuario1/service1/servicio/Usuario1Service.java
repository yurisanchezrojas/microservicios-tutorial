package com.usuario1.service1.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.usuario1.service1.entidades.Usuario01;
import com.usuario1.service1.modelos.Carro1;
import com.usuario1.service1.modelos.Moto1;
import com.usuario1.service1.repositorio.Usuario1Repository;

@Service
public class Usuario1Service {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Usuario1Repository usuario1Repository;
	
	public List<Carro1> getCarros(int usuarioId){
		List<Carro1> carros = restTemplate.getForObject("http://localhost:8005/carro1/usuario1/" +usuarioId, List.class);
		return carros;
	}
	
	public List<Moto1> getMotos(int usuarioId){
		
		List<Moto1> motos = restTemplate.getForObject("http://localhost:8004/moto1/usuario1/" +usuarioId, List.class);
		return motos;
	}
	
	public List<Usuario01> getAll(){
		return usuario1Repository.findAll();
	}
	
	public Usuario01 getUsuarioById(int id) {
		return usuario1Repository.findById(id).orElse(null);
	}
	
	public Usuario01 save(Usuario01 usuario) {
		Usuario01 nuevoUsuario = usuario1Repository.save(usuario);
		return nuevoUsuario;
		
	}

}



