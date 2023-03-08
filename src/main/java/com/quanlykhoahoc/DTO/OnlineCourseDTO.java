package com.quanlykhoahoc.DTO;

public class OnlineCourseDTO {
    private CourseDTO course;
    private String url;

    public OnlineCourseDTO() {}

    public OnlineCourseDTO(CourseDTO course, String url) {
        this.course = course;
        this.url = url;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Object[] toObject() {
        return new Object[]{
                course.getCourseId(), course.getTitle(), course.getCredits(), course.getDepartment().getName(), url
                
        };
    }
}
