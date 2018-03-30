package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase
{
    public ContactHelper(WebDriver wd)
    {
        super(wd);
    }

    public void initContactCreation()
    {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData, Boolean creation)
    {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());

        if (creation)
        {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else
        {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactForm()
    {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void selectContact()
    {
        click(By.xpath("//input[@id!='MassCB' and @type='checkbox']"));
    }

    public void deleteContact()
    {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void initContactModification()
    {
        click(By.xpath("//*[@title='Edit']"));
    }

    public void submitContactModification()
    {
        click(By.xpath("//*[@value='Update']"));
    }
}
