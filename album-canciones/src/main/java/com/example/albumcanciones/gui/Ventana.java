package com.example.albumcanciones.gui;

import com.example.albumcanciones.bd.ManejadorConexion;
import com.example.albumcanciones.gui.Ventana;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class Ventana extends JFrame {
    private JButton btCerrar;
    private JButton validarConexion;

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }


    private void initComponents() {

        btCerrar = new JButton();
        validarConexion = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btCerrar.setText("Salir");
        validarConexion.setText("Validar conexión");

        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });
        validarConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValidarActionPerformed(evt);
            }
        });
        getContentPane().add(btCerrar);
        getContentPane().add(validarConexion);
        btCerrar.setBounds(280, 20, 90, 23);
        validarConexion.setBounds(120, 20, 120, 23);

        setSize(new Dimension(416, 339));

        setLocationRelativeTo(null);
    }
    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    private void btValidarActionPerformed(java.awt.event.ActionEvent evt) {
        ManejadorConexion man = new ManejadorConexion();
        Connection c = man.conectarseSQL();
        if (c != null)
            JOptionPane.showMessageDialog(this, "Ejecuto la conexión SQLite");
        c = man.conectarseSQL();
        if (c != null)
            JOptionPane.showMessageDialog(this, "Ejecuto la conexión Postgresql");

    }
    public static void main(String args[]) {

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

}
