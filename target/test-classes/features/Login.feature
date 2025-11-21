Feature: Login del sistema de Cuentas Corrientes

  Scenario: Ingreso exitoso con usuario válido
    Given que abro el navegador en la página de login
    When ingreso usuario "jperez" y contraseña "1234"
    Then el sistema permite el acceso y muestra la pantalla principal

  Scenario: Ingreso fallido con datos incorrectos
    Given que abro el navegador en la página de login
    When ingreso usuario "usuario_falso" y contraseña "0000"
    Then el sistema muestra el mensaje "Credenciales incorrectas"
