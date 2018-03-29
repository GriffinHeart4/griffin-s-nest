package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager
{
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;

    FirefoxDriver wd;

    public void init()
    {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("/opt/firefox_ESR/firefox/firefox"));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Helper classes initialization with Browser Driver.
        contactHelper = new ContactHelper(wd);
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop()
    {
        wd.quit();
    }

    public GroupHelper getGroupHelper()
    {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper()
    {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper()
    {
        return sessionHelper;
    }

    public ContactHelper getContactHelper()
    {
        return contactHelper;
    }

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
}
