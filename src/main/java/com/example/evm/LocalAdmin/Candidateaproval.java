package com.example.evm.LocalAdmin;

import com.example.evm.Candidate.Candidates;
import com.example.evm.Candidate.Candidateutill;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet( value = "/Candidateaprv")
public class Candidateaproval extends HttpServlet {

    @Resource(name = "jdbc/evm_db")
    private DataSource dataSource;


    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    public void AprvCandidate(DataSource dataSource,Candidates  candidate) throws SQLException {
        this.connection = dataSource.getConnection();
        String sql = "INSERT INTO approvedcandidate (appcnid,appcnname,apcnage,apcngender,areacode) VALUES (?, ?, ?, ?,?)";

        this.preparedStatement = connection.prepareStatement(sql);

        this.preparedStatement.setInt(1, 0);
        this.preparedStatement.setString(2, candidate.getUsername());
        this.preparedStatement.setInt(3, candidate.getAge());
        this.preparedStatement.setString(4, candidate.getGender());
        this.preparedStatement.setString(5, candidate.getAreacode());
        boolean result = this.preparedStatement.execute();
        this.close();


    }

    public void ActiveCandidate(DataSource dataSource,Candidates  candidate) throws SQLException {
        this.connection = dataSource.getConnection();
        String sql = "UPDATE  candidate set canisactive=? where cnid=?";
        this.preparedStatement = connection.prepareStatement(sql);

        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, 1);
        this.preparedStatement.setInt(2, candidate.getId());
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


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id= Integer.parseInt(req.getParameter("cnid"));
        Candidates  candidate=new Candidates();
        Candidateutill cnUtil = new Candidateutill();
        try {
            candidate=cnUtil.GetCandidateforaprv(id, dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            AprvCandidate(dataSource,candidate);
            ActiveCandidate(dataSource,candidate);
            resp.sendRedirect("ManageCandidate.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
