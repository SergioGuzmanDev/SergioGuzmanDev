package com.proyectoDBAPP.proyectoDBAPP.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyectoDBAPP.proyectoDBAPP.Models.Publicacion;


public interface PublicacionesRepository extends JpaRepository<Publicacion, Integer>{

}