package com.platinum.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import com.platinum.dao.Conexion;

public class TestLogin {

    @Test
    public void testLoginValido() {
        try {
            Conexion cx = new Conexion();
            Connection con = cx.conectar();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM usuario WHERE nombreUsuario=? AND password=?"
            );

            ps.setString(1, "jperez");
            ps.setString(2, "1234");

            ResultSet rs = ps.executeQuery();

            assertTrue(rs.next(), "El usuario jperez debería existir con password 1234");

        } catch (Exception e) {
            fail("Error en login válido: " + e.getMessage());
        }
    }

    @Test
    public void testLoginInvalido() {
        try {
            Conexion cx = new Conexion();
            Connection con = cx.conectar();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM usuario WHERE nombreUsuario=? AND password=?"
            );

            ps.setString(1, "usuario_fake");
            ps.setString(2, "abc123");

            ResultSet rs = ps.executeQuery();

            assertFalse(rs.next(), "Un usuario falso NO debe iniciar sesión");

        } catch (Exception e) {
            fail("Error en login inválido: " + e.getMessage());
        }
    }
}

