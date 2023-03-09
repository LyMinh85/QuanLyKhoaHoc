package com.quanlykhoahoc.DAO;

import com.quanlykhoahoc.DTO.CourseDTO;

import java.sql.*;

public class CourseDAO {
    private MySQLDatabaseConnector mySQLDatabaseConnector;
    public CourseDAO() {
        mySQLDatabaseConnector = new MySQLDatabaseConnector();
    }

    // Thêm 1 khóa học tra ve id vua duoc tao
    public int addCourse(CourseDTO courseDto) {
        if (courseDto != null) {
            String sql = "INSERT INTO course (Title, Credits, DepartmentID) VALUES (?, ?, ?)";
            try (Connection conn = mySQLDatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
                stmt.setString(1, courseDto.getTitle());
                stmt.setInt(2, courseDto.getCredits());
                stmt.setInt(3, courseDto.getDepartment().getDepartmentId());
                int rows = stmt.executeUpdate();

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}