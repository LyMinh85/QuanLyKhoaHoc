package com.quanlykhoahoc.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class DepartmentDTO {
    private int departmentId;
    private String name;
    private double budget;
    private LocalDate startDate;
    private InstructorDTO administrator;

    public DepartmentDTO() {}

    public DepartmentDTO(int departmentId, String name, double budget, LocalDate startDate, InstructorDTO administrator) {
        this.departmentId = departmentId;
        this.name = name;
        this.budget = budget;
        this.startDate = startDate;
        this.administrator = administrator;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public InstructorDTO getAdministrator() {
        return administrator;
    }

    public void setAdministrator(InstructorDTO administrator) {
        this.administrator = administrator;
    }

    public static void main(String[] args) {
        LocalTime localTime = LocalTime.of(15, 20);
        System.out.println(localTime.toString());
    }
}
