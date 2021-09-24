package com.pruebacodesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebacodesa.model.User;

public interface IUserRepository  extends JpaRepository<User, Integer>  {
	
	

}
