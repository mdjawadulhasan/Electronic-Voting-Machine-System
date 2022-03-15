package com.example.evm.Voters;

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
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/voterslogin")
public class VotersLoginServlet extends HttpServlet {

    @Resource(name = "jdbc/evm_db")
    private DataSource dataSource;



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        VotersUtil votersUtil = new VotersUtil();
        Voters voter;

        try {
            voter=votersUtil.GetVoters(username, password, dataSource);
            if(voter==null){

                HttpSession session = request.getSession();
                session.setAttribute("error", "Login Failed!");
                response.sendRedirect("VotersRegistration.jsp");
            }
            else{

                HttpSession session=request.getSession();
                session.setAttribute("currentvoter",voter);
                response.sendRedirect("VoterProfile.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
