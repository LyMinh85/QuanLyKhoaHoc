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
                    join course on studentgrade.CourseID = course.CourseID
                    join person on studentgrade.StudentID = person.PersonID
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

    public boolean add(StudentGradeDTO studentGradeDTO) {
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            String queryFindIfExist = """
                    select count(1) as total from studentgrade
                    where CourseID = ? and StudentID = ?
                    """;
            int total = 0;
            try (PreparedStatement stmt = conn.prepareStatement(queryFindIfExist)) {
                stmt.setInt(1, studentGradeDTO.getCourse().getCourseId());
                stmt.setInt(2, studentGradeDTO.getStudent().getPersonId());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    total = rs.getInt("Total");
                }
            }
            // Nếu đã tồn tại học sinh học khóa đó
            if (total > 0) {
                return false;
            }

            String queryAdd = """
                    INSERT INTO studentgrade (CourseID, StudentID, Grade)
                    VALUES (?, ?, ?)
                    """;
            int rowsAdd = 0;
            try (PreparedStatement stmt = conn.prepareStatement(queryAdd)) {
                stmt.setInt(1, studentGradeDTO.getCourse().getCourseId());
                stmt.setInt(2, studentGradeDTO.getStudent().getPersonId());
                stmt.setFloat(3, studentGradeDTO.getGrade());
                rowsAdd = stmt.executeUpdate();
            }
            mySQLDatabaseConnector.closeConnection();
            if (rowsAdd > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(StudentGradeDTO updateStudentGrade) {
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            String queryUpdate = """
                    UPDATE studentgrade
                    SET CourseID = ?, StudentID = ?, Grade = ?
                    WHERE EnrollmentID = ?
                    """;
            int rowsUpdate = 0;
            try (PreparedStatement stmt = conn.prepareStatement(queryUpdate)) {
                stmt.setInt(1, updateStudentGrade.getCourse().getCourseId());
                stmt.setInt(2, updateStudentGrade.getStudent().getPersonId());
                stmt.setFloat(3, updateStudentGrade.getGrade());
                stmt.setInt(4, updateStudentGrade.getEnrollmentId());
                rowsUpdate = stmt.executeUpdate();
            }
            mySQLDatabaseConnector.closeConnection();
            if (rowsUpdate > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
