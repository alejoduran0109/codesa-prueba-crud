package com.pruebacodesa.controller;

import java.net.URI;
import java.util.List;

import javax.tools.DocumentationTool.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pruebacodesa.model.User;
import com.pruebacodesa.service.IUserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	
	@GetMapping
	public ResponseEntity<List<User>> listUser(){
		List<User> obj = service.getAllUser();
		return new ResponseEntity<List<User>>(obj, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<User> creteRol (@RequestBody User user){
		User obj = service.createUser(user);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getIdUsuario()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<User>  updateRol( @RequestBody User user){
		User obj = service.updateUser(user);
		return new ResponseEntity<User>(obj, HttpStatus.OK);
	
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Void> deleteUser (@PathVariable Integer id) throws Exception{
		System.out.println(id);
		User obj = service.listId(id);

		if(obj == null) {
			throw new Exception("No se encuentra el id");
		}
		service.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<User> listId(@PathVariable("id") Integer codigo ) throws Exception{
		User obj = service.listId(codigo);
		System.out.println(obj);
		if(obj == null) {
			throw new Exception("No se encontro ID");
		}
		return new ResponseEntity<User>(obj, HttpStatus.OK);
	}

}
