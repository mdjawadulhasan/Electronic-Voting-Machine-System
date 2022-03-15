package com.example.evm.Voters;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(value = "/logoutvoter")
public class Logoutvoter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


       HttpSession session=req.getSession();
       session.removeAttribute("currentvoter");
       session.invalidate();
       resp.sendRedirect("VotersRegistration.jsp");
    }
}
