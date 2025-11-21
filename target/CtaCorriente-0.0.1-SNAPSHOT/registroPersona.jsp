<!DOCTYPE html>
<html>
<head>
    <title>Registrar Persona</title>
</head>
<body>

<h2>Registro de Persona</h2>

<%
    String msg = request.getParameter("msg");

    if ("ok".equals(msg)) {
%>
    <p style="color:green;">Persona registrada correctamente</p>
<%
    } else if ("error".equals(msg)) {
%>
    <p style="color:red;">No se pudo registrar la persona</p>
<%
    } else if ("errorBD".equals(msg)) {
%>
    <p style="color:red;">Error al conectar con la base de datos</p>
<%
    }
%>

<form action="RegistrarPersonaServlet" method="post">

    <label>Rut:</label><br>
    <input type="text" name="rut" id="txtRut" required><br><br>

    <label>Nombre:</label><br>
    <input type="text" name="nombre" id="txtNombre" required><br><br>

    <label>Apellido:</label><br>
    <input type="text" name="apellido" id="txtApellido" required><br><br>

    <label>Dirección:</label><br>
    <input type="text" name="direccion" id="txtDireccion"><br><br>

    <label>Correo:</label><br>
    <input type="email" name="correo" id="txtCorreo"><br><br>

    <label>Teléfono:</label><br>
    <input type="text" name="telefono" id="txtTelefono"><br><br>

    <label>Nombre de Mascota:</label><br>
    <input type="text" name="nombreMascota" id="txtMascota"><br><br>

    <button type="submit">Registrar Persona</button>
</form>

<br>
<a href="menu.jsp">Volver al Menú</a>

</body>
</html>
