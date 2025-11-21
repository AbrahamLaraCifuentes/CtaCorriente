<!DOCTYPE html>
<html>
<head>
    <title>Registrar Usuario</title>
</head>
<body>

<h2>Registro de Usuario</h2>

<% 
    String msg = request.getParameter("msg");
    if ("ok".equals(msg)) { 
%>
    <p style="color:green;">Usuario registrado correctamente</p>
<% 
    } else if ("error".equals(msg)) { 
%>
    <p style="color:red;">No se pudo registrar el usuario</p>
<% 
    } else if ("errorBD".equals(msg)) { 
%>
    <p style="color:red;">Error al conectar con la base de datos</p>
<% } %>

<form action="RegistrarUsuarioServlet" method="post">
    <label>Nombre de Usuario:</label><br>
    <input type="text" name="nombreUsuario" id="txtNombreUsuario" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" id="txtPassword" required><br><br>

    <button type="submit">Registrar</button>
</form>

<br>
<a href="menu.jsp">Volver al Menú</a>

</body>
</html>
