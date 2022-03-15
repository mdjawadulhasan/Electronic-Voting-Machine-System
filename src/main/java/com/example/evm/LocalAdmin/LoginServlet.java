package com.example.evm.LocalAdmin;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Resource(name = "jdbc/evm_db")
    private DataSource dataSource;



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LocalAdminUtil localAdminUtil = new LocalAdminUtil();
        boolean result = false;
        try {
            result = localAdminUtil.isValidUser(username, password, dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("LocalAdminHome.jsp");



        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("error", "Login Failed!");
            response.sendRedirect("localadminlogin.jsp");

        }

    }
}
