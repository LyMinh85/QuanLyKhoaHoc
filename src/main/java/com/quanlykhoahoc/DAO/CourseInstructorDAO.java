package com.quanlykhoahoc.DAO;

import com.quanlykhoahoc.DTO.CourseDTO;
import com.quanlykhoahoc.DTO.CourseInstructorDTO;
import com.quanlykhoahoc.DTO.InstructorDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;

public class CourseInstructorDAO {
    private MySQLDatabaseConnector mySQLDatabaseConnector;

    private CourseInstructorDTO convertResultSetToCourseInstructorDTO(ResultSet resultSet) throws SQLException {
        int courseId = resultSet.getInt("CourseID");
        int personId = resultSet.getInt("PersonID");
        String title = resultSet.getString("Title");
        int credits = resultSet.getInt("Credits");
        int departmentId = resultSet.getInt("DepartmentID");
        String lastName = resultSet.getString("Lastname");
        String firstName = resultSet.getString("Firstname");
        LocalDate hireDate = convertDateToLocalDate(resultSet.getDate("HireDate"));

        CourseDTO courseDTO = new CourseDTO(courseId, title, credits, null);
        InstructorDTO instructorDTO = new InstructorDTO(personId, lastName, firstName, hireDate);
        return new CourseInstructorDTO(courseDTO, instructorDTO);
    }

    public ArrayList<CourseInstructorDTO> getCourseInstructors() {
        ArrayList<CourseInstructorDTO> courseInstructors = null;
        try {
            // Mở kết nối với cơ sở dữ liệu
            mySQLDatabaseConnector = new MySQLDatabaseConnector();
            Connection conn = mySQLDatabaseConnector.getConnection();

            // Khởi tạo arrayList
            courseInstructors = new ArrayList<>();

            // Tạo 1 lệnh sql để lấy tất cả record của bảng CourseInstructor, Course, Person
            String query = "select Course.CourseID, Person.PersonID, Course.Title, Course.Credits, Course.DepartmentID, Person.Lastname, Person.Firstname, Person.HireDate " +
                    "from CourseInstructor, Course, Person " +
                    "where CourseInstructor.CourseID = Course.CourseID " +
                    "and Person.PersonID = CourseInstructor.PersonID";
            // Thực thi query
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                // Kết quả của query
                ResultSet rs = stmt.executeQuery();
                // Lặp hết các dòng của resultSet và thêm vô danh sách courseInstructors
                while (rs.next()) {
                    // Do việc chuyển ResultSet sang CourseInstructorDTO
                    // Sẽ sử dụng nhiều lần nên tạo function convertResultSetToCourseInstructorDTO
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

    public boolean add(CourseInstructorDTO courseInstructorDto) {
        try {
            // Mở kết nối với cơ sở dữ liệu
            mySQLDatabaseConnector = new MySQLDatabaseConnector();
            Connection conn = mySQLDatabaseConnector.getConnection();

            String sql = "INSERT INTO CourseInstructor\n" +
                    "VALUES (?, ?)";

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

    private LocalDate convertDateToLocalDate(Date date) {
        return date.toLocalDate();
    }

    public static void main(String[] args) {
        CourseInstructorDAO courseInstructorDAO = new CourseInstructorDAO();
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(3141);
        InstructorDTO instructorDTO = new InstructorDTO();
        instructorDTO.setPersonId(2);
        CourseInstructorDTO courseInstructorDTO = new CourseInstructorDTO(courseDTO, instructorDTO);
        if (courseInstructorDAO.add(courseInstructorDTO)) {
            System.out.println("Add successfully");
        }

    }
}
