package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase
{

    public GroupHelper(WebDriver wd)
    {
        super(wd);
    }
    public void returnToGroupPage()
    {
        click(By.linkText("groups"));
    }

    public void submitGroupCreation()
    {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData)
    {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation()
    {
        click(By.name("new"));
    }

    public void deleteSelectedGroups()
    {
        click(By.name("delete"));
    }

    public void selectGroup(int index)
    {
        if (!wd.findElements(By.name("selected[]")).get(index).isSelected())
        {
            wd.findElements(By.name("selected[]")).get(index).click();
        }
    }

    public void initGroupModification()
    {
        click(By.name("edit"));
    }

    public void submitGroupModification()
    {
        click(By.name("update"));
    }

    public void createGroup(GroupData group)
    {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup()
    {
        return isElementPresent(By.name("selected[]"));
    }

    public boolean isThereAGroupWithName(String groupName)
    {
        return wd.findElement(By.name("selected[]")).getText().equals(groupName);
    }

    public int getGroupCount()
    {
        return wd.findElements(By.name("selected[]")).size();
    }
}
