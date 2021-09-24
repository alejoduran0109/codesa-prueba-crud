package com.pruebacodesa.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebacodesa.model.User;
import com.pruebacodesa.repository.IUserRepository;
import com.pruebacodesa.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository repouser;
	
	@Override
	public List<User> getAllUser() {
		
		return repouser.findAll();
	}

	@Override
	public User createUser(User user) {
		return repouser.save(user);
	}

	@Override
	public User updateUser(User user) {
		return repouser.save(user);
	}

	@Override
	public void deleteUser(Integer codigo) {
		repouser.deleteById(codigo);
		
	}

	@Override
	public User listId(Integer codigo) {
		return repouser.findById(codigo).orElse(null);
	}

}
