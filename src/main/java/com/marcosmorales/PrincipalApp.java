package com.marcosmorales;

import com.marcosmorales.modelo.Socio;
import com.marcosmorales.vista.VentanaEmpleado;
import com.marcosmorales.vista.VentanaSocio;
import javax.swing.*;

public class PrincipalApp extends Socio {
    public static void main(String[] args) {
        JFrame ventanaInicial = new JFrame("Fitness Pro");
        ventanaInicial.setSize(300, 150);
        ventanaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaInicial.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Ingresar como:");
        String[] tipo = {"Empleado", "Socio"};
        JComboBox<String> opciones = new JComboBox<>(tipo);
        JButton ingresar = new JButton("Ingresar");
        
        panel.add(label);
        panel.add(opciones);
        panel.add(ingresar);
    
        ventanaInicial.add(panel);
        ventanaInicial.setVisible(true);
        
        ingresar.addActionListener(e -> {
            String seleccion = (String) opciones.getSelectedItem();
            
            if  (seleccion.equals("Empleado")) {
                ventanaInicial.dispose();
                new VentanaEmpleado().setVisible(true);
            } else if (seleccion.equals("Socio")) {
                ventanaInicial.dispose();
                new VentanaSocio().setVisible(true);
            }
        });
    }
}
