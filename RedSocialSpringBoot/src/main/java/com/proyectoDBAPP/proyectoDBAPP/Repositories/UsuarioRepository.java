package com.proyectoDBAPP.proyectoDBAPP.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectoDBAPP.proyectoDBAPP.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{}