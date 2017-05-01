package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Denis on 01.05.2017.
 */
public class ChangePassword extends TestBase{
    @BeforeMethod
    public void startMailSrver()
    {
        app.mail().start();
    }

    @Test
    public void testLogin() throws IOException, SQLException, MessagingException {
       app.change().goToManagePage();
       app.change().findUser();
        app.change().finish();
        app.change().changePass();
    }
    @AfterMethod
    public void stopMailServer()
    {
        app.mail().stop();
    }
}



