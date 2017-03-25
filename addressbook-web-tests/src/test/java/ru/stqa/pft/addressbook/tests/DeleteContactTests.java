package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Denis on 19.03.2017.
 */
public class DeleteContactTests extends TestBase{

    @Test
    public void testContactDelete()
    {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().selectDeleteButton();
        app.getContactHelper().closeAlert();
        app.getContactHelper().findMsg();
    }
}
