Feature: Registro de hora médica veterinaria

  Scenario: Registrar una hora veterinaria para la mascota del cliente
    Given que ingreso al módulo veterinario
    When selecciono el cliente con rut "15.555.555-5"
    And el sistema muestra su mascota "Firulais"
    And registro una hora médica para el día "2025-12-10"
    Then el sistema confirma "Hora médica registrada exitosamente"
