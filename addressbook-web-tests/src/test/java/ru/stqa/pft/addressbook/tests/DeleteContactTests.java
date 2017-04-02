package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

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
        List<CantactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().findSelect();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().selectDeleteButton();
        app.getContactHelper().closeAlert();
        app.getContactHelper().findMsg();
        app.getContactHelper().findMaintable();
        List<CantactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}
