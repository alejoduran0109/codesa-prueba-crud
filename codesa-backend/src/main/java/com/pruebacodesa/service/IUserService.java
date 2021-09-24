package com.pruebacodesa.service;

import java.util.List;

import com.pruebacodesa.model.User;

public interface IUserService {
	
	List<User> getAllUser();
	
	User createUser(User user);
	User updateUser(User user);
	
	void deleteUser(Integer codigo);
	
	User listId(Integer codigo);
	

}
