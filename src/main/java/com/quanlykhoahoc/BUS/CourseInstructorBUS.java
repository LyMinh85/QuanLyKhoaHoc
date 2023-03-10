package com.quanlykhoahoc.BUS;

import com.quanlykhoahoc.DAO.CourseDAO;
import com.quanlykhoahoc.DAO.CourseInstructorDAO;
import com.quanlykhoahoc.DAO.InstructorDAO;
import com.quanlykhoahoc.DTO.CourseDTO;
import com.quanlykhoahoc.DTO.CourseInstructorDTO;
import com.quanlykhoahoc.DTO.InstructorDTO;
import com.quanlykhoahoc.DTO.StudentDTO;

import java.util.ArrayList;

public class CourseInstructorBUS {
    private final CourseInstructorDAO courseInstructorDAO;
    private final InstructorDAO instructorsDAO;
    private final CourseDAO courseDAO;
    private ArrayList<CourseInstructorDTO> courseInstructors;
    private ArrayList<InstructorDTO> instructors = new ArrayList<>();
    private ArrayList<CourseDTO> courses = new ArrayList<>();
    public CourseInstructorBUS() {
        courseInstructorDAO = new CourseInstructorDAO();
        courseInstructors = new ArrayList<>();
        instructorsDAO = new InstructorDAO();
        courseDAO = new CourseDAO();
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

    public ArrayList<InstructorDTO> getInstructors() {
        instructors = instructorsDAO.getInstructors();
        return instructors;
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

    public InstructorDTO findInstructorById(int personId) {
        for (InstructorDTO instructor : instructors) {
            if (instructor.getPersonId() == personId) {
                return instructor;
            }
        }
        return null;
    }
}
