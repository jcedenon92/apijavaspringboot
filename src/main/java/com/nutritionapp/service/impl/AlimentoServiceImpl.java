package com.nutritionapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritionapp.model.Alimento;
import com.nutritionapp.repo.IAlimentoRepo;
import com.nutritionapp.service.IAlimentoService;

@Service
public class AlimentoServiceImpl implements IAlimentoService{

	@Autowired
	private IAlimentoRepo repo;
	 
	@Override
	public Alimento registrar(Alimento obj) {
		return repo.save(obj);
	}

	@Override
	public Alimento modificar(Alimento obj) {
		return repo.save(obj);
	}

	@Override
	public List<Alimento> listar() {
		return repo.findAll();
	}

	@Override
	public Alimento leerPorId(Integer id) {
		 Optional<Alimento> op = repo.findById(id);
		 return op.isPresent() ? op.get() : new Alimento();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
