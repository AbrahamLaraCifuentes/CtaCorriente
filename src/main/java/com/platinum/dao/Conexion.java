package com.platinum.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/cuentas_clientes";
    private static final String USER = "root";
    private static final String PASS = "amir";

    // Nuevo método para compatibilidad con tus TEST
    public Connection conectar() {
        return getConnection();
    }

    // Método estándar usado por los Servlets
    public Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa!");
        } catch (Exception e) {
            System.out.println("Error conexión BD: " + e.getMessage());
        }

        return con;
    }
}
