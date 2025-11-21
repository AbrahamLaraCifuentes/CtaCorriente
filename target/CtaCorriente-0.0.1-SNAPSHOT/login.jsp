<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Login Sistema Bancario</title>
</head>
<body>

<h2>Ingreso al Sistema</h2>

<form method="post" action="LoginServlet">
    Usuario:<br>
    <input type="text" id="txtUsuario" name="txtUsuario"><br><br>

    Contraseña:<br>
    <input type="password" id="txtPassword" name="txtPassword"><br><br>

    <input type="submit" id="btnIngresar" name="btnIngresar" value="Ingresar">
</form>

<!-- Mensaje de error para Selenium -->
<% if (request.getAttribute("error") != null) { %>
    <p id="msgError" style="color:red;"><%= request.getAttribute("error") %></p>
<% } %>

</body>
</html>


