package com.nutritionapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritionapp.model.Prediccion;
import com.nutritionapp.repo.IPrediccionRepo;
import com.nutritionapp.service.IPrediccionService;

@Service
public class PrediccionServiceImpl implements IPrediccionService{

	@Autowired
	private IPrediccionRepo repo;
	 
	@Override
	public Prediccion registrar(Prediccion obj) {
		return repo.save(obj);
	}

	@Override
	public Prediccion modificar(Prediccion obj) {
		return repo.save(obj);
	}

	@Override
	public List<Prediccion> listar() {
		return repo.findAll();
	}

	@Override
	public Prediccion leerPorId(Integer id) {
		 Optional<Prediccion> op = repo.findById(id);
		 return op.isPresent() ? op.get() : new Prediccion();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
