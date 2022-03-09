package testClean;

import control.AlertControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import singleton.Session;

public class TareaTest {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    Central central = new Central();
    MenuSection menuSection = new MenuSection();

    String nameToChange = "Alejandra Chirinos Updated";
    String attr =  "value";

    @Test
    public void verify_update_fullname_todoly() throws InterruptedException {
        String name = "Clean Project";
        Session.getInstance().getDriver().get("http://todo.ly/");
        //login
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText("ale@gmail.com");
        loginModal.pwdTxtBox.setText("1234567");
        loginModal.loginButton.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no se pudo hacer el login");

        central.opciones.click();
        central.fullName.clearSetText();
        Thread.sleep(2000);
        central.fullName.set(nameToChange);
        central.okButton.click();
        Thread.sleep(2000);

        Assertions.assertEquals(central.fullName.getTextAttributeControl(attr), nameToChange,"ERROR, no se modifico el nombre.");
    }
}
