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
import com.nutritionapp.model.Vacuna;
import com.nutritionapp.service.IVacunaService;

@RestController
@RequestMapping("/vacunas")
public class VacunaController {

	@Autowired
	private IVacunaService service;

	@GetMapping
	public ResponseEntity<List<Vacuna>> listar() {
		List<Vacuna> lista = service.listar();
		return new ResponseEntity<List<Vacuna>>(lista, HttpStatus.OK); 
	}

	// localhost:8080/vacunas/4 <---PathVariable
	// localhost:8080/vacunas/4?=2333param=0000 <---Param
	@GetMapping("/{id}")
	public ResponseEntity<Vacuna> listarPorId(@PathVariable("id") Integer id) {
		Vacuna obj = service.leerPorId(id);
		if(obj.getIdVacuna() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Vacuna>(obj, HttpStatus.OK);
	}

	/*@PostMapping
	public ResponseEntity<Vacuna> registrar(@RequestBody Vacuna vacuna) {
		Vacuna obj = service.registrar(vacuna);
		return new ResponseEntity<Vacuna>(obj, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Validated @RequestBody Vacuna vacuna) {
		Vacuna obj = service.registrar(vacuna);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vacuna.getIdVacuna()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Vacuna> modificar(@RequestBody Vacuna vacuna) {
		Vacuna obj = service.modificar(vacuna);
		return new ResponseEntity<Vacuna>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Vacuna obj = service.leerPorId(id);
		if(obj.getIdVacuna() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
