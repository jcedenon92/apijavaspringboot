package com.nutritionapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritionapp.model.Grupo;
import com.nutritionapp.repo.IGrupoRepo;
import com.nutritionapp.service.IGrupoService;

@Service
public class GrupoServiceImpl implements IGrupoService{

	@Autowired
	private IGrupoRepo repo;
	 
	@Override
	public Grupo registrar(Grupo obj) {
		return repo.save(obj);
	}

	@Override
	public Grupo modificar(Grupo obj) {
		return repo.save(obj);
	}

	@Override
	public List<Grupo> listar() {
		return repo.findAll();
	}

	@Override
	public Grupo leerPorId(Integer id) {
		 Optional<Grupo> op = repo.findById(id);
		 return op.isPresent() ? op.get() : new Grupo();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
