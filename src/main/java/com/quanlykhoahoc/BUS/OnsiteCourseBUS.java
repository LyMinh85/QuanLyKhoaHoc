package com.quanlykhoahoc.BUS;

import com.quanlykhoahoc.DAO.OnsiteCourseDAO;
import com.quanlykhoahoc.DTO.OnsiteCourseDTO;

import java.util.ArrayList;

public class OnsiteCourseBUS {
    private final OnsiteCourseDAO onsiteCourseDAO;

    public OnsiteCourseBUS() {
        onsiteCourseDAO = new OnsiteCourseDAO();
    }

    public ArrayList<OnsiteCourseDTO> getOnsiteCourses() {
        return onsiteCourseDAO.getOnsiteCourses();
    }

    public boolean add(OnsiteCourseDTO onsiteCourseDTO) {
        return onsiteCourseDAO.add(onsiteCourseDTO);
    }

    public boolean update(OnsiteCourseDTO updateOnsiteCourse) {
        return onsiteCourseDAO.update(updateOnsiteCourse);
    }

    public boolean delete(int courseId) {
        return onsiteCourseDAO.delete(courseId);
    }

    public ArrayList<OnsiteCourseDTO> findById(int courseId) {
        return onsiteCourseDAO.findById(courseId);
    }

    public ArrayList<OnsiteCourseDTO> findByName(String name) {
        return onsiteCourseDAO.findByName(name);
    }
}
