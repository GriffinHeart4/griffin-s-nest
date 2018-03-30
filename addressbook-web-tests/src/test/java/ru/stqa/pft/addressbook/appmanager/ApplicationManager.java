package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager
{
    private String browser;
    WebDriver wd;

    public ApplicationManager(String browser)
    {
        this.browser = browser;
    }

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;

    public void init()
    {
        if (browser.equals(BrowserType.FIREFOX))
        {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("/opt/firefox_ESR/firefox/firefox"));
        } else if (browser.equals(BrowserType.CHROME))
        {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE))
        {
            wd = new InternetExplorerDriver();
        }

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

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
}
