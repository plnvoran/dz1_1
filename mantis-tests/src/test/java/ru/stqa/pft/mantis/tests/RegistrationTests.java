package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by Denis on 30.04.2017.
 */
public class RegistrationTests extends TestBase {

   @BeforeMethod
   public void startMailSrver()
   {
       app.mail().start();
   }


    @Test(enabled = false)
    public void testRegistration() throws IOException, MessagingException {
      long now=System.currentTimeMillis();

        String email = String.format ("user%s@localhost.localdomain", now);
        String user = String.format ("user%s", now);
        String password = "password";
        app.registration().start(user, email);
       List<MailMessage> mailMessages = app.mail().waitForMail (2, 10000);
       findConfirmationLink (mailMessages, email);
       String confirmationLink=findConfirmationLink (mailMessages, email);
        app.registration().finish( confirmationLink, password);
        assertTrue (app.newSession().login(user,password  ));

    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m)->m.to.equals(email)).findFirst().get();
        VerbalExpression regex=VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
       return regex.getText(mailMessage.text);
    }

    @AfterMethod
    public void stopMailServer()
    {
        app.mail().stop();
    }

}
