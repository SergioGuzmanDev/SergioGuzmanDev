package com.proyectodam.biblioteca.dto;

public class Padecimiento{
    private int id_padecimiento;
    private String nombre;
    private String descripcion;
    private String gravedad;

    
    public Padecimiento(int id_padecimiento, String nombre, String descripcion, String gravedad) {
        this.id_padecimiento = id_padecimiento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.gravedad = gravedad;
    }

    public int getId_padecimiento() {
        return id_padecimiento;
    }

    public void setId_padecimiento(int id_padecimiento) {
        this.id_padecimiento = id_padecimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Descripción: " + descripcion + ", Gravedad: " + gravedad;
    }
}