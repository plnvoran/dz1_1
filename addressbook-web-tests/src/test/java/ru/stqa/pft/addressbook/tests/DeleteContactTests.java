package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;


import java.util.Set;

/**
 * Created by Denis on 19.03.2017.
 */
public class DeleteContactTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions (){
        app.goTo().homePage();
        if (app.conact().all().size()==0) {
            app.conact().create(new CantactData().
                    withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5").withEmail("12345@mail.ru"));
        }
        app.conact().findSelects();
    }
    @Test
    public void testContactDelete() {

        Set<CantactData> before = app.conact().all();
        CantactData deletedContact=before.iterator().next();

        app.conact().delete(deletedContact);
        Set<CantactData> after = app.conact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);

    }


}
