package com.marcosmorales.vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaSocio extends JFrame {
    public VentanaSocio() {
        super("Fitness Pro");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        JPanel header = new JPanel(new FlowLayout());
        header.setBackground(Color.GRAY);
        
        JButton botonReserva = new JButton("Reservar Clase");
        header.add(botonReserva);
        
        JButton botonHistorial = new JButton("Historial de Clases");
        header.add(botonHistorial);
        
        
        JButton botonCancelar = new JButton("Cancelar Clase");
        header.add(botonCancelar);
        
        
        JButton botonInformacion = new JButton("Informacion");
        header.add(botonInformacion);
        
        JPanel panelCentral = new JPanel(new CardLayout());
        
        // Pagina de reservas
        JPanel reservaPanel = new JPanel();
        reservaPanel.setLayout(new BoxLayout(reservaPanel, BoxLayout.Y_AXIS));
        reservaPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));
        
        JPanel formularioPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formularioPanel.add(new JLabel("Fecha: "));
        JTextField fechaField = new JTextField();
        formularioPanel.add(fechaField);
        formularioPanel.add(new JLabel("Horario:"));
        JTextField horarioField = new JTextField();
        formularioPanel.add(horarioField);
        
        reservaPanel.add(formularioPanel);
        reservaPanel.add(Box.createVerticalStrut(20));
        
        JButton enviarBtn = new JButton("Reservar");

        enviarBtn.addActionListener(e -> {
            if (fechaField.getText().isEmpty() || horarioField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(reservaPanel, "Ambos campos deben ser completados!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            JOptionPane.showMessageDialog(reservaPanel, "Reserva Confirmada para el " + fechaField.getText() + " a las " + horarioField.getText(), "Reserva exitosa", JOptionPane.INFORMATION_MESSAGE);
        
            fechaField.setText("");
            horarioField.setText("");
        });
        

        JPanel botonPanel = new JPanel();
        
        
        botonPanel.add(enviarBtn);
        reservaPanel.add(botonPanel);
        
        // Pagina de historial de clases
        JPanel historialPanel = new JPanel();
        historialPanel.setLayout(new BorderLayout());
        historialPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));

        String[] columnas = {"ID", "Fecha", "Horario"};
        Object[][] datos = {
            {"1", "10-07-2025", "10:30"},
            {"2", "08-08-2025", "20:00"},
            {"3", "30-09-2025", "17:00"}
        };
        DefaultTableModel modeloHistorial = new DefaultTableModel(datos, columnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable historialTabla = new JTable(modeloHistorial);
        JScrollPane scrollHistorial = new JScrollPane(historialTabla);
        historialPanel.add(scrollHistorial, BorderLayout.CENTER);

        // Pagina de Cancelamiento de Clases
        JPanel cancelarPanel = new JPanel();
        cancelarPanel.setLayout(new BorderLayout());
        cancelarPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));

        Object[][] clasesCancelar = {
            {"4", "12-06-2025", "08:00"},
            {"5", "14-06-2025", "12:30"}
        };
        DefaultTableModel modeloCancelar = new DefaultTableModel(clasesCancelar, columnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable cancelarTabla = new JTable(modeloCancelar);
        JScrollPane scrollCancelar = new JScrollPane(cancelarTabla);

        JButton eliminarBtn = new JButton("Cancelar Clase");
        eliminarBtn.setEnabled(false);

        cancelarTabla.getSelectionModel().addListSelectionListener(e -> {
            eliminarBtn.setEnabled(cancelarTabla.getSelectedRow() != -1);
        });

        eliminarBtn.addActionListener(e -> {
            int fila = cancelarTabla.getSelectedRow();
            if (fila != -1) {
                int confirmacion = JOptionPane.showConfirmDialog(cancelarPanel, "¿Deseas cancelar la clase seleccionada?", "Confirmar Cancelacion", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    ((DefaultTableModel) cancelarTabla.getModel()).removeRow(fila);
                    JOptionPane.showMessageDialog(cancelarPanel, "Clase cancelada con éxito.");
                }
            }
        });

        JPanel panelBotonEliminar = new JPanel();
        panelBotonEliminar.add(eliminarBtn);

        cancelarPanel.add(scrollCancelar, BorderLayout.CENTER);
        cancelarPanel.add(panelBotonEliminar, BorderLayout.SOUTH);

        // Pagina de Informacion
        JPanel informacionPanel = new JPanel();
        informacionPanel.setLayout(new GridLayout(1, 2, 20, 0));
        informacionPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        JPanel infoPersonal = new JPanel();
        infoPersonal.setLayout(new BoxLayout(infoPersonal, BoxLayout.Y_AXIS));
        infoPersonal.setBorder(BorderFactory.createTitledBorder("Informacion Personal"));
        infoPersonal.add(new JLabel("Nombre: Ramiro"));
        infoPersonal.add(new JLabel("Apellido: Marcos Morales"));
        infoPersonal.add(new JLabel("Telefono: 5491125452154"));
        infoPersonal.add(new JLabel("Email: ramiro@mail.com"));
        
        JPanel infoMembresia = new JPanel();
        infoMembresia.setLayout(new BoxLayout(infoMembresia, BoxLayout.Y_AXIS));
        infoMembresia.setBorder(BorderFactory.createTitledBorder("Membresia"));
        infoMembresia.add(new JLabel("ID:  axcf3d-v5rf4g-fd4ds"));
        infoMembresia.add(new JLabel("Expiracion: 2025-07-11"));
        
        informacionPanel.add(infoPersonal);
        informacionPanel.add(infoMembresia);
    
        panelCentral.add(reservaPanel, "Reserva");
        panelCentral.add(historialPanel, "Historial");
        panelCentral.add(cancelarPanel, "Cancelar");
        panelCentral.add(informacionPanel, "Informacion");
        
        add(header, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        
        CardLayout cl = (CardLayout)(panelCentral.getLayout());
        
        botonReserva.addActionListener(e -> cl.show(panelCentral, "Reserva"));
        botonHistorial.addActionListener(e -> cl.show(panelCentral, "Historial"));
        botonCancelar.addActionListener(e -> cl.show(panelCentral, "Cancelar"));
        botonInformacion.addActionListener(e -> cl.show(panelCentral, "Informacion"));

    }
}
