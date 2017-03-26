package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;

public class CntactCreationTests extends TestBase {



    @Test
    public void testCntactCreation() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initAddNew();
        app.getContactHelper().fillContactForm(new CantactData("First name", "Last name", "Moscow, Arbat 5", null, "12345@mail.ru"));
        app.getContactHelper().submitNewConract();
        app.getContactHelper().returnToHomePage();

    }


}
