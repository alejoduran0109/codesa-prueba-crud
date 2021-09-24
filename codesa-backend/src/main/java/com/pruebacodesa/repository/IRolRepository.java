package com.pruebacodesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebacodesa.model.Rol;
public interface IRolRepository extends JpaRepository<Rol, Integer>  {

}
