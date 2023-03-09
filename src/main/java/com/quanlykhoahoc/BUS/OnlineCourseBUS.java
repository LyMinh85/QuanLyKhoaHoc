package com.quanlykhoahoc.BUS;

import com.quanlykhoahoc.DAO.DepartmentDAO;
import com.quanlykhoahoc.DTO.CourseDTO;
import com.quanlykhoahoc.DAO.OnlineCourseDAO;
import com.quanlykhoahoc.DTO.DepartmentDTO;
import com.quanlykhoahoc.DTO.OnlineCourseDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OnlineCourseBUS {
    private OnlineCourseDAO onlineCourseDAO;
    private ArrayList<OnlineCourseDTO> onlineCourses;
    private DepartmentDAO departmentDAO;
    private ArrayList<DepartmentDTO> departments;

    public OnlineCourseBUS() {
        onlineCourseDAO = new OnlineCourseDAO();
        onlineCourses = new ArrayList<>();
        departmentDAO = new DepartmentDAO();
        departments = new ArrayList<>();
    }

    public ArrayList<OnlineCourseDTO> getOnlineCourses() {
        onlineCourses = onlineCourseDAO.getOnlineCourses();
        return onlineCourses;
    }

    public boolean addOnlineCourse(OnlineCourseDTO onlineCourseDto) {
        int courseId = onlineCourseDAO.addCourse(onlineCourseDto.getCourse());
        System.out.println("CourseId = " + courseId);
        onlineCourseDto.getCourse().setCourseId(courseId);
        return onlineCourseDAO.addOnlineCourse(onlineCourseDto);
    }

    public boolean update(OnlineCourseDTO updateOnlineCourse) {
        return onlineCourseDAO.update(updateOnlineCourse);
    }

    public boolean delete(int OnlineCourseId) {
        return onlineCourseDAO.delete(OnlineCourseId);
    }

    public ArrayList<OnlineCourseDTO> findByCourseTitle(String courseTitle) {
        return onlineCourseDAO.findByCourseTitle(courseTitle);
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
