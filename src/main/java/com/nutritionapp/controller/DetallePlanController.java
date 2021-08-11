package com.nutritionapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritionapp.model.DetallePlan;
import com.nutritionapp.service.IDetallePlanService;

@RestController
@RequestMapping("/detalleplan")
public class DetallePlanController {

	@Autowired
	private IDetallePlanService service;
	
	@GetMapping
	public ResponseEntity<List<DetallePlan>> listar(){
		List<DetallePlan> lista = service.listar();
		return new ResponseEntity<List<DetallePlan>>(lista, HttpStatus.OK);
	}
	
}
