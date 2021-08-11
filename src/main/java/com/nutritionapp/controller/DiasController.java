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
import com.nutritionapp.model.Dias;
import com.nutritionapp.service.IDiasService;

@RestController
@RequestMapping("/dias")
public class DiasController {

	@Autowired
	private IDiasService service;

	@GetMapping
	public ResponseEntity<List<Dias>> listar() {
		List<Dias> lista = service.listar();
		return new ResponseEntity<List<Dias>>(lista, HttpStatus.OK); 
	}

	// localhost:8080/dias/4 <---PathVariable
	// localhost:8080/dias/4?=2333param=0000 <---Param
	@GetMapping("/{id}")
	public ResponseEntity<Dias> listarPorId(@PathVariable("id") Integer id) {
		Dias obj = service.leerPorId(id);
		if(obj.getIdDias() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Dias>(obj, HttpStatus.OK);
	}

	/*@PostMapping
	public ResponseEntity<Dias> registrar(@RequestBody Dias dias) {
		Dias obj = service.registrar(dias);
		return new ResponseEntity<Dias>(obj, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Validated @RequestBody Dias dias) {
		Dias obj = service.registrar(dias);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dias.getIdDias()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Dias> modificar(@RequestBody Dias dias) {
		Dias obj = service.modificar(dias);
		return new ResponseEntity<Dias>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Dias obj = service.leerPorId(id);
		if(obj.getIdDias() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
