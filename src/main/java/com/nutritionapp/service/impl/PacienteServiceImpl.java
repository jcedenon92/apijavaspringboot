package com.nutritionapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nutritionapp.dto.PacienteDosisDTO;
import com.nutritionapp.model.Paciente;
import com.nutritionapp.repo.IPacienteRepo;
import com.nutritionapp.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	private IPacienteRepo repo;
	
	 
	@Override
	public Paciente registrar(Paciente obj) {
		/*obj.getDetallePacienteDosis().forEach(det->{
			det.setPaciente(obj);
		});*/
		return repo.save(obj);
	}

	/*
	@Transactional
	@Override
	public Paciente registrarTransaccional(PacienteDosisDTO dto) {
		dto.getPaciente().getDetallePacienteDosis().forEach(det ->{
			det.setPaciente(dto.getPaciente());
		});
		repo.save(dto.getPaciente());
		
		dto.getLstDosis().forEach(ex -> pdRepo.registrar(dto.getPaciente().getIdPaciente(), ex.getIdDosis()));
		return dto.getPaciente();
	}*/

	@Override
	public Paciente modificar(Paciente obj) {
		return repo.save(obj);
	}

	@Override
	public List<Paciente> listar() {
		return repo.findAll();
	}

	@Override
	public Paciente leerPorId(Integer id) {
		 Optional<Paciente> op = repo.findById(id);
		 return op.isPresent() ? op.get() : new Paciente();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
