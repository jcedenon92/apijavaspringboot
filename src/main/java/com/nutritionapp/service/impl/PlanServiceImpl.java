package com.nutritionapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritionapp.model.Plan;
import com.nutritionapp.repo.IPlanRepo;
import com.nutritionapp.service.IPlanService;

@Service
public class PlanServiceImpl implements IPlanService{

	@Autowired
	private IPlanRepo repo;
	 
	@Override
	public Plan registrar(Plan obj) {
		obj.getLstDetallePlanes().forEach(det ->{
			det.setPlan(obj);
		});
		return repo.save(obj);
	}

	@Override
	public Plan modificar(Plan obj) {
		return repo.save(obj);
	}

	@Override
	public List<Plan> listar() {
		return repo.findAll();
	}

	@Override
	public Plan leerPorId(Integer id) {
		 Optional<Plan> op = repo.findById(id);
		 return op.isPresent() ? op.get() : new Plan();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
