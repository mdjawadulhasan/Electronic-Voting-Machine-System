package com.example.evm.Candidate;

import com.example.evm.Voters.Voters;
import com.example.evm.Voters.VotersUtil;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/candidatelogin")
public class CandidateLoginServlet extends HttpServlet {

    @Resource(name = "jdbc/evm_db")
    private DataSource dataSource;



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Candidateutill cnUtil = new Candidateutill();
        Candidates candidate;

        try {
            candidate=cnUtil.GetCandidate(username, password, dataSource);
            if(candidate==null){

                HttpSession session = request.getSession();
                session.setAttribute("error", "Login Failed!");
                response.sendRedirect("Candidatereg.jsp");
            }
            else{

                HttpSession session=request.getSession();
                session.setAttribute("currencn",candidate);
                response.sendRedirect("CandidateProfile.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
