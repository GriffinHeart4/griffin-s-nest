package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase
{
    @Test
    public void testContactModification()
    {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData(
                "Griffin",
                "Heart",
                "+372 8734 8342",
                "griffinhear4@gmail.com",
                null),
                false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }
}
