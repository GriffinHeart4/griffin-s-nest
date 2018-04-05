package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase
{

    @Test
    public void testContactCreation()
    {
        app.goTo().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData(
                "Griffin",
                "Heart",
                "+372 8767 3421",
                "griffinheart4@gmail.com",
                "test1"),
                true);
        app.getContactHelper().submitContactForm();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size() + 1, after.size());
    }
}
