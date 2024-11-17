package com.proyectoDBAPP.proyectoDBAPP.Repositories;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyectoDBAPP.proyectoDBAPP.Models.Seguidor;
import com.proyectoDBAPP.proyectoDBAPP.Models.Usuario;

public interface SeguidoresRepository extends JpaRepository<Seguidor, Integer> {
    //@Query("INSERT INTO seguidores (seguidor_id, seguido_id) VALUES (seguidor_id_value, seguido_id_value);")
    //public void insertSeguidor(@Param("seguidor_id_value") int seguidor_id_value, @Param("seguido_id_value") int seguido_id_value);
    default void insertSeguidor(int seguidor_id_value, int seguido_id_value) {
        Seguidor seguidor = new Seguidor();
        
        Usuario seguidorUser = new Usuario();
        seguidor.setSeguidor(seguidorUser);
        seguidor.setSeguidorId(seguidor_id_value);
        
        Usuario seguidoUser = new Usuario();
        seguidor.setSeguido(seguidoUser);
        seguidor.setSeguidoId(seguido_id_value);
        save(seguidor);
    }

    default List<Seguidor> findBySeguidoId(int seguidoId){
        return findAll().stream().filter(s -> s.getSeguido().getId() == seguidoId).collect(Collectors.toList());
    }
}
