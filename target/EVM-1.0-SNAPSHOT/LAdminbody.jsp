<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  Voters: Jawad
  Date: 3/11/2022
  Time: 3:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    response.setHeader("Cache-control","no-cache,no-store,must-revalidate");

    String msg= (String) session.getAttribute("username");
    if(msg==null){
        response.sendRedirect("localadminlogin.jsp");
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
        <li><a href="LocalAdminHome.jsp">Home</a></li>
        <li><a href="ManageCandidate.jsp">Manage Candidate</a></li>
        <li><a href="ManageVoters.jsp">Manage Voters</a></li>
        <li><a href="VoteResult.jsp">View Result</a></li>
        <li><a href="logoutladmin">Logout</a></li>
    </ul>
</div>


</body>
</html>