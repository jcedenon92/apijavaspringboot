package com.nutritionapp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.nutritionapp.model.Alimento;
import com.nutritionapp.service.IAlimentoService;

@RestController
@RequestMapping("/alimentos")
public class AlimentoController {

	@Autowired
	private IAlimentoService service;

	@GetMapping
	public ResponseEntity<List<Alimento>> listar() {
		List<Alimento> lista = service.listar();
		return new ResponseEntity<List<Alimento>>(lista, HttpStatus.OK); 
	}

	// localhost:8080/objmentos/4 <---PathVariable
	// localhost:8080/objmentos/4?=2333param=0000 <---Param
	@GetMapping("/{id}")
	public ResponseEntity<Alimento> listarPorId(@PathVariable("id") Integer id) {
		Alimento ali = service.leerPorId(id);
		if(ali.getIdAlimento() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Alimento>(ali, HttpStatus.OK);
	}

	/*
	@PostMapping
	public ResponseEntity<Alimento> registrar(@RequestBody Alimento alimento) {
		Alimento obj = service.registrar(alimento);
		return new ResponseEntity<Alimento>(obj, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Alimento alimento) {
		Alimento ali = service.registrar(alimento);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alimento.getIdAlimento()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Alimento> modificar(@Valid @RequestBody Alimento alimento) {
		Alimento obj = service.modificar(alimento);
		return new ResponseEntity<Alimento>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Alimento obj = service.leerPorId(id);
		if(obj.getIdAlimento() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
