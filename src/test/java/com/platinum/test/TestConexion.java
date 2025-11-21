package com.platinum.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.platinum.dao.Conexion;

public class TestConexion {

    @Test
    public void testConexion() {
        Conexion cx = new Conexion();
        Connection con = cx.conectar();  
        assertNotNull(con, "La conexión debe ser exitosa");
    }
}
