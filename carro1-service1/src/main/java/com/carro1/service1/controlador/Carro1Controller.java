package com.carro1.service1.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.carro1.service1.entidades.Carro1;
import com.carro1.service1.servicios.Carro1Service;

@RestController
@RequestMapping("/carro1")
public class Carro1Controller {
	
	@Autowired
	private Carro1Service carro1Service;
	
	@GetMapping
	public ResponseEntity<List<Carro1>> listarCarros() {
		List<Carro1> carros = carro1Service.getAll();
		if (carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro1> obtenerCarro(@PathVariable("id") int id) {
		Carro1 carro = carro1Service.getCarro1ById(id);
		if (carro == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carro);

	}
	
	@PostMapping
	public ResponseEntity<Carro1> guardarCarro(@RequestBody Carro1 carro1) {
		Carro1 nuevoCarro = carro1Service.save(carro1);
		return ResponseEntity.ok(nuevoCarro);

	}
	

	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Carro1>> listarCarrosPorUsuario(@PathVariable("usuarioId") int id) {
		List<Carro1> carros = carro1Service.byUsuarioId(id);
		if (carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);

	}

}


