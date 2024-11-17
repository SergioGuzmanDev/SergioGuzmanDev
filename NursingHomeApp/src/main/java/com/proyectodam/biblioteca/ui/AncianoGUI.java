package com.proyectodam.biblioteca.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// Import the JComboBox class
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.proyectodam.biblioteca.dao.AsistenteDAO;
import com.proyectodam.biblioteca.dao.Conexion;
import com.proyectodam.biblioteca.dao.PadecimientoDAO;
import com.proyectodam.biblioteca.dao.PersonaDAO;
import com.proyectodam.biblioteca.dto.Asistente;
import com.proyectodam.biblioteca.dto.Padecimiento;
import com.proyectodam.biblioteca.dto.Persona;
import com.proyectodam.biblioteca.negocio.GestorAncianos;

public class AncianoGUI extends JFrame {
    private PersonaDAO personaDAO = new PersonaDAO();
    private AsistenteDAO asistenteDAO = new AsistenteDAO();
    private GestorAncianos gestorAncianos = new GestorAncianos();
    private PadecimientoDAO padecimientoDAO = new PadecimientoDAO();

    private JTextField txtAsistenteEmail, txtAsistenteTelefono, txtAsistenteEspecialidad, txtAsistenteDireccion,
            txtPersonaDni, txtPersonaTelefono,
            txtPersonaEmail, txtPersonaNombre, txtPersonaDireccion, txtPadecimientoId, txtPersonaId,
            txtPersonaIdPadecimiento, txtAsistenteId, txtAsistenteNombre, txtPadecimientoPersona,
            txtEliminarNombrePersona, txtModificarDireccionPersona, txtPadecimientoEliminar, txtPadecimientoNombre,
            txtPadecimientoDescripcion,
            txtPadecimientoGravedad, txtPersonaDniEliminar, txtModificarTelefonoPersona, txtNuevoNombrePersona,
            txtAsistenteEliminar, txtModificarFechaNacimientoPersona, txtModificarDniPersona, txtModificarEmailPersona,
            txtPersonafecha_nacimiento,
            txtAntiguoNombrePersona, txtNuevaDireccionPersona, txtNuevoTelefonoPersona, txtNuevoEmailPersona,
            txtNuevoNombreAsistente, txtNuevaDireccionAsistente, txtNuevoTelefonoAsistente, txtNuevoEmailAsistente,
            txtPadecimientoModificar, txtAntiguoNombreAsistente, txtNuevaEspecialidadAsistente;
    
    private JButton btnAgregarPersona;
    private JButton btnAgregarAsistente;
    private JButton btnEliminarPersona;
    private JButton btnEliminarAsistente;
    private JButton btnActualizarPersona;

    private JComboBox<Persona> comboPersonasModificar = new JComboBox<>(new DefaultComboBoxModel<>());
    private JComboBox<Persona> comboPersonasEliminar = new JComboBox<>(new DefaultComboBoxModel<>());
    private JComboBox<Persona> comboPersonasDatos = new JComboBox<>(new DefaultComboBoxModel<>());
    private JComboBox<Asistente> comboAsistentesModificar = new JComboBox<>(new DefaultComboBoxModel<>());
    private JComboBox<Asistente> comboAsistentesEliminar = new JComboBox<>(new DefaultComboBoxModel<>());
    private JComboBox<Asistente> comboAsistentesDatos = new JComboBox<>(new DefaultComboBoxModel<>());
    private JComboBox<Padecimiento> comboPadecimientosModificar = new JComboBox<>(new DefaultComboBoxModel<>());
    private JComboBox<Padecimiento> comboPadecimientosEliminar = new JComboBox<>(new DefaultComboBoxModel<>());
    
   
    // show personas
    public AncianoGUI() {
        initUI();
    }

