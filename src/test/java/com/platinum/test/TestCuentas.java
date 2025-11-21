package com.platinum.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import com.platinum.dao.Conexion;

public class TestCuentas {
    
    @Test
    public void testCuentasCliente() {

       
        Conexion cx = new Conexion();
        try (Connection con = cx.conectar();   
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(
                 "SELECT * FROM CtaCorriente WHERE rutCliente='15.555.555-5'"
             )) {

            assertTrue(rs.next(), "El cliente Abraham debe tener una cuenta");

        } catch (Exception e) {
            fail("Error consultando cuentas: " + e.getMessage());
        }
    }
}
