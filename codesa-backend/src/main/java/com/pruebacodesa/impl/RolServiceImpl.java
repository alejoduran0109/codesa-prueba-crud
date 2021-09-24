package com.pruebacodesa.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebacodesa.model.Rol;
import com.pruebacodesa.repository.IRolRepository;
import com.pruebacodesa.service.IRolService;

@Service
public class RolServiceImpl implements IRolService{

	
	@Autowired
	IRolRepository repoRol;

	@Override
	public List<Rol> listar() {
		return repoRol.findAll();
	}

	@Override
	public Rol creteRol(Rol rol) {
		return repoRol.save(rol);
	}

	@Override
	public Rol updateRol(Rol rol) {
		
		return repoRol.save(rol);
	}

	@Override
	public void deleteRol(Integer idrol) {
		repoRol.deleteById(idrol);
	}

	@Override
	public Rol listId(Integer idrol) {
		return repoRol.findById(idrol).orElse(null);
	}
	
	


}
