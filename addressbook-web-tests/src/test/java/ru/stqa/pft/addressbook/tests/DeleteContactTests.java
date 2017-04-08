package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Denis on 19.03.2017.
 */
public class DeleteContactTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions (){
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new CantactData("First name", "Last name", "Moscow, Arbat 5", null, "12345@mail.ru"));
        }
        app.getContactHelper().findSelect();
    }
    @Test
    public void testContactDelete() {

        List<CantactData> before = app.getContactHelper().getContactList();
        int index=before.size() - 1;
        app.getContactHelper().deleteContact(index);
        List<CantactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before, after);

    }


}
