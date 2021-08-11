package com.nutritionapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritionapp.model.DetallePlan;
import com.nutritionapp.repo.IDetallePlanRepo;
import com.nutritionapp.service.IDetallePlanService;

@Service
public class DetallePlanImpl implements IDetallePlanService{

	@Autowired
	private IDetallePlanRepo repo;
	
	@Override
	public DetallePlan registrar(DetallePlan obj) {
		return repo.save(obj);
	}

	@Override
	public DetallePlan modificar(DetallePlan obj) {
		return repo.save(obj);
	}

	@Override
	public List<DetallePlan> listar() {
		return repo.findAll();
	}

	@Override
	public DetallePlan leerPorId(Integer id) {
		Optional<DetallePlan> op = repo.findById(id);
		return op.isPresent() ? op.get() : new DetallePlan();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return false;
	}

}
