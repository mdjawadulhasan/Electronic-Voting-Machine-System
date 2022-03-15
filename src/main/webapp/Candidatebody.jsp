<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.example.evm.Voters.Voters" %>

<%@ page import="com.example.evm.Candidate.Candidates" %><%--
  Created by IntelliJ IDEA.
  Voters: Jawad
  Date: 3/11/2022
  Time: 3:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%

    Candidates cn= (Candidates) session.getAttribute("currencn");
    if(cn==null){
        response.sendRedirect("Candidatereg.jsp");

    }
    else{

    }

%>



<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>
    <link rel="stylesheet" href="CSS/Adminnavbar.css" />
    <link rel="icon" href="Images/icon.jpg" type="image/icon type">

</head>
<body>
<div class="menu-bar">
    <h1 class="logo"><img src="Images/icon.jpg" alt="Italian Trulli" width="30" height="28"><span>  EVM</span></h1>
    <ul>

        <li><a href="#">Hello <%=cn.getUsername()%></a></li>
        <li><a href="CandidateProfile.jsp">Profile</a></li>
       <%-- <li><a href="#">Give Vote</a></li>
        <li><a href="#">See Result</a></li>--%>
        <li><a href="logoutcandidate">Logout</a></li>
    </ul>
</div>



</body>
</html>