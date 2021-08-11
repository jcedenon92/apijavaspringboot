package com.nutritionapp.service;

import java.util.List;

import com.nutritionapp.dto.ControlResumenDTO;
import com.nutritionapp.model.Control;

public interface IControlService extends ICRUD<Control>{
	
	List<ControlResumenDTO> listarResumen();
}
