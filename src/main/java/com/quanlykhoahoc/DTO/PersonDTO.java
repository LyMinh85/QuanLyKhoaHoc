package com.quanlykhoahoc.DTO;

public class PersonDTO {
    private int personId;
    private String lastName;
    private String firstName;

    public PersonDTO() {}

    public PersonDTO(int personId, String lastName, String firstName) {
        this.personId = personId;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "" +
                "personId=" + personId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName;
    }

    public String getFullName() {
        return lastName + " " + firstName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
