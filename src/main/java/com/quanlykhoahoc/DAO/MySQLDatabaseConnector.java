package com.quanlykhoahoc.DAO;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabaseConnector {
    private final String HOST = "localhost";
    private final int PORT = 3306;
    private final String DATABASE_NAME = "school";
    private final String USERNAME = "root";
    private final String PASSWORD = "85659712"; //Password của mn 
    private Connection conn;
    private final MysqlDataSource dataSource;

    public MySQLDatabaseConnector() {
        dataSource = new MysqlDataSource();
        dataSource.setServerName(HOST);
        dataSource.setDatabaseName(DATABASE_NAME);
        dataSource.setPortNumber(PORT);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);
    }

    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = dataSource.getConnection();
        }
        return conn;
    }

    public void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;
        }
    }

}
