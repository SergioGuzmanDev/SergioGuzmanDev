package com.proyectodam.biblioteca;

import javax.swing.SwingUtilities;

import com.proyectodam.biblioteca.ui.AncianoGUI;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AncianoGUI gui = new AncianoGUI();
            gui.setVisible(false);
        }); 
    }
}
//Estan añadidos los txt de modificar asistente pero no se han implementado en la interfaz

//para asociar cambiar base de datos para q la primary key sea normal y no una foreign key