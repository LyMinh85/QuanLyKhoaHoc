package com.quanlykhoahoc.DTO;

import java.time.LocalTime;

public class OnsiteCourseDTO {
    private CourseDTO course;
    private String location;
    private String days;
    private LocalTime time;

    public OnsiteCourseDTO() {
    }

    public OnsiteCourseDTO(CourseDTO course, String location, String days, LocalTime time) {
        this.course = course;
        this.location = location;
        this.days = days;
        this.time = time;
    }

    public Object[] toObject() {
        return new Object[]{
                course.getCourseId(), course.getTitle(), course.getCredits(),
                course.getDepartment().getName(), this.getLocation(),
                this.getDays(), this.getTime().toString()
        };
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
