package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;

/**
 * Created by Denis on 19.03.2017.
 */
public class DeleteContactTests extends TestBase {

    @Test
    public void testContactDelete() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new CantactData("First name", "Last name", "Moscow, Arbat 5", null, "12345@mail.ru"));
        }
        app.getContactHelper().findSelect();
        app.getContactHelper().selectContact();
        app.getContactHelper().selectDeleteButton();
        app.getContactHelper().closeAlert();
        app.getContactHelper().findMsg();
    }
}
