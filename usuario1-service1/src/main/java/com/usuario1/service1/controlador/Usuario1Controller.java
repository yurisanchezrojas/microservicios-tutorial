package com.usuario1.service1.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.usuario1.service1.entidades.Usuario01;
import com.usuario1.service1.modelos.Carro1;
import com.usuario1.service1.modelos.Moto1;
import com.usuario1.service1.servicio.Usuario1Service;

@RestController
@RequestMapping("/usuario1")
public class Usuario1Controller {
	
	@Autowired
	private Usuario1Service usuario1Service;
	
	@GetMapping
	public ResponseEntity<List<Usuario01>> listarUsuario(){
		List<Usuario01> usuarios = usuario1Service.getAll();
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario01> obtenerUsuario(@PathVariable("id") int id){
		Usuario01 usuario = usuario1Service.getUsuarioById(id);
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);		
	}
	
	@PostMapping
	public ResponseEntity<Usuario01> guardarUsuario(@RequestBody Usuario01 usuario){
		Usuario01 nuevoUsuario= usuario1Service.save(usuario);
		return ResponseEntity.ok(nuevoUsuario);
		
	}
	
	@GetMapping("/carros/{usuarioId}")
	public ResponseEntity<List<Carro1>> listarCarros(@PathVariable("usuarioId") int id){
		Usuario01 usuario01 = usuario1Service.getUsuarioById(id);
		if(usuario01 == null) {
			return ResponseEntity.notFound().build();
		}
		List<Carro1> carros = usuario1Service.getCarros(id);
		return ResponseEntity.ok(carros);			
	}
	
	@GetMapping("/motos/{usuarioId}")
	public ResponseEntity<List<Moto1>> listarMotos(@PathVariable("usuarioId") int id){
		Usuario01 usuario = usuario1Service.getUsuarioById(id);
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		List<Moto1> motos = usuario1Service.getMotos(id);
		return ResponseEntity.ok(motos);		
		
	}
	
	

}








