package com.platinum.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import com.platinum.dao.Conexion;

public class TestEjecutivo {

    @Test
    public void testListarEjecutivos() {
    	Conexion cx = new Conexion();
        try (Connection con = cx.conectar(); 
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM ejecutivo")) {

            assertTrue(rs.next(), "Debe existir al menos un ejecutivo cargado");

        } catch (Exception e) {
            fail("Error consultando ejecutivos: " + e.getMessage());
        }
    }
}
