package com.platinum.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import com.platinum.dao.Conexion;

public class TestTransacciones {

    @Test
    public void testTransacciones() {
    	Conexion cx = new Conexion();
        try (Connection con = cx.conectar(); 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Transaccion")) {

            assertTrue(rs.next(), "Debe existir al menos una transacción registrada");

        } catch (Exception e) {
            fail("Error consultando transacciones: " + e.getMessage());
        }
    }
}
