package com.proyectodam.biblioteca.dto;

public class Asistente{
    private int id_asistente;
    private String nombre;
    private String especialidad;
    private String telefono;
    private String direccion;
    private String email;
    

    public Asistente(int id_asistente, String nombre, String especialidad, String telefono, String direccion, String email) {
    this.id_asistente = id_asistente;
    this.nombre = nombre;
    this.especialidad = especialidad;
    this.telefono = telefono;
    this.direccion = direccion;
    this.email = email;
}

public Asistente() {
    
}

public int getId_asistente() {
    return id_asistente;
}

public void setId_asistente(int id_asistente) {
    this.id_asistente = id_asistente;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getEspecialidad() {
    return especialidad;
}

public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
}

public String getTelefono() {
    return telefono;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

public String getDireccion() {
    return direccion;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

@Override
public String toString() {
    return "Nombre asistente: " + nombre +  ", Teléfono: "
            + telefono + ".";
}

}