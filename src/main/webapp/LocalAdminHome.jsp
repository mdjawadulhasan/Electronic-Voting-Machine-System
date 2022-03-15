<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>

<%
    String msg= (String) session.getAttribute("username");
    if(msg==null){
        response.sendRedirect("localadminlogin.jsp");
    }

%>



<jsp:include page="LAdminbody.jsp" />

<!DOCTYPE html>
<html>
<head>
    <title>EVM- Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="icon" href="Images/icon.jpg" type="image/icon type">

    <style type="text/css">

        body{
            margin: 0; height: 100%; overflow: hidden;
        }
        .col-md-12{
            margin-top: 200px;
        }

    </style>
</head>
<body>

<div class="row">
    <div class="col-md-12">
        <center><img class="logo" src="Homelogo.png" width="200" length="100"></center>
        <br>
        <center><h1>Welcome</h1></center>
    </div>
</div><br><br><br>





</footer>

</body>
</html>