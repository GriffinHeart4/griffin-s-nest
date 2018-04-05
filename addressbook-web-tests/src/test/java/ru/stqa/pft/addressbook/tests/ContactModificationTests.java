package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase
{
    @Test
    public void testContactModification()
    {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact())
        {
            app.getContactHelper().createContact(new ContactData(
                    "contactFirstName",
                    "contactLastName",
                    "+372 3234 2352",
                    "griffinheart4@gmail.com",
                    "test1"));
        }
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(
                "Griffin",
                "Heart",
                "+372 8734 8342",
                "griffinhear4@gmail.com",
                null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size(), after.size());
        before.remove(before.size() - 1);
        before.add(contact);
    }
}
