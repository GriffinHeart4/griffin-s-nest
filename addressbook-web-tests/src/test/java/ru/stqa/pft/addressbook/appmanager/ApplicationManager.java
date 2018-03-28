package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager extends GroupHelper
{
    FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd)
    {
        try
        {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e)
        {
            return false;
        }
    }

    public void submitContactForm()
    {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactData contactData)
    {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(contactData.getPhone());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public void initContactCreation()
    {
        wd.findElement(By.linkText("add new")).click();
    }

    public void login(String username, String password)
    {
        wd.get("http://localhost/addressbook/index.php");
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void returnToGroupPage()
    {
        wd.findElement(By.linkText("groups")).click();
    }

    public void submitGroupCreation()
    {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData)
    {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation()
    {
        wd.findElement(By.name("new")).click();
    }

    public void gotoGroupPage()
    {
        wd.findElement(By.linkText("groups")).click();
    }

    public void deleteSelectedGroups()
    {
        wd.findElement(By.name("delete")).click();
    }

    public void selectGroup()
    {
        if (!wd.findElement(By.name("selected[]")).isSelected())
        {
            wd.findElement(By.name("selected[]")).click();
        }
    }

    public void init()
    {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("/opt/firefox_ESR/firefox/firefox"));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        login("admin", "secret");
    }

    public void stop()
    {
        wd.quit();
    }
}
