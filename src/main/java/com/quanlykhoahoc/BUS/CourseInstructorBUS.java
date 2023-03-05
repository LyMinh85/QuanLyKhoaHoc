package com.quanlykhoahoc.BUS;

import com.quanlykhoahoc.DAO.CourseInstructorDAO;
import com.quanlykhoahoc.DTO.CourseInstructorDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseInstructorBUS {
    private final CourseInstructorDAO courseInstructorDAO;
    private ArrayList<CourseInstructorDTO> courseInstructors;

    public CourseInstructorBUS() {
        courseInstructorDAO = new CourseInstructorDAO();
        courseInstructors = new ArrayList<>();
    }

    public ArrayList<CourseInstructorDTO> getCourseInstructors() {
        courseInstructors =  courseInstructorDAO.getCourseInstructors();
        return courseInstructors;
    }

    public boolean add(CourseInstructorDTO courseInstructorDTO) {
        return courseInstructorDAO.add(courseInstructorDTO);
    }

    public boolean update(int courseId, int instructorId, CourseInstructorDTO updateCourseInstructor) {
        return courseInstructorDAO.update(courseId, instructorId, updateCourseInstructor);
    }

    public boolean delete(int courseId, int instructorId) {
        return courseInstructorDAO.delete(courseId, instructorId);
    }

    public ArrayList<CourseInstructorDTO> findByCourseTitleOrInstructor(String name) {
        return courseInstructorDAO.findByCourseTitleOrInstructor(name);
    }
}
