<!DOCTYPE html>
<html>
<head>
    <title>Transferencia Bancaria</title>
</head>
<body>

<h2>Realizar Transferencia</h2>

<% 
    if (request.getParameter("ok") != null) {
%>
    <p style="color:green;">Transferencia realizada exitosamente</p>
<%
    }
    if (request.getParameter("error") != null) {
%>
    <p style="color:red;"><%= request.getParameter("error") %></p>
<%
    }
%>

<form action="RegistrarTransferenciaServlet" method="post">

    <label>RUT Cliente Origen:</label><br>
    <input type="text" name="rutCliente" id="txtRutCliente" required><br><br>

    <label>RUT Dueño Destino:</label><br>
    <input type="text" name="rutDueno" id="txtRutDueno" required><br><br>

    <label>ID Cuenta Origen:</label><br>
    <input type="number" name="idCuenta" id="txtIdCuenta" required><br><br>

    <label>Monto a Transferir:</label><br>
    <input type="number" step="0.01" name="monto" id="txtMontoTransferencia" required><br><br>

    <label>Cuenta Destino:</label><br>
    <input type="text" name="cuentaTransferencia" id="txtCuentaTransferencia" required><br><br>

    <label>Tipo Cuenta Destino:</label><br>
    <select name="tipoCuenta" id="cmbTipoCuenta">
        <option value="Cuenta Corriente">Cuenta Corriente</option>
        <option value="Cuenta Vista">Cuenta Vista</option>
        <option value="Ahorro">Cuenta de Ahorro</option>
    </select>

    <br><br>
    <button type="submit">Realizar Transferencia</button>

</form>

<br>
<a href="menu.jsp">Volver al Menú</a>

</body>
</html>
