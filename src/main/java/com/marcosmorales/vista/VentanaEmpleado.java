package com.marcosmorales.vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaEmpleado extends JFrame {
    public VentanaEmpleado() {
        super("Fitness Pro");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel header = new JPanel(new FlowLayout());
        header.setBackground(Color.GRAY);

        JButton botonAdmSocios = new JButton("Administrar Socios");
        JButton botonMantMaquinas = new JButton("Mantenimiento de Maquinas");
        JButton botonInformacion = new JButton("Informacion");

        header.add(botonAdmSocios);
        header.add(botonMantMaquinas);
        header.add(botonInformacion);
       
        JPanel panelCentral = new JPanel(new CardLayout());

        // Página adm. socios
        JPanel admSociosPanel = new JPanel(new BorderLayout());

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));

        JButton btnAgregar = new JButton("Agregar Socio");
        JButton btnEliminar = new JButton("Eliminar Socio");
        JButton btnValidar = new JButton("Validar membresia");

        btnEliminar.setEnabled(false);
        btnValidar.setEnabled(false);

        panelBotones.add(btnAgregar);
        panelBotones.add(Box.createVerticalStrut(10));
        panelBotones.add(btnEliminar);
        panelBotones.add(Box.createVerticalStrut(10));
        panelBotones.add(btnValidar);

        String[] columnas = {"Nombre", "Apellido", "Membresía"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tablaSocios = new JTable(modeloTabla);

        modeloTabla.addRow(new Object[]{"Bautista", "Lopez", "Activa"});
        modeloTabla.addRow(new Object[]{"Augusto", "Sanchez", "Inactiva"});
        modeloTabla.addRow(new Object[]{"Constantino", "Ruberto", "Activa"});

        tablaSocios.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionado = tablaSocios.getSelectedRow() != -1;
            btnEliminar.setEnabled(seleccionado);
            btnValidar.setEnabled(seleccionado);
        });

        btnValidar.addActionListener(e -> {
            int row = tablaSocios.getSelectedRow();
            if (row != -1) {
                String estado = tablaSocios.getValueAt(row, 2).toString();
                if (estado.equalsIgnoreCase("Activa")) {
                    JOptionPane.showMessageDialog(this, "Membresia válida.");
                } else {
                    JOptionPane.showMessageDialog(this, "Membresia inactiva.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btnAgregar.addActionListener(e -> {
            JTextField nombreField = new JTextField();
            JTextField apellidoField = new JTextField();
            String[] opciones = {"Activa", "Inactiva"};
            JComboBox<String> comboEstado = new JComboBox<>(opciones);

            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Nombre:"));
            panel.add(nombreField);
            panel.add(new JLabel("Apellido:"));
            panel.add(apellidoField);
            panel.add(new JLabel("Estado de Membresía:"));
            panel.add(comboEstado);

            int result = JOptionPane.showConfirmDialog(this, panel, "Agregar Socio", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String nombre = nombreField.getText().trim();
                String apellido = apellidoField.getText().trim();
                String estado = comboEstado.getSelectedItem().toString();

                if (!nombre.isEmpty() && !apellido.isEmpty()) {
                    modeloTabla.addRow(new Object[]{nombre, apellido, estado});
                } else {
                    JOptionPane.showMessageDialog(this, "Campos obligatorios vacios.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(e -> {
            int fila = tablaSocios.getSelectedRow();
            if (fila != -1) {
                String nombre = tablaSocios.getValueAt(fila, 0).toString();
                String apellido = tablaSocios.getValueAt(fila, 1).toString();
                int confirm = JOptionPane.showConfirmDialog(this, "Eliminar al socio " + nombre + " " + apellido + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    modeloTabla.removeRow(fila);
                }
            }
        });

        admSociosPanel.add(panelBotones, BorderLayout.WEST);
        admSociosPanel.add(new JScrollPane(tablaSocios), BorderLayout.CENTER);

        // Página Mantenimiento de Maquinas
        JPanel mantMaquinasPanel = new JPanel(new BorderLayout());

        JPanel panelBotonesMaq = new JPanel();
        panelBotonesMaq.setLayout(new BoxLayout(panelBotonesMaq, BoxLayout.Y_AXIS));

        JButton btnAgregarMaq = new JButton("Agregar Maquina");
        JButton btnProgramarMantenimiento = new JButton("Programar mantenimiento");

        panelBotonesMaq.add(btnAgregarMaq);
        panelBotonesMaq.add(Box.createVerticalStrut(10));
        panelBotonesMaq.add(btnProgramarMantenimiento);

        DefaultListModel<String> modeloMaquinas = new DefaultListModel<>();
        JList<String> listaMaquinas = new JList<>(modeloMaquinas);
        JScrollPane scrollMaquinas = new JScrollPane(listaMaquinas);

        btnAgregarMaq.addActionListener(e -> {
            String tipo = JOptionPane.showInputDialog(this, "Tipo de maquina:");
            if (tipo != null && !tipo.trim().isEmpty()) {
                String fecha = JOptionPane.showInputDialog(this, "Fecha ultimo mantenimiento (opcional):");
                String entrada = tipo + (fecha != null && !fecha.trim().isEmpty() ? " - Último mantenimiento: " + fecha : "");
                modeloMaquinas.addElement(entrada);
            }
        });

        btnProgramarMantenimiento.addActionListener(e -> {
            if (listaMaquinas.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona una maquina para programar mantenimiento.");
                return;
            }
            JOptionPane.showMessageDialog(this, "Mantenimiento programado para: " + listaMaquinas.getSelectedValue());
        });

        mantMaquinasPanel.add(panelBotonesMaq, BorderLayout.WEST);
        mantMaquinasPanel.add(scrollMaquinas, BorderLayout.CENTER);

        // Página información
        JPanel informacionPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        informacionPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JPanel infoPersonal = new JPanel();
        infoPersonal.setLayout(new BoxLayout(infoPersonal, BoxLayout.Y_AXIS));
        infoPersonal.setBorder(BorderFactory.createTitledBorder("Información Personal"));
        infoPersonal.add(new JLabel("Nombre: Ramiro"));
        infoPersonal.add(Box.createVerticalStrut(5));
        infoPersonal.add(new JLabel("Apellido: Marcos Morales"));
        infoPersonal.add(Box.createVerticalStrut(5));
        infoPersonal.add(new JLabel("Teléfono: 5491125452154"));
        infoPersonal.add(Box.createVerticalStrut(5));
        infoPersonal.add(new JLabel("Email: ramiro@mail.com"));

        JPanel infoRol = new JPanel();
        infoRol.setLayout(new BoxLayout(infoRol, BoxLayout.Y_AXIS));
        infoRol.setBorder(BorderFactory.createTitledBorder("Rol"));
        infoRol.add(Box.createVerticalStrut(20));
        infoRol.add(new JLabel("Empleado de gimnasio"));
        infoRol.add(Box.createVerticalStrut(20));
        infoRol.add(new JLabel("Acceso a gestión de socios y máquinas"));

        informacionPanel.add(infoPersonal);
        informacionPanel.add(infoRol);

        panelCentral.add(admSociosPanel, "Administrar");
        panelCentral.add(mantMaquinasPanel, "Mantenimiento");
        panelCentral.add(informacionPanel, "Informacion");

        add(header, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);

        CardLayout cl = (CardLayout) panelCentral.getLayout();
        botonAdmSocios.addActionListener(e -> cl.show(panelCentral, "Administrar"));
        botonMantMaquinas.addActionListener(e -> cl.show(panelCentral, "Mantenimiento"));
        botonInformacion.addActionListener(e -> cl.show(panelCentral, "Informacion"));
    }
}
