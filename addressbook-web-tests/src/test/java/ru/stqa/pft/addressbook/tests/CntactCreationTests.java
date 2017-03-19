package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;

public class CntactCreationTests extends TestBase {



    @Test
    public void testCntactCreation() {

        app.initAddNew();
        app.fillContactForm(new CantactData("First name", "Last name", "Moscow, Arbat 5", "+ 74991234567", "12345@mail.ru"));
        app.submitNewConract();
        app.returnToHomePage();
    }


}
