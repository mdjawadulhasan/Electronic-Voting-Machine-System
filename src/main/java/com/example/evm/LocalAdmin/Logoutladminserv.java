package com.example.evm.LocalAdmin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/logoutladmin")
public class Logoutladminserv extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session=req.getSession();
        session.removeAttribute("username");
        session.invalidate();
        resp.sendRedirect("localadminlogin.jsp");
    }
}
