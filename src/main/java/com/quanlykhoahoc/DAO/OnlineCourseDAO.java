package com.quanlykhoahoc.DAO;

import com.quanlykhoahoc.DTO.CourseDTO;
import com.quanlykhoahoc.DTO.DepartmentDTO;
import com.quanlykhoahoc.DTO.OnlineCourseDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OnlineCourseDAO {

    private final MySQLDatabaseConnector mySQLDatabaseConnector;

    public OnlineCourseDAO() {
        mySQLDatabaseConnector = new MySQLDatabaseConnector();
    }

    private OnlineCourseDTO convertResultSetToOnlineCourseDTO(ResultSet resultSet) throws SQLException {
        int courseId = resultSet.getInt("CourseID");
        String title = resultSet.getString("Title");
        int credits = resultSet.getInt("Credits");
        int departmentId = resultSet.getInt("DepartmentID");
        String departmentName = resultSet.getString("Name");
        String url = resultSet.getString("Url");

        // Gán dữ liệu trong CSDL vào DTO
        DepartmentDTO department = new DepartmentDTO();
        department.setDepartmentId(departmentId);
        department.setName(departmentName);
        CourseDTO courseDTO = new CourseDTO(courseId, title, credits, department);
        OnlineCourseDTO onlineCourse = new OnlineCourseDTO();
        onlineCourse.setCourse(courseDTO);
        onlineCourse.setUrl(url);
        return onlineCourse;
    }

    public ArrayList<OnlineCourseDTO> getOnlineCourses() {
        ArrayList<OnlineCourseDTO> onlineCourses = new ArrayList<>();
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            String query = """
                    SELECT
                        Course.CourseID, Course.Title, Course.Credits, Course.DepartmentID,
                        OnlineCourse.Url, department.Name
                    FROM OnlineCourse
                    JOIN Course ON OnlineCourse.CourseID = Course.CourseID
                    JOIN department ON department.DepartmentID = Course.DepartmentID
                    """;
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    onlineCourses.add(convertResultSetToOnlineCourseDTO(rs));
                }
            }
            mySQLDatabaseConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return onlineCourses;
    }

    //Thêm 1 khóa học Online
    public boolean addOnlineCourse(OnlineCourseDTO onlineCourseDto) {
        try {
            // Mở kết nối với cơ sở dữ liệu
            Connection conn = mySQLDatabaseConnector.getConnection();

            String sql = """
                    INSERT INTO OnlineCourse
                    VALUES (?,?)
                    """;

            int rowsInserted = 0;

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, onlineCourseDto.getCourse().getCourseId());
                stmt.setString(2, onlineCourseDto.getUrl());
                rowsInserted = stmt.executeUpdate();
                System.out.println(rowsInserted);
                if (rowsInserted > 0) {
                    return true;
                }
            }
            mySQLDatabaseConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //update
    public boolean update(OnlineCourseDTO updateOnlineCourse) {
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            String queryUpdateOne = """
                    UPDATE OnlineCourse as OC, Course as C
                    SET C.Title = ?, C.Credits = ?, C.DepartmentID = ?, OC.Url= ?
                    WHERE OC.CourseID = C.CourseID and C.CourseID = ?  
                    """;
            int rowsUpdated = 0;
            try (PreparedStatement stmt = conn.prepareStatement(queryUpdateOne)) {
                stmt.setString(1, updateOnlineCourse.getCourse().getTitle());
                stmt.setInt(2, updateOnlineCourse.getCourse().getCredits());
                stmt.setInt(3, updateOnlineCourse.getCourse().getDepartment().getDepartmentId());
                stmt.setString(4, updateOnlineCourse.getUrl());
                stmt.setInt(5, updateOnlineCourse.getCourse().getCourseId());
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

    //delete
    public boolean delete(int OnlineCourseId) {
        try {
            int rows = 0;
            Connection conn = mySQLDatabaseConnector.getConnection();
            String sql = "DELETE FROM onlineCourse WHERE CourseID = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, OnlineCourseId);
                rows = stmt.executeUpdate();
            }

            if (rows > 0) {
                return true;
            }
            mySQLDatabaseConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //tìm kiếm theo tên
    public ArrayList<OnlineCourseDTO> findByCourseTitle(String courseTitle) {
        ArrayList<OnlineCourseDTO> onlineCourses = new ArrayList<>();
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            courseTitle = "%" + courseTitle + "%";
            String query = """
                    SELECT
                        Course.CourseID, Course.Title, Course.Credits, Course.DepartmentID,
                        OnlineCourse.Url, department.Name
                    FROM OnlineCourse
                    JOIN Course ON OnlineCourse.CourseID = Course.CourseID
                    JOIN department ON department.DepartmentID = Course.DepartmentID
                    WHERE Course.Title like ?;
                    """;
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, courseTitle);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    onlineCourses.add(convertResultSetToOnlineCourseDTO(rs));
                }
            }
            mySQLDatabaseConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return onlineCourses;
    }

    public static void main(String[] args) {
        OnlineCourseDAO o = new OnlineCourseDAO();
        DepartmentDTO departmentDTO = new DepartmentDTO();
        CourseDTO courseDTO = new CourseDTO(4041, "Nhu cut", 10, departmentDTO);
        OnlineCourseDTO onlineCourseDTO = new OnlineCourseDTO(courseDTO, "Link an cut");
    }
}
