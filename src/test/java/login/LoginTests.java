package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;

//Extendemos de BaseTests para no repetir el código del setup
public class LoginTests extends BaseTests {

    @Test
    public void testSuccesfullLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.serPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        /*Agregamos la dependencia de TestNG y usamos el método assertEquals, param1 -> lo que testeamos
        * param2 -> Lo que esperamos que retorne
        * param3 -> lo que retorna si es error*/
        assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                "ErrorMessage: Incorrect loginPage Test");
    }
}
