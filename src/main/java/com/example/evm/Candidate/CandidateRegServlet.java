package com.example.evm.Candidate;

import com.example.evm.Voters.Voters;
import com.example.evm.Voters.VotersUtil;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/canregister")
public class CandidateRegServlet extends HttpServlet {

    @Resource(name = "jdbc/evm_db")
    private DataSource dataSource;



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Candidates candidate = new Candidates(request.getParameter("username"), request.getParameter("password"), request.getParameter("email"));
       Candidateutill cnUtil = new Candidateutill();
        try {
            cnUtil .create(candidate, dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("success", "Registration Successful");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Candidatereg.jsp");
        requestDispatcher.forward(request, response);
    }
}
