package com.nutritionapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritionapp.model.Vacuna;
import com.nutritionapp.repo.IVacunaRepo;
import com.nutritionapp.service.IVacunaService;

@Service
public class VacunaServiceImpl implements IVacunaService{

	@Autowired
	private IVacunaRepo repo;
	 
	@Override
	public Vacuna registrar(Vacuna obj) {
		return repo.save(obj);
	}

	@Override
	public Vacuna modificar(Vacuna obj) {
		return repo.save(obj);
	}

	@Override
	public List<Vacuna> listar() {
		return repo.findAll();
	}

	@Override
	public Vacuna leerPorId(Integer id) {
		 Optional<Vacuna> op = repo.findById(id);
		 return op.isPresent() ? op.get() : new Vacuna();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
