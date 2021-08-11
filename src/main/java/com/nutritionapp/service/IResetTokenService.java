package com.nutritionapp.service;

import com.nutritionapp.model.ResetToken;

public interface IResetTokenService{

	ResetToken findByToken(String token);
	
	void guardar(ResetToken token);
	
	void eliminar(ResetToken token);

}
