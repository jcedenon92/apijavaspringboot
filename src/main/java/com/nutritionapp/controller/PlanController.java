package com.nutritionapp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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
import com.nutritionapp.model.Plan;
import com.nutritionapp.service.IPlanService;

@RestController
@RequestMapping("/planes")
public class PlanController {

	@Autowired
	private IPlanService service;

	@GetMapping
	public ResponseEntity<List<Plan>> listar() {
		List<Plan> lista = service.listar();
		return new ResponseEntity<List<Plan>>(lista, HttpStatus.OK); 
	}

	// localhost:8080/planes/4 <---PathVariable
	// localhost:8080/planes/4?=2333param=0000 <---Param
	@GetMapping("/{id}")
	public ResponseEntity<Plan> listarPorId(@PathVariable("id") Integer id) {
		Plan obj = service.leerPorId(id);
		if(obj.getIdPlan() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Plan>(obj, HttpStatus.OK);
	}

	/*@PostMapping
	public ResponseEntity<Plan> registrar(@RequestBody Plan plan) {
		Plan obj = service.registrar(plan);
		return new ResponseEntity<Plan>(obj, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Plan plan) {
		Plan obj = service.registrar(plan);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(plan.getIdPlan()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Plan> modificar(@RequestBody Plan objsona) {
		Plan obj = service.modificar(objsona);
		return new ResponseEntity<Plan>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Plan obj = service.leerPorId(id);
		if(obj.getIdPlan() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
