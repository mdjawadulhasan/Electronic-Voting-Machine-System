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
import java.sql.SQLException;

@WebServlet("/votersregister")
public class VotersRegServlet extends HttpServlet {

    @Resource(name = "jdbc/evm_db")
    private DataSource dataSource;



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Voters voters = new Voters(request.getParameter("username"), request.getParameter("password"), request.getParameter("email"));
        VotersUtil votersUtil = new VotersUtil();
        try {
            votersUtil.create(voters, dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("success", "Registration Successful");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/VotersRegistration.jsp");
        requestDispatcher.forward(request, response);
    }
}
