package com.nutritionapp.controller;

import java.net.URI;
import java.util.ArrayList;
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

import com.nutritionapp.dto.ControlResumenDTO;
import com.nutritionapp.exception.ModeloNotFoundException;
import com.nutritionapp.model.Control;
import com.nutritionapp.service.IControlService;

@RestController
@RequestMapping("/controles")
public class ControlController {

	@Autowired
	private IControlService service;

	@GetMapping
	public ResponseEntity<List<Control>> listar() {
		List<Control> lista = service.listar();
		return new ResponseEntity<List<Control>>(lista, HttpStatus.OK); 
	}

	// localhost:8080/controles/4 <---PathVariable
	// localhost:8080/controles/4?=2333param=0000 <---Param
	@GetMapping("/{id}")
	public ResponseEntity<Control> listarPorId(@PathVariable("id") Integer id) {
		Control obj = service.leerPorId(id);
		if(obj.getIdControl() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Control>(obj, HttpStatus.OK);
	}

	/*@PostMapping
	public ResponseEntity<Control> registrar(@RequestBody Control control) {
		Control obj = service.registrar(control);
		return new ResponseEntity<Control>(obj, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Validated @RequestBody Control control) {
		Control obj = service.registrar(control);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(control.getIdControl()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Control> modificar(@RequestBody Control control) {
		Control obj = service.modificar(control);
		return new ResponseEntity<Control>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Control obj = service.leerPorId(id);
		if(obj.getIdControl() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarResumen")
	public ResponseEntity<List<ControlResumenDTO>> listarResumen(){
		List<ControlResumenDTO> controles = new ArrayList<>();
		controles = service.listarResumen();
		return new ResponseEntity<List<ControlResumenDTO>>(controles, HttpStatus.OK);
	}
}
