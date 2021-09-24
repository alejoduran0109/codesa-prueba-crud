package com.pruebacodesa.service;

import java.util.List;

import com.pruebacodesa.model.Rol;

public interface IRolService {

	
	List<Rol> listar();
	
	Rol creteRol(Rol rol);
	Rol updateRol(Rol rol);
	
	void deleteRol(Integer idrol);
	
	Rol listId(Integer idrol);
}
