package com.nutritionapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritionapp.model.Dosis;
import com.nutritionapp.repo.IDosisRepo;
import com.nutritionapp.service.IDosisService;

@Service
public class DosisServiceImpl implements IDosisService{

	@Autowired
	private IDosisRepo repo;
	 
	@Override
	public Dosis registrar(Dosis obj) {
		return repo.save(obj);
	}

	@Override
	public Dosis modificar(Dosis obj) {
		return repo.save(obj);
	}

	@Override
	public List<Dosis> listar() {
		return repo.findAll();
	}

	@Override
	public Dosis leerPorId(Integer id) {
		 Optional<Dosis> op = repo.findById(id);
		 return op.isPresent() ? op.get() : new Dosis();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
