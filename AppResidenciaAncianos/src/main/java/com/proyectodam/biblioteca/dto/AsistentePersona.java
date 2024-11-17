package com.proyectodam.biblioteca.dto;
public class AsistentePersona {
    private int personaId;
    private int asistenteId;
    
    public AsistentePersona() {
    
    }

    public AsistentePersona(int personaId, int asistenteId) {
        this.personaId = personaId;
        this.asistenteId = asistenteId;
    }
    
    public int getPersonaId() {
        return personaId;
    }
    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }
    public int getAsistenteId() {
        return asistenteId;
    }
    public void setAsistenteId(int asistenteId) {
        this.asistenteId = asistenteId;
    }
    
}