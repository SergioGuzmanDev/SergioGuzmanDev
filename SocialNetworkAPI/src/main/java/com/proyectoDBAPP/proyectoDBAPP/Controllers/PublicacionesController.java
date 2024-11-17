package com.proyectoDBAPP.proyectoDBAPP.Controllers;
import java.util.List;
import java.util.Optional;
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

import com.proyectoDBAPP.proyectoDBAPP.Models.Publicacion;
import com.proyectoDBAPP.proyectoDBAPP.Models.Usuario;
import com.proyectoDBAPP.proyectoDBAPP.Repositories.PublicacionesRepository;
import com.proyectoDBAPP.proyectoDBAPP.Repositories.UsuarioRepository;


@RestController
@RequestMapping("/publicaciones")
public class PublicacionesController {
    @Autowired
    private PublicacionesRepository publicacionesRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Publicacion> getAllPublicaciones(){
        return publicacionesRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> getPublicacionById(@PathVariable Integer id){
        Optional<Publicacion> publicacion = publicacionesRepository.findById(id);
        return publicacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/crear")
    public Publicacion createPublicacion(@PathVariable int id, @RequestBody Publicacion publicacion){
        publicacion.setUsuario(usuarioRepository.findById(id).get());
        return publicacionesRepository.save(publicacion);
    }
    
    @DeleteMapping("/{id}/eliminar")
    public void deletePublicacion(@PathVariable int id){
        Optional<Publicacion> optionalPublicacion = publicacionesRepository.findById(id);
        if(optionalPublicacion.isPresent()){
            publicacionesRepository.delete(optionalPublicacion.get());
        } else {
            throw new IllegalArgumentException("La publicacion con el id: " + id + " no existe");
        }
    }

    }



