package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase
{
    @Test
    public void testContactDeletion()
    {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact())
        {
            app.getContactHelper().createContact(new ContactData(
                    "contactName",
                    "contactLastName",
                    "+372 3423 2352",
                    "griffinheart4@gmail.com",
                    "test1"));
        }
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().acceptAlert();
        app.getNavigationHelper().gotoHomePage();
    }
}
