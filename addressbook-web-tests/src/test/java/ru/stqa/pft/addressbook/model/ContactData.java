package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String phone;
    private final String email;
    private String group;

    public ContactData(String firstname, String lastname, String phone, String email, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(firstname, lastname);
    }

    public String getGroup() { return group; }

    @Override
    public String toString()
    {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
