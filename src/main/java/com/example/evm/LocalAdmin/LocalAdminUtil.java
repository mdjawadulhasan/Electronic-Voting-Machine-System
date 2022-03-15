package com.example.evm.LocalAdmin;

import javax.sql.DataSource;
import java.sql.*;

public class LocalAdminUtil {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;


    public boolean isValidUser(String username, String password, DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
        String sql = "SELECT ladusername, ladpass FROM localadmin where ladusername = ? and ladpass = ?";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setString(1, username);
        this.preparedStatement.setString(2, password);
        ResultSet result = this.preparedStatement.executeQuery();
        boolean response = false;
        if (result.next()) {
            if (username.equals(result.getString(1)) && password.equals(result.getString(2))) {
                response = true;
            }
        }
        this.close();
        return response;
    }

    private void close() throws SQLException {
        if (this.connection != null)
            this.connection.close();
        if (this.preparedStatement != null)
            this.preparedStatement.close();
        if (this.statement != null)
            this.statement.close();
    }



    public  DataSource dataSource;
    public int Getareacode(String username) throws SQLException {
        int areacode= 0;

        this.connection = dataSource.getConnection();
        String sql = "SELECT ladareacode FROM localadmin where ladusername = ? ";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setString(1, username);

        ResultSet result = this.preparedStatement.executeQuery();
        boolean response = false;
        if (result.next()) {
            areacode= result.getInt("candidateareacode");
        }
        this.close();
        return areacode;
    }
}
