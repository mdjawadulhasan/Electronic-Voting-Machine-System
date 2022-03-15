package com.example.evm.Voters;

import com.example.evm.Candidate.Candidates;
import com.example.evm.Candidate.Candidateutill;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(value = "/Givecnvote")
public class GiveVoteserv extends HttpServlet {


    @Resource(name = "jdbc/evm_db")
    private DataSource dataSource;


    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;


    public void CastVote(DataSource dataSource, Voters voter, int scanid) throws SQLException {
        this.connection = dataSource.getConnection();

        Candidates candidate=new Candidates();
        Candidateutill cnUtil = new Candidateutill();
        try {
            candidate=cnUtil.GetApprvcn(scanid, dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String sql = "INSERT INTO votecount (voteid,canid,areacode,voterid,candname) VALUES (?, ?, ?, ?,?)";

        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, 0);
        this.preparedStatement.setInt(2, scanid);
        this.preparedStatement.setString(3, voter.getAreacode());
        this.preparedStatement.setInt(4, voter.getId());
        this.preparedStatement.setString(5, candidate.getName());
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

        int scanid = Integer.parseInt(req.getParameter("id"));


        Voters vtr = new Voters();
        VotersUtil vtutill = new VotersUtil();


        HttpSession session = req.getSession();
        Voters voter = (Voters) session.getAttribute("currentvoter");


        try {
            vtr = vtutill.GetVoterforaprv(voter.getId(), dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int count = 0;
        int isactive;

        isactive = vtr.getIsActive();


        try {
            count = vtutill.ValidateVoter(voter.getId(), dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

       voter = (Voters) session.getAttribute("currentvoter");


        if(isactive==0){
            session.setAttribute("notallowed",voter);
            resp.sendRedirect("VotersRegistration.jsp");
        }
        else if(count>0){
            session.setAttribute("alreadyvoted",voter);
            resp.sendRedirect("VotersRegistration.jsp");
        }

       else if (count == 0 && isactive == 1) {
            try {

                CastVote(dataSource, vtr, scanid);


                session.setAttribute("voted",voter);
                resp.sendRedirect("VotersRegistration.jsp");


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
