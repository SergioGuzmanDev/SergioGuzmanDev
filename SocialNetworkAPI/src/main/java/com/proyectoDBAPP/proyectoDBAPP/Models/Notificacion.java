package com.proyectoDBAPP.proyectoDBAPP.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "notificaciones")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha_notificacion")
    private String fecha_notificacion;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "tipo_notificacion")
    private String tipo_notificacion;
    

    public String getTipo_notificacion() {
        return tipo_notificacion;
    }
    public void setTipo_notificacion(String tipo_notificacion) {
        this.tipo_notificacion = tipo_notificacion;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public int getId() {
        return id;
    }
    public void setId(int id_notificacion) {
        this.id = id_notificacion;
    }

    public String getFecha_notificacion() {
        return fecha_notificacion;
    }
    public void setFecha_notificacion(String fecha_notificacion) {
        this.fecha_notificacion = fecha_notificacion;
    }

    @Override public String toString() { 
        return "Notificacion [id_notificacion=" + id + 
        ", fecha_notificacion=" + fecha_notificacion + "]"; 
    }

}
