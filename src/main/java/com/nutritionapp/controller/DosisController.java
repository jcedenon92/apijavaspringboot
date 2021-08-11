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
import com.nutritionapp.model.Dosis;
import com.nutritionapp.service.IDosisService;

@RestController
@RequestMapping("/dosis")
public class DosisController {

	@Autowired
	private IDosisService service;

	@GetMapping
	public ResponseEntity<List<Dosis>> listar() {
		List<Dosis> lista = service.listar();
		return new ResponseEntity<List<Dosis>>(lista, HttpStatus.OK); 
	}

	// localhost:8080/dosis/4 <---PathVariable
	// localhost:8080/dosis/4?=2333param=0000 <---Param
	@GetMapping("/{id}")
	public ResponseEntity<Dosis> listarPorId(@PathVariable("id") Integer id) {
		Dosis dos = service.leerPorId(id);
		if(dos.getIdDosis() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Dosis>(dos, HttpStatus.OK);
	}

	/*@PostMapping
	public ResponseEntity<Dosis> registrar(@RequestBody Dosis dossona) {
		Dosis dos = service.registrar(dossona);
		return new ResponseEntity<Dosis>(dos, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Validated @RequestBody Dosis dossona) {
		Dosis dos = service.registrar(dossona);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dossona.getIdDosis()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Dosis> modificar(@RequestBody Dosis dossona) {
		Dosis dos = service.modificar(dossona);
		return new ResponseEntity<Dosis>(dos, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Dosis dos = service.leerPorId(id);
		if(dos.getIdDosis() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
