package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData
{
    private int id;
    private final String name;
    private final String header;
    private final String footer;

    public GroupData(String name, String header, String footer, int id)
    {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.id = id;
    }

    public GroupData(String name, String header, String footer)
    {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.id = 0;
    }

    public String getName()
    {
        return name;
    }

    public String getHeader()
    {
        return header;
    }

    public String getFooter()
    {
        return footer;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(name, groupData.name);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(id, name);
    }

    @Override
    public String toString()
    {
        return "GroupData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
