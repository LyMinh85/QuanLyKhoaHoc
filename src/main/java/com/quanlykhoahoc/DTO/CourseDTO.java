package com.quanlykhoahoc.DTO;

public class CourseDTO {
    private int courseId;
    private String title;
    private int credits;
    private DepartmentDTO department;

    public CourseDTO() {}

    public CourseDTO(int courseId, String title, int credits, DepartmentDTO department) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
        this.department = department;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                '}';
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }
}
