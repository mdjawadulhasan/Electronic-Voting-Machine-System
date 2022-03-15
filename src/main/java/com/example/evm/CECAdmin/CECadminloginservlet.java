package com.example.evm.CECAdmin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/CECadmin")
public class CECadminloginservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = "cecadmin";
        String password = "123";

        String uname = req.getParameter("uname");
        String pass = req.getParameter("psw");


        if (username.equals(uname) && pass.equals(password)) {
            HttpSession s=req.getSession();
            s.setAttribute("cecuser",username);
            resp.sendRedirect("AddLadmin.jsp");
        }
        else{
            HttpSession session = req.getSession();
            session.setAttribute("error", "Login Failed!");
            resp.sendRedirect("CECadminlogin.jsp");
        }

        
    }
}