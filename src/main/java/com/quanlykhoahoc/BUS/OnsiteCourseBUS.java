package com.quanlykhoahoc.BUS;

import com.quanlykhoahoc.DAO.CourseDAO;
import com.quanlykhoahoc.DAO.DepartmentDAO;
import com.quanlykhoahoc.DAO.OnsiteCourseDAO;
import com.quanlykhoahoc.DTO.DepartmentDTO;
import com.quanlykhoahoc.DTO.OnsiteCourseDTO;

import java.util.ArrayList;

public class OnsiteCourseBUS {
    private final OnsiteCourseDAO onsiteCourseDAO;
    private final DepartmentDAO departmentDAO;
    private final CourseDAO courseDAO;
    private ArrayList<DepartmentDTO> departments;

    public OnsiteCourseBUS() {
        onsiteCourseDAO = new OnsiteCourseDAO();
        courseDAO = new CourseDAO();
        departmentDAO = new DepartmentDAO();
        departments = new ArrayList<>();
    }

    public ArrayList<OnsiteCourseDTO> getOnsiteCourses() {
        return onsiteCourseDAO.getOnsiteCourses();
    }

    public boolean addOnsiteCourse(OnsiteCourseDTO onsiteCourseDTO) {
        int courseId = courseDAO.addCourse(onsiteCourseDTO.getCourse());
        onsiteCourseDTO.getCourse().setCourseId(courseId);
        return onsiteCourseDAO.addOnsiteCourse(onsiteCourseDTO);
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

    public ArrayList<DepartmentDTO> getDepartments() {
        departments = departmentDAO.getDepartments();
        return departments;
    }

    public DepartmentDTO findByDepartmentName(String name) {
        for (DepartmentDTO department : departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }
}
