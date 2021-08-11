package com.nutritionapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritionapp.model.Dias;
import com.nutritionapp.repo.IDiasRepo;
import com.nutritionapp.service.IDiasService;

@Service
public class DiasServiceImpl implements IDiasService{

	@Autowired
	private IDiasRepo repo;
	 
	@Override
	public Dias registrar(Dias obj) {
		return repo.save(obj);
	}

	@Override
	public Dias modificar(Dias obj) {
		return repo.save(obj);
	}

	@Override
	public List<Dias> listar() {
		return repo.findAll();
	}

	@Override
	public Dias leerPorId(Integer id) {
		 Optional<Dias> op = repo.findById(id);
		 return op.isPresent() ? op.get() : new Dias();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
