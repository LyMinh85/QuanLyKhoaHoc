package com.quanlykhoahoc.DAO;

import com.quanlykhoahoc.DTO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

public class CourseInstructorDAO {
    private final MySQLDatabaseConnector mySQLDatabaseConnector;

    public CourseInstructorDAO() {
        mySQLDatabaseConnector = new MySQLDatabaseConnector();
    }

    private CourseInstructorDTO convertResultSetToCourseInstructorDTO(ResultSet resultSet) throws SQLException {
        int courseId = resultSet.getInt("CourseID");
        int personId = resultSet.getInt("PersonID");
        String title = resultSet.getString("Title");
        int credits = resultSet.getInt("Credits");
        String lastName = resultSet.getString("Lastname");
        String firstName = resultSet.getString("Firstname");
        LocalDate hireDate = resultSet.getDate("HireDate").toLocalDate();

        CourseDTO courseDTO = new CourseDTO(courseId, title, credits, null);
        InstructorDTO instructorDTO = new InstructorDTO(personId, lastName, firstName, hireDate);
        return new CourseInstructorDTO(courseDTO, instructorDTO);
    }

    public ArrayList<CourseInstructorDTO> getCourseInstructors() {
        ArrayList<CourseInstructorDTO> courseInstructors = null;
        try {
            // Mở kết nối với cơ sở dữ liệu
            Connection conn = mySQLDatabaseConnector.getConnection();

            // Khởi tạo arrayList
            courseInstructors = new ArrayList<>();

            // Tạo 1 lệnh sql để lấy tất cả
            // record của bảng CourseInstructor, Course, Person
            String query = """
                    select
                        Course.CourseID, Person.PersonID, Course.Title,
                        Course.Credits, Person.Lastname, Person.Firstname,
                        Person.HireDate
                    from CourseInstructor, Course, Person
                    where
                        CourseInstructor.CourseID = Course.CourseID
                        and Person.PersonID = CourseInstructor.PersonID
                    """;
            // Thực thi query
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                // Kết quả của query
                ResultSet rs = stmt.executeQuery();
                // Lặp hết các dòng của resultSet và thêm vô danh sách courseInstructors
                while (rs.next()) {
                    // Do việc chuyển ResultSet sang CourseInstructorDTO
                    // Sẽ sử dụng nhiều lần nên tạo
                    // function convertResultSetToCourseInstructorDTO
                    // Để sử dụng lại
                    courseInstructors.add(convertResultSetToCourseInstructorDTO(rs));
                }

            }
            // Sau khi thực thi xong thì đóng connection lại
            mySQLDatabaseConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Trả về danh sách
        return courseInstructors;
    }

    // Add one CourseInstructor
    public boolean add(CourseInstructorDTO courseInstructorDto) {
        try {
            // Mở kết nối với cơ sở dữ liệu
            Connection conn = mySQLDatabaseConnector.getConnection();

            String sql = """
                    INSERT INTO CourseInstructor
                    VALUES (?, ?)
                    """;

            int rowsInserted = 0;

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, courseInstructorDto.getCourse().getCourseId());
                stmt.setInt(2, courseInstructorDto.getInstructor().getPersonId());
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

    public boolean update(int courseId, int instructorId, CourseInstructorDTO updateCourseInstructor) {
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();

            String queryUpdateOne = """
                    UPDATE CourseInstructor as CI
                    SET CI.CourseID = ?, CI.PersonID = ?
                    WHERE CI.CourseID = ? and CI.PersonID = ?
                    """;
            int rowsUpdated = 0;
            try (PreparedStatement stmt = conn.prepareStatement(queryUpdateOne)) {
                stmt.setInt(1, updateCourseInstructor.getCourse().getCourseId());
                stmt.setInt(2, updateCourseInstructor.getInstructor().getPersonId());
                stmt.setInt(3, courseId);
                stmt.setInt(4, instructorId);
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

    public boolean delete(int courseId, int instructorId) {
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();

            String queryDelete = """
                    DELETE FROM CourseInstructor as CI
                    WHERE CI.CourseID = ? and CI.PersonID = ?
                    """;

            int rowDeleted = 0;
            try (PreparedStatement stmt = conn.prepareStatement(queryDelete)) {
                stmt.setInt(1, courseId);
                stmt.setInt(2, instructorId);
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

    public ArrayList<CourseInstructorDTO> findByCourseTitleOrInstructor(String name) {
        ArrayList<CourseInstructorDTO> courseInstructors = null;
        try {
            Connection conn = mySQLDatabaseConnector.getConnection();
            name = "%" + name + "%";


            String querySearch = """
                    SELECT
                        Course.CourseID, Person.PersonID, Course.Title, Course.Credits,
                        Person.Lastname, Person.Firstname, Person.HireDate
                    FROM CourseInstructor, Course, Person
                    WHERE
                        CourseInstructor.CourseID = Course.CourseID
                        AND Person.PersonID = CourseInstructor.PersonID
                        AND (
                            Course.Title LIKE ?
                            OR  CONCAT(Person.Lastname, " ", Person.Firstname) LIKE ?
                            )
                    """;

            try (PreparedStatement stmt = conn.prepareStatement(querySearch)) {
                stmt.setString(1, name);
                stmt.setString(2, name);
                ResultSet rs = stmt.executeQuery();

                courseInstructors = new ArrayList<>();
                while (rs.next()) {
                    courseInstructors.add(convertResultSetToCourseInstructorDTO(rs));
                }
                mySQLDatabaseConnector.closeConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseInstructors;
    }

}
