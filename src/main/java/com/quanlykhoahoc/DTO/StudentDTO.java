package com.quanlykhoahoc.DTO;

import java.time.LocalDate;

public class StudentDTO extends PersonDTO {
    private LocalDate enrollmentDate;

    public StudentDTO() {}

    public StudentDTO(int personId, String lastName, String firstName, LocalDate enrollmentDate) {
        super(personId, lastName, firstName);
        this.enrollmentDate = enrollmentDate;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
