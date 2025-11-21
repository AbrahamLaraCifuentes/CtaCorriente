package com.platinum.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

import com.platinum.dao.Conexion;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtPassword");

        try {
            Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM usuario WHERE nombreUsuario=? AND password=?"
            );
            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // LOGIN OK
                request.setAttribute("nombreUsuario", usuario);
                RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
                rd.forward(request, response);
            } else {
                // LOGIN ERROR
                request.setAttribute("error", "Credenciales incorrectas");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error Login: " + e.getMessage());
        }
    }
}

