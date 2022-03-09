package testClean;

import control.AlertControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import singleton.Session;

public class TodoTest {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    CreateProject createProject = new CreateProject();
    CentralSession centralSession = new CentralSession();
    AlertControl alertControl = new AlertControl();
    MenuSection menuSection = new MenuSection();

    @Test
    public void verify_login_todoly() throws InterruptedException {

        String name = "Clean Project";
        Session.getInstance().getDriver().get("http://todo.ly/");

        //login
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText("ale@gmail.com");
        loginModal.pwdTxtBox.setText("1234567");
        loginModal.loginButton.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no se pudo hacer el login");

        //crate
        createProject.addNewProjectButton.click();
        createProject.nameProjectTextBox.set(name);
        createProject.addButton.click();
        Thread.sleep(2000);
        Assertions.assertEquals(name, centralSession.projectNameLabel.getTextControl(), "ERROR !!Projecto No Creado");

        //update
        String newName = "CleanProject Update";
        createProject.lastProject.click();
        createProject.editMenuImage.click();
        createProject.editButton.click();
        createProject.editNameProjectTextBox.clearSetText();
        createProject.editNameProjectTextBox.set(newName);
        createProject.saveButton.click();
        Thread.sleep(2000);
        Assertions.assertEquals(newName, centralSession.projectNameLabel.getTextControl(), "No se cambio el nombre");

        //delete
        createProject.lastProject.click();
        createProject.editMenuImage.click();
        createProject.deleteButton.click();
        alertControl.alertAccept();
        Thread.sleep(2000);
        Assertions.assertNotEquals(centralSession.projectNameLabel.getTextControl(), newName, "El proyecto no se pudo eliminar");
    }
}
