package com.nutritionapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nutritionapp.exception.ModeloNotFoundException;
import com.nutritionapp.model.TurnoComida;
import com.nutritionapp.service.ITurnoComidaService;

@RestController
@RequestMapping("/turnocomidas")
public class TurnoComidaController {

	@Autowired
	private ITurnoComidaService service;

	@GetMapping
	public ResponseEntity<List<TurnoComida>> listar() {
		List<TurnoComida> lista = service.listar();
		return new ResponseEntity<List<TurnoComida>>(lista, HttpStatus.OK); 
	}

	// localhost:8080/turnocomidas/4 <---PathVariable
	// localhost:8080/turnocomidas/4?=2333param=0000 <---Param
	@GetMapping("/{id}")
	public ResponseEntity<TurnoComida> listarPorId(@PathVariable("id") Integer id) {
		TurnoComida obj = service.leerPorId(id);
		if(obj.getIdTurnoComida() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<TurnoComida>(obj, HttpStatus.OK);
	}

	/*@PostMapping
	public ResponseEntity<TurnoComida> registrar(@RequestBody TurnoComida turnocomida) {
		TurnoComida obj = service.registrar(turnocomida);
		return new ResponseEntity<TurnoComida>(obj, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Validated @RequestBody TurnoComida turnocomida) {
		TurnoComida obj = service.registrar(turnocomida);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(turnocomida.getIdTurnoComida()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<TurnoComida> modificar(@RequestBody TurnoComida turnocomida) {
		TurnoComida obj = service.modificar(turnocomida);
		return new ResponseEntity<TurnoComida>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		TurnoComida obj = service.leerPorId(id);
		if(obj.getIdTurnoComida() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
