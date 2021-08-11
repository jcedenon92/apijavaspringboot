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
import com.nutritionapp.model.Prediccion;
import com.nutritionapp.service.IPrediccionService;

@RestController
@RequestMapping("/predicciones")
public class PrediccionController {

	@Autowired
	private IPrediccionService service;

	@GetMapping
	public ResponseEntity<List<Prediccion>> listar() {
		List<Prediccion> lista = service.listar();
		return new ResponseEntity<List<Prediccion>>(lista, HttpStatus.OK); 
	}

	// localhost:8080/predicciones/4 <---PathVariable
	// localhost:8080/predicciones/4?=2333param=0000 <---Param
	@GetMapping("/{id}")
	public ResponseEntity<Prediccion> listarPorId(@PathVariable("id") Integer id) {
		Prediccion obj = service.leerPorId(id);
		if(obj.getIdPrediccion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Prediccion>(obj, HttpStatus.OK);
	}

	/*@PostMapping
	public ResponseEntity<Prediccion> registrar(@RequestBody Prediccion prediccion) {
		Prediccion obj = service.registrar(prediccion);
		return new ResponseEntity<Prediccion>(obj, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Validated @RequestBody Prediccion prediccion) {
		Prediccion obj = service.registrar(prediccion);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prediccion.getIdPrediccion()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Prediccion> modificar(@RequestBody Prediccion prediccion) {
		Prediccion obj = service.modificar(prediccion);
		return new ResponseEntity<Prediccion>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Prediccion obj = service.leerPorId(id);
		if(obj.getIdPrediccion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
