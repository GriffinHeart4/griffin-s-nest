package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase
{

    @Test
    public void testContactCreation()
    {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData(
                "Griffin",
                "Heart",
                "+372 8767 3421",
                "griffinheart4@gmail.com",
                "test1"),
                true);
        app.getContactHelper().submitContactForm();
    }
}
