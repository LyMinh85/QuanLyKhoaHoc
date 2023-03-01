package com.quanlykhoahoc.DTO;

import java.time.LocalDate;

public class InstructorDTO extends PersonDTO {
    private LocalDate hireDate;

    public InstructorDTO(){}

    public InstructorDTO(int personId, String lastName, String firstName, LocalDate hireDate) {
        super(personId, lastName, firstName);
        this.hireDate = hireDate;
    }

    public String getFullName() {
        return getLastName() + " " + getFirstName();
    }

    @Override
    public String toString() {
        return "InstructorDTO{" +
                super.toString() +
                ", hireDate=" + hireDate +
                '}';
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
