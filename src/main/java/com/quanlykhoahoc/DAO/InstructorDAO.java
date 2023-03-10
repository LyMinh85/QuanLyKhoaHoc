package com.quanlykhoahoc.DAO;

import com.quanlykhoahoc.DTO.InstructorDTO;
import com.quanlykhoahoc.DTO.StudentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class InstructorDAO {
    private MySQLDatabaseConnector mySQLDatabaseConnector;

    public InstructorDAO() {
        mySQLDatabaseConnector = new MySQLDatabaseConnector();
    }

    public InstructorDTO convertResultSetToInstructorDTO(ResultSet rs) throws SQLException {
        int instructorID = rs.getInt("PersonID");
        String lastName = rs.getString("lastname");
        String firstName = rs.getString("firstname");
        LocalDate hireDate = rs.getDate("HireDate").toLocalDate();
        return new InstructorDTO(instructorID, lastName, firstName, hireDate);
    }

    public ArrayList<InstructorDTO> getInstructors() {
        ArrayList<InstructorDTO> instructors = new ArrayList<>();
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            String sql = """
                    select PersonID, Lastname, Firstname, HireDate
                    from person
                    where EnrollmentDate is null
                    """;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    instructors.add(convertResultSetToInstructorDTO(rs));
                }
            }
            mySQLDatabaseConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instructors;
    }
}
