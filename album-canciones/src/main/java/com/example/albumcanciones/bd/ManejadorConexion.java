package com.example.albumcanciones.bd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManejadorConexion {
    private static Logger log = LogManager.getLogger(ManejadorConexion.class.getName());

    private final String BASEDATOS = "prueba";
    private final String USUARIO = "prueba";
    private final String CLAVE = "12345";

    private final String URL = "./bd/misvehiculos.db";

    public Connection conectarseSQL (){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prueba", BASEDATOS, CLAVE);
            log.info("Se conecto a postgres");
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            log.error("Informa error",e);
        }
        return null;
    }

    public void desconexion(Connection conexion){
        if (conexion!= null){
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
