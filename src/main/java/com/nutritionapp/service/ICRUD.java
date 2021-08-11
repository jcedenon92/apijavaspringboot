package com.nutritionapp.service;

import java.util.List;

public interface ICRUD<T> {

	//^POST
	T registrar(T obj);
	//PUT
	T modificar(T obj);
	//GET
	List<T> listar();
	//GET
	T leerPorId(Integer id);
	//DELETE
	boolean eliminar(Integer id);
	//GET
	//validar(T obj)
}
