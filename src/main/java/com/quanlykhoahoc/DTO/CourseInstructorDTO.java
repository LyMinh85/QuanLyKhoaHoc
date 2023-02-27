package com.quanlykhoahoc.DTO;

public class CourseInstructorDTO {
    private CourseDTO course;
    private InstructorDTO instructor;

    public CourseInstructorDTO(CourseDTO course, InstructorDTO instructor) {
        this.course = course;
        this.instructor = instructor;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public InstructorDTO getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorDTO instructor) {
        this.instructor = instructor;
    }
}
