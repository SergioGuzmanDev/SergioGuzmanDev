package com.proyectodam.biblioteca.dto;

public class Persona {
    private int id_persona;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String dni;
    private String fecha_nacimiento;
    
    public Persona() {
    }

    public Persona(int id_persona, String nombre, String direccion, String telefono, String email, String dni,
            String fecha_nacimiento) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getId_persona() {
        return id_persona;
    }
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getfecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setfecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    @Override
    public String toString() {
        return "Nombre Paciente: " + nombre + ", Teléfono:"
                + telefono + ".";
    }
    
}
