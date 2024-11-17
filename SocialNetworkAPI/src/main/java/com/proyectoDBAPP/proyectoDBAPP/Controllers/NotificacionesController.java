package com.proyectoDBAPP.proyectoDBAPP.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoDBAPP.proyectoDBAPP.Models.Notificacion;
import com.proyectoDBAPP.proyectoDBAPP.Repositories.NotificacionesRepository;
import com.proyectoDBAPP.proyectoDBAPP.Repositories.UsuarioRepository;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {

    @Autowired
    private NotificacionesRepository notificacionesRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/prueba")
    public String prueba() {
        return "PRUEBA";
    }

    @GetMapping
    public List<Notificacion> getAllNotificaciones() {
        return notificacionesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> getNotificacionById(@PathVariable int id) {
        Optional<Notificacion> notificacion = notificacionesRepository.findById(id);
        return notificacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/crear")
    public Notificacion createNotificacion(@PathVariable int id, @RequestBody Notificacion notificacion){
        notificacion.setUsuario(usuarioRepository.findById(id).get());
        return notificacionesRepository.save(notificacion);
    }

}
