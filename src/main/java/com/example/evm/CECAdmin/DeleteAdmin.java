package com.example.evm.CECAdmin;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(value = "/deleteadmin")
public class DeleteAdmin extends HttpServlet {


    @Resource(name = "jdbc/evm_db")
    private DataSource dataSource;


    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    public void create(DataSource dataSource,String id) throws SQLException {
        this.connection = dataSource.getConnection();
        String sql = "delete from localadmin where ladid = ?";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setString(1,id);
        boolean result = this.preparedStatement.execute();
        this.close();

    }


    private void close() throws SQLException {
        if (this.connection != null)
            this.connection.close();
        if (this.preparedStatement != null)
            this.preparedStatement.close();
        if (this.statement != null)
            this.statement.close();
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id=req.getParameter("id");
        PrintWriter out=resp.getWriter();

        try {
            create(dataSource,id);
            resp.sendRedirect("AddLadmin.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
