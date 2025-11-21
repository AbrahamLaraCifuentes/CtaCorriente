package com.platinum.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

import com.platinum.dao.Conexion;

@WebServlet("/RegistrarTransferenciaServlet")
public class RegistrarTransferenciaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rutCliente = request.getParameter("rutCliente");
        String rutDueno = request.getParameter("rutDueno");
        String idCuenta = request.getParameter("idCuenta");
        String monto = request.getParameter("monto");
        String cuenta = request.getParameter("cuentaTransferencia");
        String tipo = request.getParameter("tipoCuenta");

        try {
            Connection con = new Conexion().getConnection();

            
            PreparedStatement validarCuenta = con.prepareStatement(
                "SELECT monto FROM CtaCorriente WHERE idCuenta = ? AND rutCliente = ?"
            );
            validarCuenta.setInt(1, Integer.parseInt(idCuenta));
            validarCuenta.setString(2, rutCliente);

            ResultSet rs = validarCuenta.executeQuery();

            if (!rs.next()) {
                response.sendRedirect("transferencia.jsp?error=Cuenta+no+existe+o+no+pertenece+al+cliente");
                return;
            }

            double saldoActual = rs.getDouble("monto");
            double montoTrans = Double.parseDouble(monto);

            if (montoTrans > saldoActual) {
                response.sendRedirect("transferencia.jsp?error=Saldo+insuficiente");
                return;
            }

           
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Transaccion (rutCliente, rutDueño, idCuenta, montoTransferencia, cuentaTransferencia, tipoCuenta) " +
                "VALUES (?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, rutCliente);
            ps.setString(2, rutDueno);
            ps.setInt(3, Integer.parseInt(idCuenta));
            ps.setDouble(4, montoTrans);
            ps.setString(5, cuenta);
            ps.setString(6, tipo);

            ps.executeUpdate();

           
            PreparedStatement updateSaldo = con.prepareStatement(
                "UPDATE CtaCorriente SET monto = monto - ? WHERE idCuenta = ?"
            );
            updateSaldo.setDouble(1, montoTrans);
            updateSaldo.setInt(2, Integer.parseInt(idCuenta));
            updateSaldo.executeUpdate();

            response.sendRedirect("transferencia.jsp?ok=1");

        } catch (Exception e) {
            response.sendRedirect("transferencia.jsp?error=" + e.getMessage());
        }
    }
}

