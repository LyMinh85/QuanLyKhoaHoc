package com.quanlykhoahoc.DAO;

import com.quanlykhoahoc.DTO.CourseInstructorDTO;
import com.quanlykhoahoc.DTO.DepartmentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartmentDAO {
    private final MySQLDatabaseConnector mySQLDatabaseConnector;

    public DepartmentDAO() {
        mySQLDatabaseConnector = new MySQLDatabaseConnector();
    }

    private DepartmentDTO convertResultSetToDepartmentDTO(ResultSet resultSet) throws SQLException {
        int departmentId = resultSet.getInt("DepartmentID");
        String name = resultSet.getString("Name");
        DepartmentDTO department = new DepartmentDTO();
        department.setDepartmentId(departmentId);
        department.setName(name);
        return department;
    }

    private ArrayList<DepartmentDTO> getDepartments() {
        ArrayList<DepartmentDTO> departments = new ArrayList<>();
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            String sql = "select * from department";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    departments.add(convertResultSetToDepartmentDTO(rs));
                }
            }
            mySQLDatabaseConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

}
