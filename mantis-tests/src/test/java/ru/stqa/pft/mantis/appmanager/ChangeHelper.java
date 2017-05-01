package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.*;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by Denis on 01.05.2017.
 */
public class ChangeHelper extends HelperBase{

    public ChangeHelper (ApplicationManager app) {
        super(app);
    }

    public void goToManagePage()
    {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), app.getProperty("web.adminLogin"));
        type(By.name("password"), app.getProperty("web.adminPassword"));
        click(By.cssSelector("input[value='Login']"));
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");

    }

        public UserData findUser() throws SQLException {
            UserData u = new UserData().withId('0').withLogin("");


        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    + "&user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id, username, email from mantis_user_table where username!='administrator' LIMIT 1 ");


            while (rs.next()) {

               u = new UserData().withId(rs.getInt("id"))
                       .withLogin(rs.getString("username"))
                       .withEmail(rs.getString("email"));
            }



            rs.close();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
            return u;
    }

    public void finish() throws SQLException {
     //   wd.get(app.getProperty("web.baseUrl") + "manage_user_edit_page.php?user_id="+findUser().getId());
        wd.get(app.getProperty("web.baseUrl") + "manage_user_edit_page.php?user_id=4");
      click(By.cssSelector("input[value='Reset Password']"));

    }
    public void startMailSrver()
    {
        app.mail().start();
    }

    public void changePass() throws IOException, MessagingException, SQLException {

        long now=System.currentTimeMillis();


        List<MailMessage> mailMessages = app.mail().waitForMail (2, 10000);

        String confirmationLink=findConfirmationLink (mailMessages);

        wd.get(app.getProperty(confirmationLink));



    }

    private String findConfirmationLink(List<MailMessage> mailMessages) throws SQLException {
        String e = findUser().getEmail();
        MailMessage mailMessage= mailMessages.stream().filter((m) -> m.to.equals("tuser1@localhost.localdomain")).findFirst().get();

        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);

    }


}
