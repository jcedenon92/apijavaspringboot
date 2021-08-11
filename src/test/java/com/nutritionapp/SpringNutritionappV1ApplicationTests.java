package com.nutritionapp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.nutritionapp.model.Usuario;
import com.nutritionapp.repo.IUsuarioRepo;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringNutritionappV1ApplicationTests {

	@Autowired
	private BCryptPasswordEncoder bcrypt;
		
	@Autowired
	private IUsuarioRepo repo;
		
	@Test
	void contextLoads() {
		Usuario us = new Usuario();
		us.setIdUsuario(3);		
		us.setUsername("prueba@prueba.com");
		us.setPassword(bcrypt.encode("123456"));
		us.setEnabled(true);
		
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
