package com.example.evm.Candidate;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/Updatercandidate")
public class Updatercndservlet extends HttpServlet {

    @Resource(name = "jdbc/evm_db")
    private DataSource dataSource;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Candidates cn = new Candidates(request.getParameter("cnname"),request.getParameter("cnareacode") ,Integer.parseInt(request.getParameter("cnage")),request.getParameter("cngender"),Integer.parseInt(request.getParameter("cnid")));



        Candidateutill cnUtil = new Candidateutill();
        try {
            cnUtil.UpdateCandidate(cn, dataSource);
            Candidates cnd;
            cnd=cnUtil.GetCandidate(request.getParameter("cnusername"), request.getParameter("cnpass"), dataSource);
            HttpSession session=request.getSession();
            session.setAttribute("currencn",cnd);
            response.sendRedirect("CandidateProfile.jsp");

        } catch (SQLException e) {
            e.printStackTrace();


        }

    }
}
