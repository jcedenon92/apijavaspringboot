package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.Usuario;

//@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

	//select * from usuario where username = ?
	Usuario findOneByUsername(String username);
}
