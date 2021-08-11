package com.nutritionapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritionapp.model.Rol;
import com.nutritionapp.repo.IRolRepo;
import com.nutritionapp.service.IRolService;

@Service
public class RolServiceImpl implements IRolService{

	@Autowired
	private IRolRepo repo;
	 
	@Override
	public Rol registrar(Rol obj) {
		return repo.save(obj);
	}

	@Override
	public Rol modificar(Rol obj) {
		return repo.save(obj);
	}

	@Override
	public List<Rol> listar() {
		return repo.findAll();
	}

	@Override
	public Rol leerPorId(Integer id) {
		 Optional<Rol> op = repo.findById(id);
		 return op.isPresent() ? op.get() : new Rol();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
