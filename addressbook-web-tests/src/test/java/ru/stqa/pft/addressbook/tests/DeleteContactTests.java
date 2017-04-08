package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;

import java.util.List;

/**
 * Created by Denis on 19.03.2017.
 */
public class DeleteContactTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions (){
        app.goTo().homePage();
        if (app.conact().list().size()==0) {
            app.conact().create(new CantactData().
                    withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5").withEmail("12345@mail.ru"));
        }
        app.conact().findSelects();
    }
    @Test
    public void testContactDelete() {

        List<CantactData> before = app.conact().list();
        int index=before.size() - 1;
        app.conact().delete(index);
        List<CantactData> after = app.conact().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before, after);

    }


}
