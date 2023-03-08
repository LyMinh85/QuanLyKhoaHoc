package com.quanlykhoahoc.BUS;

import com.quanlykhoahoc.DAO.StudentGradeDAO;
import com.quanlykhoahoc.DTO.StudentGradeDTO;

import java.util.ArrayList;

public class StudentGradeBUS {
    private StudentGradeDAO studentGradeDAO;
    public StudentGradeBUS() {
        studentGradeDAO = new StudentGradeDAO();
    }

    public ArrayList<StudentGradeDTO> getStudentGrades() {
        return studentGradeDAO.getStudentGrades();
    }

    public boolean delete(int enrollmentId) {
        return studentGradeDAO.delete(enrollmentId);
    }

    public ArrayList<StudentGradeDTO> findByCourseTitleOrStudentName(String text) {
        return studentGradeDAO.findByCourseTitleOrStudentName(text);
    }
}
