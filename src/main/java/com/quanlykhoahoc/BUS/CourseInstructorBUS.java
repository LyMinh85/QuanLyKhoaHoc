package com.quanlykhoahoc.BUS;

import com.quanlykhoahoc.DAO.CourseInstructorDAO;
import com.quanlykhoahoc.DTO.CourseInstructorDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseInstructorBUS {
    private final CourseInstructorDAO courseInstructorDAO;

    public CourseInstructorBUS() {
        courseInstructorDAO = new CourseInstructorDAO();
    }

    public ArrayList<CourseInstructorDTO> getCourseInstructors() {
        return courseInstructorDAO.getCourseInstructors();
    }

    public boolean add(CourseInstructorDTO courseInstructorDTO) {
        return courseInstructorDAO.add(courseInstructorDTO);
    }
}
