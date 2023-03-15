package com.moto1.service1.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moto1.service1.entidades.Moto1;
import com.moto1.service1.servicios.Moto1Service;

@RestController
@RequestMapping("/moto1")
public class Moto1Controller {
	
	@Autowired
	private Moto1Service moto1Service;
	
	@GetMapping
	public ResponseEntity<List<Moto1>> listarMotos(){
		List<Moto1> motos = moto1Service.getAll();
		if(motos.isEmpty()) {
			return ResponseEntity.noContent().build();
			
		}
		return ResponseEntity.ok(motos);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Moto1> obtenerMoto(@PathVariable("id") int id){
		Moto1 moto1= moto1Service.getMotoById(id);
		if(moto1 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(moto1);
		
	}
	
	@PostMapping
	public ResponseEntity<Moto1> guardarMoto(@RequestBody Moto1 moto1){
		Moto1 nuevaMoto = moto1Service.save(moto1);
		return ResponseEntity.ok(nuevaMoto);
		
	}
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Moto1>> listarMotosPorUsuarioId(@PathVariable("usuarioId") int id){
		List<Moto1> motos = moto1Service.byUsuarioId(id);
		if(motos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motos);
		
	}
	

	
	

}
