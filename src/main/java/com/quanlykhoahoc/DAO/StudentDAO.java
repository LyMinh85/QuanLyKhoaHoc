package com.quanlykhoahoc.DAO;

import com.quanlykhoahoc.DTO.CourseDTO;
import com.quanlykhoahoc.DTO.DepartmentDTO;
import com.quanlykhoahoc.DTO.StudentDTO;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    private MySQLDatabaseConnector mySQLDatabaseConnector;
    public StudentDAO() {
        mySQLDatabaseConnector = new MySQLDatabaseConnector();
    }

    public StudentDTO convertResultSetToStudentDTO(ResultSet rs) throws SQLException {
        int studentID = rs.getInt("PersonID");
        String lastName = rs.getString("lastname");
        String firstName = rs.getString("firstname");
        return new StudentDTO(studentID, lastName, firstName, null);
    }

    public ArrayList<StudentDTO> getStudents() {
        ArrayList<StudentDTO> students = new ArrayList<>();
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            String sql = "select PersonID, Lastname, Firstname from person where HireDate is null";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    students.add(convertResultSetToStudentDTO(rs));
                }
            }
            mySQLDatabaseConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
