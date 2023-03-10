package com.quanlykhoahoc.BUS;

import com.quanlykhoahoc.DAO.CourseDAO;
import com.quanlykhoahoc.DAO.StudentDAO;
import com.quanlykhoahoc.DAO.StudentGradeDAO;
import com.quanlykhoahoc.DTO.CourseDTO;
import com.quanlykhoahoc.DTO.DepartmentDTO;
import com.quanlykhoahoc.DTO.StudentDTO;
import com.quanlykhoahoc.DTO.StudentGradeDTO;

import java.util.ArrayList;

public class StudentGradeBUS {
    private final StudentGradeDAO studentGradeDAO;
    private final StudentDAO studentDAO;
    private final CourseDAO courseDAO;
    private ArrayList<StudentGradeDTO> studentGrades = new ArrayList<>();
    private ArrayList<StudentDTO> students = new ArrayList<>();
    private ArrayList<CourseDTO> courses = new ArrayList<>();
    public StudentGradeBUS() {
        studentGradeDAO = new StudentGradeDAO();
        studentDAO = new StudentDAO();
        courseDAO = new CourseDAO();
    }

    public ArrayList<StudentGradeDTO> getStudentGrades() {
        studentGrades = studentGradeDAO.getStudentGrades();
        return studentGrades;
    }

    public boolean add(StudentGradeDTO studentGradeDTO) {
        return studentGradeDAO.add(studentGradeDTO);
    }

    public boolean update(StudentGradeDTO updateStudentDTO) {
        return studentGradeDAO.update(updateStudentDTO);
    }

    public boolean delete(int enrollmentId) {
        return studentGradeDAO.delete(enrollmentId);
    }

    public ArrayList<StudentGradeDTO> findByCourseTitleOrStudentName(String text) {
        return studentGradeDAO.findByCourseTitleOrStudentName(text);
    }

    public ArrayList<StudentDTO> getStudents() {
        students = studentDAO.getStudents();
        return students;
    }

    public ArrayList<CourseDTO> getCourse() {
        courses = courseDAO.getCourses();
        return courses;
    }

    public CourseDTO findCourseById(int courseId) {
        for (CourseDTO course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    public StudentDTO findStudentById(int personId) {
        for (StudentDTO student : students) {
            if (student.getPersonId() == personId) {
                return student;
            }
        }
        return null;
    }
}
