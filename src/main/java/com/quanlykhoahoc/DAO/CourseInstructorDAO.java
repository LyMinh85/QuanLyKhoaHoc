package com.quanlykhoahoc.DAO;

import com.quanlykhoahoc.DTO.CourseInstructorDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseInstructorDAO {
    MySQLDatabaseConnector mySQLDatabaseConnector;

    public ArrayList<CourseInstructorDTO> getCourseInstructors() {
        ArrayList<CourseInstructorDTO> listCourseInstructorDTO = null;
        try {
            mySQLDatabaseConnector = new MySQLDatabaseConnector();
            Connection conn = mySQLDatabaseConnector.getConnection();

            listCourseInstructorDTO = new ArrayList<>();

            // Create a prepared statement to query all records from CourseInstructor
            String sql = "SELECT * FROM CourseInstructor";
            // Execute the query and get the result set
            try (PreparedStatement stmt = conn.prepareStatement(sql); 
                // execute the query and get the result set
                ResultSet rs = stmt.executeQuery()) {
                
                // iterate over the result set and print the records
                while (rs.next()) {
                    int courseId = rs.getInt("CourseID");
                    int instructorId = rs.getInt("PersonID");
                    System.out.println("Course ID: " + courseId + ", Instructor ID: " + instructorId);
                }
                
            }
            // Close connection after done query
            mySQLDatabaseConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listCourseInstructorDTO;
    }
    
    public static void main(String[] args) {
        CourseInstructorDAO courseInstructorDAO = new CourseInstructorDAO();
        courseInstructorDAO.getCourseInstructors();
    }
}
