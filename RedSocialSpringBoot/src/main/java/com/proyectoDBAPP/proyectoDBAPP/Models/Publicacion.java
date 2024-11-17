// Version: 1.0
package com.proyectoDBAPP.proyectoDBAPP.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "publicaciones")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(length = 20)
    private String tipo_publicacion;

    @Column(length = 20)
    private String fecha_publicacion;

    @Column(nullable = false,length = 20)
    private String contenido;

    public int getId() {
        return id;
    }

    public void setId(int id_publicacion) {
        this.id = id_publicacion;
    }

    public String getTipo_publicacion() {
        return tipo_publicacion;
    }

    public void setTipo_publicacion(String tipo_publicacion) {
        this.tipo_publicacion = tipo_publicacion;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
