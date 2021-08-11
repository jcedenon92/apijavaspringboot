package com.nutritionapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritionapp.dto.ControlResumenDTO;
import com.nutritionapp.model.Control;
import com.nutritionapp.repo.IControlRepo;
import com.nutritionapp.service.IControlService;

@Service
public class ControlServiceImpl implements IControlService{

	@Autowired
	private IControlRepo repo;
	 
	@Override
	public Control registrar(Control obj) {
		return repo.save(obj);
	}

	@Override
	public Control modificar(Control obj) {
		return repo.save(obj);
	}

	@Override
	public List<Control> listar() {
		return repo.findAll();
	}

	@Override
	public Control leerPorId(Integer id) {
		 Optional<Control> op = repo.findById(id);
		 return op.isPresent() ? op.get() : new Control();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<ControlResumenDTO> listarResumen() {
		List<ControlResumenDTO> controles = new ArrayList<>();
		
		repo.listarResumen().forEach(x -> {
			ControlResumenDTO cr = new ControlResumenDTO();
			cr.setPeso(Double.parseDouble(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[1]));
			controles.add(cr);
		});
		return controles;
	}

}
