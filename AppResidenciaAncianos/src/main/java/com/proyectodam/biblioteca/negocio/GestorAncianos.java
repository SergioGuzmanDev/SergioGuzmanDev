package com.proyectodam.biblioteca.negocio;

import com.proyectodam.biblioteca.dao.AsistenteDAO;
import com.proyectodam.biblioteca.dao.AsistentePersonaDAO;
import com.proyectodam.biblioteca.dao.PadecimientoDAO;
import com.proyectodam.biblioteca.dao.PadecimientoPersonaDAO;
import com.proyectodam.biblioteca.dao.PersonaDAO;


import com.proyectodam.biblioteca.dto.Asistente;
import com.proyectodam.biblioteca.dto.AsistentePersona;
import com.proyectodam.biblioteca.dto.Padecimiento;
import com.proyectodam.biblioteca.dto.PadecimientoPersona;
import com.proyectodam.biblioteca.dto.Persona;


public class GestorAncianos {
    private PersonaDAO personaDAO = new PersonaDAO();
    private AsistenteDAO asistenteDAO = new AsistenteDAO();
    private AsistentePersonaDAO asistentePersonaDAO = new AsistentePersonaDAO();

    // Métodos para AsistentePersona
    public boolean agregarAsistentePersona(AsistentePersona asistentePersona) {
        return asistentePersonaDAO.insertarAsistentePersona(asistentePersona);
    }

    private PadecimientoDAO padecimientoDAO = new PadecimientoDAO();

    // Métodos para personas
    public boolean agregarPersona(Persona persona) {
        return personaDAO.insertarPersona(persona);
    }

    // Métodos para eliminar personas
    public boolean eliminarPersonaPorDNI(Persona persona){
        return personaDAO.eliminarPersonaPorDNI(persona); 
    }

    
    // Métodos para Asistentes
    public boolean agregarAsistente(Asistente asistente) {
        return asistenteDAO.insertarAsistente(asistente);
    }

    // Métodos para padecimientos
    public boolean agregarPadecimiento(Padecimiento padecimiento) {
        return padecimientoDAO.agregarPadecimiento(padecimiento);
    }

    public boolean eliminarPadecimiento(Padecimiento padecimiento){
        return padecimientoDAO.eliminarPadecimiento(padecimiento); 
    }

    //Metodo para modificar nombre de una persona
    public boolean actualizarPersona(String antiguoNombre, String nuevoNombre, String nuevaDireccion, String nuevoTelefono, String nuevoEmail){ 
        return personaDAO.actualizarPersona(antiguoNombre,nuevoNombre,nuevaDireccion,nuevoTelefono,nuevoEmail);
    }
    
    //insertar asistente a una persona
    public boolean insertarAsistentePersona(int personaId, int asistenteId) {
        AsistentePersonaDAO asistentePersonaDAO = new AsistentePersonaDAO();
        AsistentePersona asistentePersona = new AsistentePersona(personaId, asistenteId);
        return asistentePersonaDAO.insertarAsistentePersona(asistentePersona);
    }
 //insertar padecimiento a una persona  
    public boolean insertarPersonaPadecimiento(int personaId, int padecimientoId) {
        PadecimientoPersonaDAO padecimientoPersonaDAO = new PadecimientoPersonaDAO();
        PadecimientoPersona padecimientoPersona = new PadecimientoPersona(personaId, padecimientoId);
        return padecimientoPersonaDAO.insertarPadecimientoPersona(padecimientoPersona);
    }

     
} 