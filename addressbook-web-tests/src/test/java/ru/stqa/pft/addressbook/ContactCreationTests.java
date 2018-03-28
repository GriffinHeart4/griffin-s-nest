package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactForm(new ContactData("Griffin", "Heart", "+372 8767 3421", "griffinheart4@gmail.com"));
        submitContactForm();
    }
}
