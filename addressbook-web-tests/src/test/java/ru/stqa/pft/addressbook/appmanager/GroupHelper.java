package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.Set;

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

    public void selectGroupById(int id)
    {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initGroupModification()
    {
        click(By.name("edit"));
    }

    public void submitGroupModification()
    {
        click(By.name("update"));
    }

    public void create(GroupData group)
    {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
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

    private Groups groupCache = null;

    public Groups all()
    {
        if (groupCache != null)
        {
            return new Groups(groupCache);
        }

        groupCache = new Groups();
        for (int i = 0; i < wd.findElements(By.cssSelector("span.group")).size(); i++)
        {
            String groupName = wd.findElements(By.cssSelector("span.group")).get(i).getText();
            int groupId = Integer.parseInt(wd.findElements(By.xpath("//*[@name='selected[]']")).get(i).getAttribute("value"));
            groupCache.add(new GroupData().withName(groupName).withId(groupId));
        }
        return groupCache;
    }

    public void modify(GroupData group)
    {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }

    public void delete(GroupData group)
    {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        groupCache = null;
        returnToGroupPage();
    }
}
