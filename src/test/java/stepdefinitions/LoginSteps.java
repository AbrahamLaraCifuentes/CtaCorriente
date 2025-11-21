package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

    WebDriver driver;

    @Given("que abro el navegador en la página de login")
    public void abrirNavegador() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8081/CtaCorriente-0.0.1-SNAPSHOT/login.jsp");
    }

    @When("ingreso usuario {string} y contraseña {string}")
    public void ingresoCredenciales(String usuario, String password) {
        driver.findElement(By.id("txtUsuario")).sendKeys(usuario);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnIngresar")).click();
    }

    @Then("el sistema permite el acceso y muestra la pantalla principal")
    public void ingresoExitoso() {
        try {
            // Buscar el elemento del menú
            WebElement titulo = driver.findElement(By.id("tituloMenu"));
            Assert.assertTrue(titulo.isDisplayed());
        } catch (Exception e) {
            Assert.fail("No se encontró el menú principal después del login: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    @Then("el sistema muestra el mensaje {string}")
    public void mensajeError(String mensaje) {
        Assert.assertTrue(driver.getPageSource().contains(mensaje));
        driver.quit();
    }
}
