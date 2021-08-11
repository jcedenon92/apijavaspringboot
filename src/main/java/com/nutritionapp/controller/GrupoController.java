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
import com.nutritionapp.model.Grupo;
import com.nutritionapp.service.IGrupoService;

//http://localhost:8080/grupos
//http://localhost:8080/grupos/5

@RestController
@RequestMapping("/grupos")
public class GrupoController {

	@Autowired
	private IGrupoService service;

	@GetMapping
	public ResponseEntity<List<Grupo>> listar() {
		List<Grupo> lista = service.listar();
		return new ResponseEntity<List<Grupo>>(lista, HttpStatus.OK); 
	}

	// localhost:8080/grupos/4 <---PathVariable 
	// localhost:8080/grupos/4?=2333param=0000 <---Param 
	@GetMapping("/{id}")
	public ResponseEntity<Grupo> listarPorId(@PathVariable("id") Integer id) {
		Grupo obj = service.leerPorId(id);
		if(obj.getIdGrupo() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Grupo>(obj, HttpStatus.OK);
	}

	/*@PostMapping
	public ResponseEntity<Grupo> registrar(@RequestBody Grupo grupo) {
		Grupo obj = service.registrar(grupo);
		return new ResponseEntity<Grupo>(obj, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Validated @RequestBody Grupo grupos) {
		Grupo obj = service.registrar(grupos);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(grupos.getIdGrupo()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Grupo> modificar(@RequestBody Grupo grupo) {
		Grupo obj = service.modificar(grupo);
		return new ResponseEntity<Grupo>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Grupo obj = service.leerPorId(id);
		if(obj.getIdGrupo() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
