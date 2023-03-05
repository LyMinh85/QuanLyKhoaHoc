package com.quanlykhoahoc.DTO;

public class CourseInstructorDTO {
    private CourseDTO course;
    private InstructorDTO instructor;

    public CourseInstructorDTO(int courseId, int instructorId) {
        course = new CourseDTO();
        course.setCourseId(courseId);

        instructor = new InstructorDTO();
        instructor.setPersonId(instructorId);
    }

    public CourseInstructorDTO(CourseDTO course, InstructorDTO instructor) {
        this.course = course;
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "CourseInstructorDTO{" +
                "course=" + course +
                ", instructor=" + instructor +
                '}';
    }

    public Object[] toObject() {
        return new Object[]{
                course.getCourseId(), instructor.getPersonId(), course.getTitle(),
                course.getCredits(), instructor.getFullName(), instructor.getHireDate()
        };
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
