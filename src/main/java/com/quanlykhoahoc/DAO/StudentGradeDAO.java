package com.quanlykhoahoc.DAO;

import com.quanlykhoahoc.DTO.CourseDTO;
import com.quanlykhoahoc.DTO.StudentDTO;
import com.quanlykhoahoc.DTO.StudentGradeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentGradeDAO {
    private MySQLDatabaseConnector mySQLDatabaseConnector;

    public StudentGradeDAO() {
        mySQLDatabaseConnector = new MySQLDatabaseConnector();
    }

    private StudentGradeDTO convertResultSetToStudentGradeDTO(ResultSet rs) throws SQLException {
        int enrollmentId = rs.getInt("EnrollmentID");
        int studentId = rs.getInt("StudentID");
        int courseId = rs.getInt("CourseID");
        float grade = rs.getFloat("Grade");
        String lastName = rs.getString("Lastname");
        String firstName = rs.getString("Firstname");
        String title = rs.getString("Title");
        int credits = rs.getInt("Credits");

        StudentDTO student = new StudentDTO(studentId, lastName, firstName, null);
        CourseDTO course = new CourseDTO(courseId, title, credits, null);
        return new StudentGradeDTO(enrollmentId, course, student, grade);
    }

    public ArrayList<StudentGradeDTO> getStudentGrades() {
        // Tạo list StudentGradeDTO chứa dữ liệu lấy từ database
        ArrayList<StudentGradeDTO> studentGrades = new ArrayList<>();
        try {
            // Mở kết nối
            Connection conn = mySQLDatabaseConnector.getConnection();
            String queryGetAll = """
                    select enrollmentid, course.CourseID, studentid, grade, lastname, firstname, title, credits
                    from studentgrade
                    inner join course on studentgrade.CourseID = course.CourseID
                    inner join person on studentgrade.StudentID = person.PersonID
                    """;
            try (PreparedStatement stmt = conn.prepareStatement(queryGetAll)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    // Chuyển ResultSet thành StudentGradeDTO
                    // Sau đó thêm vào list studentGrades
                    studentGrades.add(convertResultSetToStudentGradeDTO(rs));
                }
            }
            mySQLDatabaseConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentGrades;
    }

    public boolean delete(int enrollmentId) {
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            String queryDeleteOne = "delete from Studentgrade where EnrollmentID = ? ";
            int rowsDeleted = 0;
            try (PreparedStatement stmt = conn.prepareStatement(queryDeleteOne)) {
                stmt.setInt(1, enrollmentId);
                rowsDeleted = stmt.executeUpdate();
            }
            mySQLDatabaseConnector.closeConnection();
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<StudentGradeDTO> findByCourseTitleOrStudentName(String text) {
        ArrayList<StudentGradeDTO> studentGrades = new ArrayList<>();
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            text = "%" + text + "%";
            String queryFind = """
                    select
                        enrollmentid, course.CourseID, studentid, grade, lastname,
                        firstname, title, credits
                    from studentgrade
                    inner join course on studentgrade.CourseID = course.CourseID
                    inner join person on studentgrade.StudentID = person.PersonID
                    where
                        course.Title like ? or
                        CONCAT(person.Lastname, ' ', person.Firstname) like ?
                    """;
            try (PreparedStatement stmt = conn.prepareStatement(queryFind)) {
                stmt.setString(1, text);
                stmt.setString(2, text);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    studentGrades.add(convertResultSetToStudentGradeDTO(rs));
                }
            }
            mySQLDatabaseConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentGrades;
    }


}
