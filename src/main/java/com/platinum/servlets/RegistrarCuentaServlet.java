package com.platinum.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

import com.platinum.dao.Conexion;

@WebServlet("/RegistrarCuentaServlet")
public class RegistrarCuentaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rutCliente = request.getParameter("rutCliente");
        String montoStr = request.getParameter("monto");
        String ejecutivo = request.getParameter("ejecutivo");

        try {
            double monto = Double.parseDouble(montoStr);

            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO CtaCorriente (rutCliente, monto, ejecutivo) VALUES (?, ?, ?)"
            );

            ps.setString(1, rutCliente);
            ps.setDouble(2, monto);
            ps.setString(3, ejecutivo);

            int filas = ps.executeUpdate();

            con.close();

            if (filas > 0) {
                response.sendRedirect("registroCuenta.jsp?ok=1");
            } else {
                response.sendRedirect("registroCuenta.jsp?ok=0");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("registroCuenta.jsp?ok=0");
        }
    }
}

