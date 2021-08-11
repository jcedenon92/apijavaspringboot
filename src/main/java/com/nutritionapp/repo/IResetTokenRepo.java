package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.ResetToken;

public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer> {
	
	//from ResetToken where token = :?
	ResetToken findByToken(String token);

}
