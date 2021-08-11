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
import com.nutritionapp.model.Rol;
import com.nutritionapp.service.IRolService;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private IRolService service;

	@GetMapping
	public ResponseEntity<List<Rol>> listar() {
		List<Rol> lista = service.listar();
		return new ResponseEntity<List<Rol>>(lista, HttpStatus.OK); 
	}

	// localhost:8080/rols/4 <---PathVariable
	// localhost:8080/rols/4?=2333param=0000 <---Param
	@GetMapping("/{id}")
	public ResponseEntity<Rol> listarPorId(@PathVariable("id") Integer id) {
		Rol obj = service.leerPorId(id);
		if(obj.getIdRol() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Rol>(obj, HttpStatus.OK);
	}

	/*@PostMapping
	public ResponseEntity<Rol> registrar(@RequestBody Rol rol) {
		Rol obj = service.registrar(rol);
		return new ResponseEntity<Rol>(obj, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Validated @RequestBody Rol rol) {
		Rol obj = service.registrar(rol);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rol.getIdRol()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Rol> modificar(@RequestBody Rol rol) {
		Rol obj = service.modificar(rol);
		return new ResponseEntity<Rol>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Rol obj = service.leerPorId(id);
		if(obj.getIdRol() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
