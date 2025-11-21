<!DOCTYPE html>
<html>
<head>
    <title>Registrar Cuenta Corriente</title>
</head>
<body>

<h2>Registro de Cuenta Corriente</h2>

<%
    if ("1".equals(request.getParameter("ok"))) {
%>
    <p style="color:green;">Cuenta registrada correctamente</p>
<%
    } else if ("0".equals(request.getParameter("ok"))) {
%>
    <p style="color:red;">Error al registrar la cuenta</p>
<%
    }
%>

<form action="RegistrarCuentaServlet" method="post">

    <label>RUT del Cliente:</label><br>
    <input type="text" name="rutCliente" id="txtRutCliente" required><br><br>

    <label>Monto Inicial:</label><br>
    <input type="number" step="0.01" name="monto" id="txtMonto" required><br><br>

    <label>Ejecutivo Responsable (rutEjecutivo):</label><br>
    <input type="text" name="ejecutivo" id="txtEjecutivo" required><br><br>

    <button type="submit">Registrar Cuenta</button>
</form>

<br>
<a href="menu.jsp">Volver al Menú</a>

</body>
</html>
