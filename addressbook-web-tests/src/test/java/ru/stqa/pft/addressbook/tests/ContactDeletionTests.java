package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase
{
    @Test
    public void testContactDeletion()
    {
        app.goTo().gotoHomePage();
        if (!app.getContactHelper().isThereAContact())
        {
            app.getContactHelper().createContact(new ContactData(
                    "contactName",
                    "contactLastName",
                    "+372 3423 2352",
                    "griffinheart4@gmail.com",
                    "test1"));
            app.goTo().gotoHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.goTo().acceptAlert();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size() - 1, after.size());
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
