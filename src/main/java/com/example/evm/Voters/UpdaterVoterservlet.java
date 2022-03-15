package com.example.evm.Voters;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value = "/UpdaterVoterservlet")
public class UpdaterVoterservlet extends HttpServlet {

    @Resource(name = "jdbc/evm_db")
    private DataSource dataSource;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        Voters voters = new Voters(request.getParameter("votername"),request.getParameter("voterareacode") ,Integer.parseInt(request.getParameter("votersge")),request.getParameter("votergender"),Integer.parseInt(request.getParameter("nid")));

        VotersUtil votersUtil = new VotersUtil();
        try {
            votersUtil.UpdateVoter(voters, dataSource);
            Voters voter;
            voter=votersUtil.GetVoters(request.getParameter("voterusername"), request.getParameter("voterpass"), dataSource);
            HttpSession session=request.getSession();
            session.setAttribute("currentvoter",voter);
            response.sendRedirect("VoterProfile.jsp");
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
