package com.platinum.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

import com.platinum.dao.Conexion;

@WebServlet("/RegistrarHoraVeterinariaServlet")
public class RegistrarHoraVeterinariaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rut = request.getParameter("rutCliente");
        String mascota = request.getParameter("nombreMascota");
        String fecha = request.getParameter("fecha");

        try (Connection con = new Conexion().getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO hora_veterinaria (rutCliente, nombreMascota, fecha) VALUES (?, ?, ?)"
            );

            ps.setString(1, rut);
            ps.setString(2, mascota);
            ps.setString(3, fecha);

            ps.executeUpdate();

            response.sendRedirect("registroVeterinario.jsp?ok=1");

        } catch (Exception e) {
            response.getWriter().println("Error al registrar hora veterinaria: " + e.getMessage());
        }
    }
}
