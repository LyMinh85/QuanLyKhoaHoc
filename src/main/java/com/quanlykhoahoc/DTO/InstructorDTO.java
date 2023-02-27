package com.quanlykhoahoc.DTO;

import java.time.LocalDate;

public class InstructorDTO extends PersonDTO {
    private LocalDate hireDate;

    public InstructorDTO(int personId, String lastName, String firstName, LocalDate hireDate) {
        super(personId, lastName, firstName);
        this.hireDate = hireDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
