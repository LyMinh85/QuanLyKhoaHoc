package com.quanlykhoahoc.DAO;

import com.quanlykhoahoc.DTO.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class OnsiteCourseDAO {
    private final MySQLDatabaseConnector mySQLDatabaseConnector;

    public OnsiteCourseDAO() {
        mySQLDatabaseConnector = new MySQLDatabaseConnector();
    }

    private OnsiteCourseDTO convertResultSetToOnsiteCourseDTO(ResultSet resultSet) throws SQLException {
        // OnsiteCourse
        int courseId = resultSet.getInt("CourseID");
        String location = resultSet.getString("Location");
        String days = resultSet.getString("Days");
        LocalTime time = resultSet.getTime("Time").toLocalTime();
        // Course
        String title = resultSet.getString("Title");
        int credits = resultSet.getInt("Credits");
        int departmentId = resultSet.getInt("DepartmentID");
        // Department
        String departmentName = resultSet.getString("Name");

        DepartmentDTO department = new DepartmentDTO();
        department.setDepartmentId(departmentId);
        department.setName(departmentName);
        CourseDTO courseDTO = new CourseDTO(courseId, title, credits, department);
        return new OnsiteCourseDTO(courseDTO, location, days, time);
    }

    public ArrayList<OnsiteCourseDTO> getOnsiteCourses() {
        ArrayList<OnsiteCourseDTO> onsiteCourses = null;
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            onsiteCourses = new ArrayList<>();
            String query = """
                    select
                        course.CourseID, Title, Credits, course.DepartmentID, department.Name , Location, Days, Time
                    from Course, OnsiteCourse, Department
                    where
                        course.CourseID = onsitecourse.CourseID and
                        course.DepartmentID = department.DepartmentID
                    """;
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    onsiteCourses.add(convertResultSetToOnsiteCourseDTO(rs));
                }

            }
            mySQLDatabaseConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return onsiteCourses;
    }

    public boolean add(OnsiteCourseDTO onsiteCourseDTO) {
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            String sql = """
                    INSERT INTO Onsitecourse
                    VALUES (?, ?, ?, ?)
                    """;

            int rowsInserted = 0;

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, onsiteCourseDTO.getCourse().getCourseId());
                stmt.setString(2, onsiteCourseDTO.getLocation());
                stmt.setString(3, onsiteCourseDTO.getDays());
                stmt.setTime(4, Time.valueOf(onsiteCourseDTO.getTime()));
                rowsInserted = stmt.executeUpdate();
            }
            mySQLDatabaseConnector.closeConnection();

            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(OnsiteCourseDTO updateOnsiteCourse) {
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();

            String queryUpdateOne = """
                    UPDATE onsitecourse
                    SET onsitecourse.Location = ?, onsitecourse.Days = ?, onsitecourse.Time = ?
                    WHERE onsitecourse.CourseID = ?
                    """;
            int rowsUpdated = 0;
            try (PreparedStatement stmt = conn.prepareStatement(queryUpdateOne)) {
                stmt.setString(1, updateOnsiteCourse.getLocation());
                stmt.setString(2, updateOnsiteCourse.getDays());
                stmt.setTime(3, Time.valueOf(updateOnsiteCourse.getTime()));
                stmt.setInt(4, updateOnsiteCourse.getCourse().getCourseId());
                rowsUpdated = stmt.executeUpdate();
            }

            mySQLDatabaseConnector.closeConnection();
            if (rowsUpdated > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int courseId) {
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();

            String queryDelete = """
                    DELETE FROM onsitecourse
                    WHERE onsitecourse.CourseID = ?
                    """;

            int rowDeleted = 0;
            try (PreparedStatement stmt = conn.prepareStatement(queryDelete)) {
                stmt.setInt(1, courseId);
                rowDeleted = stmt.executeUpdate();
            }
            mySQLDatabaseConnector.closeConnection();
            if (rowDeleted > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<OnsiteCourseDTO> findById(int courseId) {
        ArrayList<OnsiteCourseDTO> onsiteCourses = null;
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            onsiteCourses = new ArrayList<>();
            String querySearch = """
                    select
                        course.CourseID, Title, Credits, course.DepartmentID,
                        department.Name , Location, Days, Time
                    from Course, OnsiteCourse, Department
                    where
                        course.CourseID = onsitecourse.CourseID and
                        course.DepartmentID = department.DepartmentID and
                        course.CourseID = ?
                    """;

            try (PreparedStatement stmt = conn.prepareStatement(querySearch)) {
                stmt.setInt(1, courseId);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    onsiteCourses.add(convertResultSetToOnsiteCourseDTO(rs));
                }
                mySQLDatabaseConnector.closeConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return onsiteCourses;
    }

    public ArrayList<OnsiteCourseDTO> findByName(String name) {
        ArrayList<OnsiteCourseDTO> onsiteCourses = null;
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            name = "%" + name + "%";
            String querySearch = """
                    select
                        course.CourseID, Title, Credits, course.DepartmentID, department.Name , Location, Days, Time
                    from Course, OnsiteCourse, Department
                    where
                        course.CourseID = onsitecourse.CourseID and
                        course.DepartmentID = department.DepartmentID and
                        course.Title like ?
                    """;

            try (PreparedStatement stmt = conn.prepareStatement(querySearch)) {
                stmt.setString(1, name);
                ResultSet rs = stmt.executeQuery();

                onsiteCourses = new ArrayList<>();
                while (rs.next()) {
                    onsiteCourses.add(convertResultSetToOnsiteCourseDTO(rs));
                }
                mySQLDatabaseConnector.closeConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return onsiteCourses;
    }

}
