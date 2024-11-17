package com.proyectodam.biblioteca.dto;
public class PadecimientoPersona {
    private int id_persona;
    private int id_padecimiento;
    
    
    public PadecimientoPersona(int id_persona, int id_padecimiento) {
        this.id_persona = id_persona;
        this.id_padecimiento = id_padecimiento;
    }
    
    public PadecimientoPersona() {
    }
    
    public int getId_persona() {
        return id_persona;
    }
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }
    public int getId_padecimiento() {
        return id_padecimiento;
    }
    public void setId_padecimiento(int id_padecimiento) {
        this.id_padecimiento = id_padecimiento;
    }
    
    
}