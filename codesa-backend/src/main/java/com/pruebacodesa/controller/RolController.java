package com.pruebacodesa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebacodesa.model.Rol;
import com.pruebacodesa.service.IRolService;

@RestController
@RequestMapping("/rol")
public class RolController {
	
	@Autowired
	IRolService service;
	
	@GetMapping
	public ResponseEntity<List<Rol>> listar(){
		List<Rol> obj = service.listar();
		return new ResponseEntity<List<Rol>>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Rol> creteRol (@RequestBody Rol rol){
		Rol obj = service.creteRol(rol);
		return new ResponseEntity<Rol>(obj, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Rol>  updateRol( @RequestBody Rol rol){
		Rol obj = service.updateRol(rol);
		return new ResponseEntity<Rol>(obj, HttpStatus.OK);
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRol (Integer id) throws Exception{
		Rol obj = service.listId(id);
		if(obj == null) {
			throw new Exception("No se encuentra el id");
		}
		service.deleteRol(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
