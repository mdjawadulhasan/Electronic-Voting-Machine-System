package com.example.evm.LocalAdmin;

import com.example.evm.Candidate.Candidates;
import com.example.evm.Candidate.Candidateutill;
import com.example.evm.Voters.Voters;
import com.example.evm.Voters.VotersUtil;

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

@WebServlet( value ="/Voteraprv")
public class Voteraprv extends HttpServlet {

    @Resource(name = "jdbc/evm_db")
    private DataSource dataSource;


    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;



    public void ActiveCandidate(DataSource dataSource,Voters voter) throws SQLException {
        this.connection = dataSource.getConnection();
        String sql = "UPDATE  VOTERS set isactive=? where nid=?";
        this.preparedStatement = connection.prepareStatement(sql);

        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, 1);
        this.preparedStatement.setInt(2,  voter.getId());
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

        int id= Integer.parseInt(req.getParameter("nid"));


        Voters vtr=new Voters();
        VotersUtil vtutill=new VotersUtil();



        try {
            vtr=vtutill.GetVoterforaprv(id, dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {

            ActiveCandidate(dataSource,vtr);
            resp.sendRedirect("ManageVoters.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}