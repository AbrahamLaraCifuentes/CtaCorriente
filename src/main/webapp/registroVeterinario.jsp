<!DOCTYPE html>
<html>
<head>
    <title>Registro Veterinario</title>
</head>
<body>

<h2>Registrar Hora Médica Veterinaria</h2>

<% 
    if (request.getParameter("ok") != null) { 
%>
    <p style="color:green;">Hora médica registrada exitosamente</p>
<%
    }
    if (request.getParameter("error") != null) { 
%>
    <p style="color:red;"><%= request.getParameter("error") %></p>
<%
    }
%>

<form action="RegistrarHoraVeterinariaServlet" method="post">

    <label>RUT Cliente:</label><br>
    <input type="text" name="rutCliente" id="txtRutCliente" required><br><br>

    <label>Nombre de Mascota:</label><br>
    <input type="text" name="nombreMascota" id="txtNombreMascota" placeholder="Se autocompletará si existe"><br><br>

    <label>Fecha de Atención:</label><br>
    <input type="date" name="fecha" id="txtFecha" required><br><br>

    <button type="submit">Registrar Hora</button>

</form>

<br>
<a href="menu.jsp">Volver al Menú</a>

</body>
</html>

