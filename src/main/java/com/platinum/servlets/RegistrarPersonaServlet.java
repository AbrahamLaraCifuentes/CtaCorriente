package com.platinum.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.platinum.dao.Conexion;

@WebServlet("/RegistrarPersonaServlet")
public class RegistrarPersonaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String nombreMascota = request.getParameter("nombreMascota");

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO persona (rut, nombre, apellido, direccion, correo, telefono, nombreMascota) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, rut);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, direccion);
            ps.setString(5, correo);
            ps.setString(6, telefono);
            ps.setString(7, nombreMascota);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                response.sendRedirect("registroPersona.jsp?msg=ok");
            } else {
                response.sendRedirect("registroPersona.jsp?msg=error");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("registroPersona.jsp?msg=errorBD");
        }
    }
}
