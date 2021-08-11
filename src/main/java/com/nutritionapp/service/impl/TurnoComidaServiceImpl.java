package com.nutritionapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritionapp.model.TurnoComida;
import com.nutritionapp.repo.ITurnoComidaRepo;
import com.nutritionapp.service.ITurnoComidaService;

@Service
public class TurnoComidaServiceImpl implements ITurnoComidaService{

	@Autowired
	private ITurnoComidaRepo repo;
	 
	@Override
	public TurnoComida registrar(TurnoComida obj) {
		return repo.save(obj);
	}

	@Override
	public TurnoComida modificar(TurnoComida obj) {
		return repo.save(obj);
	}

	@Override
	public List<TurnoComida> listar() {
		return repo.findAll();
	}

	@Override
	public TurnoComida leerPorId(Integer id) {
		 Optional<TurnoComida> op = repo.findById(id);
		 return op.isPresent() ? op.get() : new TurnoComida();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
