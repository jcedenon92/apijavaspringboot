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
import com.nutritionapp.model.Usuario;
import com.nutritionapp.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> lista = service.listar();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK); 
	}

	// localhost:8080/usuarios/4 <---PathVariable
	// localhost:8080/usuarios/4?=2333param=0000 <---Param
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id) {
		Usuario obj = service.leerPorId(id);
		if(obj.getIdUsuario() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}
	/*
	@GetMapping("/{id}")
	public EntityModel<Usuario> listarPorId(@PathVariable("id") Integer id) {
		Usuario obj = service.leerPorId(id);
		if(obj.getIdUsuario() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		EntityModel<Usuario> recurso = new EntityModel<Usuario>(obj);
		//Link linkTo = linkTo(this.getClass()).slash(obj.getIdUsuario()).withSelfRel();		
		//Resource<Usuario> recurso1 = new Resource<Usuario>(obj);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		recurso.add(linkTo.withRel("paciente-resource"));
		return recurso;
	}*/
	
	//
	/*@PostMapping
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
		Usuario obj = service.registrar(usuario);
		return new ResponseEntity<Usuario>(obj, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Validated @RequestBody Usuario usuario) {
		Usuario obj = service.registrar(usuario);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Usuario> modificar(@RequestBody Usuario usuario) {
		Usuario obj = service.modificar(usuario);
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Usuario obj = service.leerPorId(id);
		if(obj.getIdUsuario() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
