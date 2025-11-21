package com.platinum.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.platinum.dao.Conexion;

@WebServlet("/RegistrarUsuarioServlet")
public class RegistrarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");

        try {
            // Conectar usando tu clase Conexion
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO usuario (nombreUsuario, password) VALUES (?, ?)"
            );

            ps.setString(1, nombreUsuario);
            ps.setString(2, password);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                response.sendRedirect("registroUsuario.jsp?msg=ok");
            } else {
                response.sendRedirect("registroUsuario.jsp?msg=error");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("registroUsuario.jsp?msg=errorBD");
        }
    }
}