    private void initUI() {
        // DESPLEGABLE PADECIMIENTOS
        comboPadecimientosModificar = new JComboBox<>(new DefaultComboBoxModel<>());
        comboPadecimientosEliminar = new JComboBox<>(new DefaultComboBoxModel<>());

        // Desplegable de Personas
        comboPersonasModificar = new JComboBox<>(new DefaultComboBoxModel<>());
        comboPersonasEliminar = new JComboBox<>(new DefaultComboBoxModel<>());
        comboPersonasDatos = new JComboBox<>(new DefaultComboBoxModel<>());

        // Desplegable de Asistentes
        comboAsistentesModificar = new JComboBox<>(new DefaultComboBoxModel<>());
        comboAsistentesEliminar = new JComboBox<>(new DefaultComboBoxModel<>());
        comboAsistentesDatos = new JComboBox<>(new DefaultComboBoxModel<>());


        // Pestañas pendejas
        JFrame frame = new JFrame("Sistema de Gestión de Pacientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(290, 800);

        // Crear un JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Crear paneles para las pestañas
        JPanel personas = new JPanel();
        JPanel asistentes = new JPanel();
        JPanel padecimientos = new JPanel();
        JPanel compuestas = new JPanel();
        JPanel contactos = new JPanel();
       

        // Agregar contenido a los paneles

        // Pestaña Modificar Persona
        // ___________________________________________________________________________________________________________________________
        comboPersonasModificar = new JComboBox<>();
        JPanel panelModificar = new JPanel(new GridLayout(0, 2));
        txtEliminarNombrePersona = new JTextField();
        JButton btnModificarPersona = new JButton("Modificar Persona");
        btnModificarPersona.addActionListener(e -> actualizarPersona());
        // __________________________________________________________________________________________________________________________________________________________
        // Agregar los paneles como pestañas al JTabbedPane
        tabbedPane.addTab("Persona", personas);
        tabbedPane.addTab("Asistentes", asistentes);
        tabbedPane.addTab("Padecimientos", padecimientos);
        tabbedPane.addTab("Compuestas", compuestas);
        tabbedPane.addTab("Contactos", contactos);

        frame.add(tabbedPane);
        frame.setVisible(true);

        // Sección de Personas
        personas.add(new JLabel("Nombre de la Persona:")); // Nombre
        personas.add(txtPersonaNombre = new JTextField());
        txtPersonaNombre.setColumns(20);
        personas.add(txtPersonaNombre);

        personas.add(new JLabel("Direccion de la Persona:")); // Direccion
        personas.add(txtPersonaDireccion = new JTextField());
        txtPersonaDireccion.setColumns(20);
        personas.add(txtPersonaDireccion);

        personas.add(new JLabel("Telefono de la Persona:")); // Telefono
        personas.add(txtPersonaTelefono = new JTextField());
        txtPersonaTelefono.setColumns(20);
        personas.add(txtPersonaTelefono);

        personas.add(new JLabel("email de la Persona:")); // email
        personas.add(txtPersonaEmail = new JTextField());
        txtPersonaEmail.setColumns(20);
        personas.add(txtPersonaEmail);

        personas.add(new JLabel("dni de la Persona:")); // dni
        personas.add(txtPersonaDni = new JTextField());
        txtPersonaDni.setColumns(20);
        personas.add(txtPersonaDni);

        personas.add(new JLabel("Fecha de nacimiento de la Persona:")); // edad
        personas.add(txtPersonafecha_nacimiento = new JTextField());
        txtPersonafecha_nacimiento.setColumns(20);
        personas.add(txtPersonafecha_nacimiento);

        personas.add(btnAgregarPersona = new JButton("Agregar Persona"));
        btnAgregarPersona.addActionListener(this::agregarPersona);
        personas.add(btnAgregarPersona);

        // Eliminar persona
        // Setting up the delete button action

        personas.add(new JLabel("dni de la Persona a eliminar:")); // dni
        personas.add(txtPersonaDniEliminar = new JTextField());
        txtPersonaDniEliminar.setColumns(20);

        personas.add(txtPersonaDniEliminar);

        personas.add(txtPersonaDniEliminar);
        personas.add(comboPersonasEliminar);

        personas.add(btnEliminarPersona = new JButton("Eliminar Persona"));
        btnEliminarPersona.addActionListener(e -> eliminarPersonaPorDNI());

        // Modificar persona

        personas.add(new JLabel("Antiguo nombre de la Persona a modificar:")); // antiguo nombre
        personas.add(txtAntiguoNombrePersona = new JTextField());
        txtAntiguoNombrePersona.setColumns(20);
        personas.add(txtAntiguoNombrePersona);

        personas.add(new JLabel("Nuevo nombre de la Persona a modificar:")); // nuevo nombre
        personas.add(txtNuevoNombrePersona = new JTextField());
        txtNuevoNombrePersona.setColumns(20);
        personas.add(txtNuevoNombrePersona);

        personas.add(new JLabel("Nueva dirección de la Persona a modificar:")); // nueva dirección
        personas.add(txtNuevaDireccionPersona = new JTextField());
        txtNuevaDireccionPersona.setColumns(20);
        personas.add(txtNuevaDireccionPersona);

        personas.add(new JLabel("Nuevo teléfono de la Persona a modificar:")); // nuevo teléfono
        personas.add(txtNuevoTelefonoPersona = new JTextField());
        txtNuevoTelefonoPersona.setColumns(20);
        personas.add(txtNuevoTelefonoPersona);

        personas.add(new JLabel("Nuevo email de la Persona a modificar:")); // nuevo email
        personas.add(txtNuevoEmailPersona = new JTextField());
        txtNuevoEmailPersona.setColumns(20);
        personas.add(txtNuevoEmailPersona);

        // __________________________________________________________________________________________________________________________________________________________
        personas.add(btnActualizarPersona = new JButton("Actualizar Persona"));
        btnActualizarPersona.addActionListener(e -> actualizarPersona());
        personas.add(btnActualizarPersona);
        // __________________________________________________________________________________________________________________________________________________________

        // Padecimiento
        padecimientos.add(new JLabel("Nombre del Padecimiento:")); // nombre_padecimiento
        padecimientos.add(txtPadecimientoNombre = new JTextField());
        txtPadecimientoNombre.setColumns(20);
        padecimientos.add(txtPadecimientoNombre);

        padecimientos.add(new JLabel("Descripción del Padecimiento:")); // descripcion
        padecimientos.add(txtPadecimientoDescripcion = new JTextField());
        txtPadecimientoDescripcion.setColumns(20);
        padecimientos.add(txtPadecimientoDescripcion);

        padecimientos.add(new JLabel("Gravedad del Padecimiento:")); // gravedad
        padecimientos.add(txtPadecimientoGravedad = new JTextField());
        txtPadecimientoGravedad.setColumns(20);
        padecimientos.add(txtPadecimientoGravedad);

        JButton btnAgregarPadecimiento = new JButton("Agregar padecimiento");
        btnAgregarPadecimiento.addActionListener(this::agregarPadecimiento);
        padecimientos.add(btnAgregarPadecimiento);

        comboPadecimientosModificar = new JComboBox<>();

        padecimientos.add(new JLabel("Desplegable de padecimientos"));
        padecimientos.add(comboPadecimientosModificar = new JComboBox<Padecimiento>());
        comboPadecimientosModificar.setBounds(10, 10, 80, 20);
        padecimientos.add(comboPadecimientosModificar);

        padecimientos.add(new JLabel("Nombre del Padecimiento a eliminar")); // Email
        padecimientos.add(txtPadecimientoEliminar = new JTextField());
        txtPadecimientoEliminar.setColumns(20);
        padecimientos.add(txtPadecimientoEliminar);

        JButton btnEliminarPadecimiento = new JButton("Eliminar Padecimiento"); // Declare and initialize the variable
        padecimientos.add(btnEliminarPadecimiento); // Add the button to the padecimientos list
        btnEliminarPadecimiento.addActionListener(e -> eliminarPadecimiento());

        // Asistente
        asistentes.add(new JLabel("Nombre del Asistente")); // Nombre
        asistentes.add(txtAsistenteNombre = new JTextField());
        txtAsistenteNombre.setColumns(20);
        asistentes.add(txtAsistenteNombre);

        asistentes.add(new JLabel("Direccion del Asistente")); // Direccion
        asistentes.add(txtAsistenteDireccion = new JTextField());
        txtAsistenteDireccion.setColumns(20);
        asistentes.add(txtAsistenteDireccion);

        asistentes.add(new JLabel("especialidad del Asistente")); // especialidad
        asistentes.add(txtAsistenteEspecialidad = new JTextField());
        txtAsistenteEspecialidad.setColumns(20);
        asistentes.add(txtAsistenteEspecialidad);

        asistentes.add(new JLabel("telefono del Asistente")); // Telefono
        asistentes.add(txtAsistenteTelefono = new JTextField());
        txtAsistenteTelefono.setColumns(20);
        asistentes.add(txtAsistenteTelefono);

        asistentes.add(new JLabel("email del Asistente")); // Email
        asistentes.add(txtAsistenteEmail = new JTextField());
        txtAsistenteEmail.setColumns(20);
        asistentes.add(txtAsistenteEmail);

        asistentes.add(btnAgregarAsistente = new JButton("Agregar Asistente")); // Asistente
        btnAgregarAsistente.addActionListener(this::agregarAsistente);
        asistentes.add(btnAgregarAsistente);

        // Modificar Asistente
        asistentes.add(new JLabel("Antiguo nombre del Asistente a modificar:")); // antiguo nombre
        asistentes.add(txtAntiguoNombreAsistente = new JTextField());
        txtAntiguoNombreAsistente.setColumns(20);
        asistentes.add(txtAntiguoNombreAsistente);

        asistentes.add(new JLabel("Nuevo nombre del Asistente a modificar:")); // nuevo nombre
        asistentes.add(txtNuevoNombreAsistente = new JTextField());
        txtNuevoNombreAsistente.setColumns(20);
        asistentes.add(txtNuevoNombreAsistente);

        asistentes.add(new JLabel("Nueva especialidad del Asistente a modificar:")); // nueva especialidad
        asistentes.add(txtNuevaEspecialidadAsistente = new JTextField());
        txtNuevaEspecialidadAsistente.setColumns(20);
        asistentes.add(txtNuevaEspecialidadAsistente);

        asistentes.add(new JLabel("Nueva dirección del Asistente a modificar:")); // nueva dirección
        asistentes.add(txtNuevaDireccionAsistente = new JTextField());
        txtNuevaDireccionAsistente.setColumns(20);
        asistentes.add(txtNuevaDireccionAsistente);

        asistentes.add(new JLabel("Nuevo teléfono del Asistente a modificar:")); // nuevo teléfono
        asistentes.add(txtNuevoTelefonoAsistente = new JTextField());
        txtNuevoTelefonoAsistente.setColumns(20);
        asistentes.add(txtNuevoTelefonoAsistente);

        asistentes.add(new JLabel("Nuevo email del Asistente a modificar:")); // nuevo email
        asistentes.add(txtNuevoEmailAsistente = new JTextField());
        txtNuevoEmailAsistente.setColumns(20);
        asistentes.add(txtNuevoEmailAsistente);

        // Pestaña Modificar Asistente
        comboAsistentesModificar = new JComboBox<>();
        JButton btnModificarAsistente = new JButton("Modificar asistente");
        btnModificarAsistente.addActionListener(e -> actualizarAsistente());
        asistentes.add(btnModificarAsistente);
        // __________________________________________________________________________________________________________________________________________________________

        // Eliminar Asistente
        asistentes.add(new JLabel("nombre del Asistente a eliminar:")); // dni
        asistentes.add(txtAsistenteEliminar = new JTextField());
        txtAsistenteEliminar.setColumns(20);
        asistentes.add(btnEliminarAsistente = new JButton("Eliminar Asistente"));
        btnEliminarAsistente.addActionListener(e -> eliminarAsistente());

        // Desplegable de Asistentes
        asistentes.add(new JLabel("Desplegable de asistentes"));
        asistentes.add(comboAsistentesEliminar); // comboPersonasModificar = new JComboBox<Persona>()
        comboAsistentesEliminar.setBounds(10, 10, 80, 20);
        asistentes.add(comboAsistentesEliminar);

        //Desplegable contactos

        contactos.add(new JLabel("Desplegable de personas"));
        contactos.add(comboPersonasEliminar); // comboPersonasModificar = new JComboBox<Persona>()
        comboAsistentesEliminar.setBounds(10, 10, 80, 20);
        contactos.add(comboPersonasEliminar);

        comboAsistentesDatos = new JComboBox<>(); 
        contactos.add(new JLabel("Desplegable de asistentes"));
        contactos.add(comboAsistentesEliminar);
        comboAsistentesDatos.setBounds(10, 30, 80, 20);
        contactos.add(comboAsistentesEliminar);
      
        //--------------------COMPUESTAS--------------------------------
        


        
        
        // Añade un botón para asociar personas con asistentes
        JButton btnAsociarPersonaAsistente = new JButton("Asociar asistente");
        txtPersonaId = new JTextField();
        txtAsistenteId = new JTextField();
        compuestas.add(new JLabel("ID de la Persona:"));
        txtPersonaId.setColumns(20);
        compuestas.add(txtPersonaId);
        compuestas.add(new JLabel("ID del Asistente:"));
        compuestas.add(txtAsistenteId);
        txtAsistenteId.setColumns(20);
        btnAsociarPersonaAsistente.addActionListener(this::asociarAsistentePersona);
        compuestas.add(btnAsociarPersonaAsistente);
        txtPersonaNombre.setColumns(20);
        txtAsistenteNombre.setColumns(20);

        compuestas.add(new JLabel("Asociar Padecimiento con Persona:")); // Asociar Padecimiento Persona
        JButton btnAsociarPersonaPadecimiento = new JButton("Asociar padecimiento");
        txtPersonaIdPadecimiento = new JTextField();
        txtPadecimientoId = new JTextField();
        compuestas.add(new JLabel("ID de la persona:"));
        txtPersonaIdPadecimiento.setColumns(20);
        compuestas.add(txtPersonaIdPadecimiento);
        compuestas.add(new JLabel("ID del Padecimiento:"));
        compuestas.add(txtPadecimientoId);
        btnAsociarPersonaPadecimiento.addActionListener(this::asociarPersonaPadecimiento);
        compuestas.add(btnAsociarPersonaPadecimiento);
        txtPersonaId.setColumns(20);
        txtPadecimientoId.setColumns(20);

        // Desplegable de Padecimientos
        compuestas.add(new JLabel("Desplegable de padecimientos"));
        compuestas.add(comboPadecimientosEliminar = new JComboBox<Padecimiento>()); // si FUNCIONA
        comboPadecimientosEliminar.setBounds(10, 10, 80, 20);
        compuestas.add(comboPadecimientosEliminar);

        // Desplegable de Asistentes
        compuestas.add(new JLabel("Desplegable de asistentes"));
        compuestas.add(comboAsistentesModificar = new JComboBox<Asistente>());
        comboAsistentesModificar.setBounds(10, 30, 80, 20);
        compuestas.add(comboAsistentesModificar);

        // Desplegable de Personas
        compuestas.add(new JLabel("Desplegable de personas"));
        compuestas.add(comboPersonasModificar = new JComboBox<Persona>());
        comboPersonasModificar.setBounds(10, 30, 80, 20);
        compuestas.add(comboPersonasModificar);

        // INSERCCION DE GRAFICO
        ChartPanel pieChartPanel = createPieChartPanel();
        compuestas.add(pieChartPanel);

        cargarPersonas();
        cargarAsistentes();
        cargarPadecimientos(); 
        }

    


    // ___________________________PIE CHART (GRAFICO DE TARTA)________________________________________________
    private DefaultPieDataset getPieDatasetFromDB() {
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        try (Connection connection = Conexion.getConnection()) {
            // Consulta para obtener el número de personas
            try (PreparedStatement statement1 = connection
                    .prepareStatement("SELECT COUNT(*) AS total_personas FROM personas");
                    ResultSet resultSet1 = statement1.executeQuery()) {
                if (resultSet1.next()) {
                    dataset.setValue("Personas", resultSet1.getInt("total_personas"));
                }
            }

            // Consulta para obtener el número de asistentes
            try (PreparedStatement statement2 = connection
                    .prepareStatement("SELECT COUNT(*) AS total_asistentes FROM asistentes");
                    ResultSet resultSet2 = statement2.executeQuery()) {
                if (resultSet2.next()) {
                    dataset.setValue("Asistentes", resultSet2.getInt("total_asistentes"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataset;
    }

    private ChartPanel createPieChartPanel() {
        DefaultPieDataset dataset = getPieDatasetFromDB();

        JFreeChart chart = ChartFactory.createPieChart(
                "Personas/Asistentes",
                dataset,
                true, true, false);

        return new ChartPanel(chart);
    }

    // ______________________________________________________________________________________________________
    private void actualizarPersona() {
        Persona persona = (Persona) comboPersonasModificar.getSelectedItem();
        String nuevoNombre = txtNuevoNombrePersona.getText();
        String antiguoNombre = txtAntiguoNombrePersona.getText();
        String direccion = txtNuevaDireccionPersona.getText();
        String telefono = txtNuevoTelefonoPersona.getText();
        String email = txtNuevoEmailPersona.getText();
        if (persona != null && !antiguoNombre.isEmpty()) {
            persona.setNombre(nuevoNombre);
            if (personaDAO.actualizarPersona(antiguoNombre, nuevoNombre, direccion, telefono, email)) {
                JOptionPane.showMessageDialog(this, "Persona modificado exitosamente.");
                cargarPersonas();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar autor, persona o nombre antiguo vacío.");
            }
        }

    }

    private void actualizarAsistente() {
        Asistente asistente = (Asistente) comboAsistentesModificar.getSelectedItem();
        String nuevoNombre = txtNuevoNombreAsistente.getText();
        String antiguoNombre = txtAntiguoNombreAsistente.getText();
        String especialidad = txtNuevaEspecialidadAsistente.getText();
        String direccion = txtNuevaDireccionAsistente.getText();
        String telefono = txtNuevoTelefonoAsistente.getText();
        String email = txtNuevoEmailAsistente.getText();
        if (asistente != null && !antiguoNombre.isEmpty()) {
            asistente.setNombre(nuevoNombre);
            if (asistenteDAO.actualizarAsistente(antiguoNombre, nuevoNombre, especialidad, direccion, telefono,
                    email)) {
                JOptionPane.showMessageDialog(this, "Asistente modificado exitosamente.");
                cargarAsistentes();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar autor, asistente o nombre antiguo vacío.");
            }
        }
    }

    private void eliminarPersonaPorDNI() {
        Persona persona = (Persona) comboPersonasEliminar.getSelectedItem();
        if (persona != null) {
            if (personaDAO.eliminarPersonaPorDNI(persona)) {
                JOptionPane.showMessageDialog(this, "Personas eliminado exitosamente.");
                cargarPersonas(); // Recargar lista de autores
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar personas");
            }
        }
    }

    private void cargarPersonas() {
        List<Persona> personas = personaDAO.obtenerTodasPersonas();
        comboPersonasModificar.removeAllItems();
        comboPersonasEliminar.removeAllItems();
        for (Persona persona : personas) {
            comboPersonasModificar.addItem(persona);
            comboPersonasEliminar.addItem(persona);
        }
    }

    private void cargarPadecimientos() {
        List<Padecimiento> padecimientos = padecimientoDAO.obtenerTodosPadecimientos();
        comboPadecimientosModificar.removeAllItems();
        comboPadecimientosEliminar.removeAllItems();
        for (Padecimiento padecimiento : padecimientos) {
            comboPadecimientosModificar.addItem(padecimiento);
            comboPadecimientosEliminar.addItem(padecimiento);
        }
    }

    private void cargarAsistentes() {
        List<Asistente> asistentes = asistenteDAO.obtenerTodosAsistentes();
        comboAsistentesModificar.removeAllItems();
        comboAsistentesEliminar.removeAllItems();
        for (Asistente asistente : asistentes) {
            comboAsistentesModificar.addItem(asistente);
            comboAsistentesEliminar.addItem(asistente);
        }
    }

    // Mostrar personas es necesario para asociar personas

    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getSource() == comboAsistentesEliminar) {
            String seleccionado = (String) comboAsistentesEliminar.getSelectedItem();
            setTitle(seleccionado);
        }
    }

    private void agregarPersona(ActionEvent event) {
        String nombre = txtPersonaNombre.getText();
        String direccion = txtPersonaDireccion.getText();
        String telefono = txtPersonaTelefono.getText();
        String email = txtPersonaEmail.getText();
        String dni = txtPersonaDni.getText();
        String fecha_nacimiento = txtPersonafecha_nacimiento.getText();
        Persona persona = new Persona(1, nombre, direccion, telefono, email, dni, fecha_nacimiento);

        if (gestorAncianos.agregarPersona(persona)) {
            DefaultComboBoxModel<Persona> modelModificar = (DefaultComboBoxModel<Persona>) comboPersonasModificar
                    .getModel();
            modelModificar.addElement(persona);

            DefaultComboBoxModel<Persona> modelEliminar = (DefaultComboBoxModel<Persona>) comboPersonasEliminar
                    .getModel();
            modelEliminar.addElement(persona);

            JOptionPane.showMessageDialog(this, "Persona agregada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar Persona.");
        }
    }

    private void agregarAsistente(ActionEvent event) {
        String nombre = txtAsistenteNombre.getText();
        String direccion = txtAsistenteDireccion.getText();
        String telefono = txtAsistenteTelefono.getText();
        String email = txtAsistenteEmail.getText();
        String especialidad = txtAsistenteEspecialidad.getText();

        Asistente asistente = new Asistente(1, nombre, especialidad, telefono, direccion, email);

        if (gestorAncianos.agregarAsistente(asistente)) {
            DefaultComboBoxModel<Asistente> modelModificar = (DefaultComboBoxModel<Asistente>) comboAsistentesModificar
                    .getModel(); // burno
            modelModificar.addElement(asistente);

            DefaultComboBoxModel<Asistente> modelEliminar = (DefaultComboBoxModel<Asistente>) comboAsistentesEliminar
                    .getModel();
            modelEliminar.addElement(asistente);
            JOptionPane.showMessageDialog(this, "Asistente agregado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar Asistente.");
        }
    }

    private void eliminarAsistente() {
        Asistente asistente = (Asistente) comboAsistentesEliminar.getSelectedItem();
        if (asistente != null) {
            if (asistenteDAO.eliminarAsistente(asistente)) {
                JOptionPane.showMessageDialog(this, "Asistente eliminado exitosamente.");
                cargarAsistentes(); // Recargar lista de autores
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar Asistentes");
            }
        }
    }

    private void agregarPadecimiento(ActionEvent event) {
        String nombre = txtPadecimientoNombre.getText();
        String gravedad = txtPadecimientoGravedad.getText();
        String descripcion = txtPadecimientoDescripcion.getText();

        Padecimiento padecimiento = new Padecimiento(1, nombre, gravedad, descripcion);

        if (padecimientoDAO.agregarPadecimiento(padecimiento)) {
            DefaultComboBoxModel<Padecimiento> modelModificar = (DefaultComboBoxModel<Padecimiento>) comboPadecimientosModificar
                    .getModel();
            modelModificar.addElement(padecimiento);

            DefaultComboBoxModel<Padecimiento> modelEliminar = (DefaultComboBoxModel<Padecimiento>) comboPadecimientosEliminar
                    .getModel();
            modelEliminar.addElement(padecimiento);

            JOptionPane.showMessageDialog(this, "Padecimiento agregado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar Padecimiento.");
        }
    }


    private void asociarAsistentePersona(ActionEvent event) {
        try {
            int PersonaId = Integer.parseInt(txtPersonaId.getText());
            int AsistenteId = Integer.parseInt(txtAsistenteId.getText());
            boolean resultado = gestorAncianos.insertarAsistentePersona(PersonaId, AsistenteId);
            if (resultado) {
                JOptionPane.showMessageDialog(this, "Persona asociada con el Asistente ha resultado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al asociar Persona con el Asistente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, asegúrate de que los IDs de Persona y Asistentes sean numéricos.");
        }
    }

    private void asociarPersonaPadecimiento(ActionEvent event) {
        try {
            int PersonaId = Integer.parseInt(txtPersonaIdPadecimiento.getText());
            int AsistenteId = Integer.parseInt(txtPadecimientoId.getText());
            boolean resultado = gestorAncianos.insertarPersonaPadecimiento(PersonaId, AsistenteId);
            if (resultado) {
                JOptionPane.showMessageDialog(this, "Persona asociada con el Asistente ha resultado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al asociar Persona con el Asistente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, asegúrate de que los IDs de Persona y Asistentes sean numéricos.");
        }
    }



    private void eliminarPadecimiento() {
        Padecimiento padecimiento = (Padecimiento) comboPadecimientosEliminar.getSelectedItem();
        if (padecimiento != null) {
            if (padecimientoDAO.eliminarPadecimiento(padecimiento)) {
                JOptionPane.showMessageDialog(this, "Padecimiento eliminado exitosamente.");
                cargarPadecimientos(); // Recargar lista de autores
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar Padecimiento");
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AncianoGUI().setVisible(true));

    }

    // CARGAR PERSONAS, @OVERRIDE DTO, CLASE ELIMINAR GUI, FUNCION ELIMINAR CON
    // CONSULTA DAO

}