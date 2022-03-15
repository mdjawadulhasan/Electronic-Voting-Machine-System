<%@ page import="java.awt.print.Printable" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Jawad
  Date: 3/11/2022
  Time: 12:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<!-- Created by CodingLab |www.youtube.com/c/CodingLabYT-->
<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <!--<title> Login and Registration Form in HTML & CSS | CodingLab </title>-->
    <link rel="stylesheet" href="CSS/Votersregstyle.css"/>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <!-- Fontawesome CDN Link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="Images/icon.jpg" type="image/icon type">
    <title>Registration</title>


</head>
<body>
<div class="container">
    <input type="checkbox" id="flip">
    <div class="cover">
        <div class="front">
            <div class="text">
                <span class="text-1"><br></span>
                <span class="text-2"></span>
            </div>
        </div>
        <div class="back">
            <img class="backImg" src="Images/cover.jpg" alt="">
            <div class="text">
                <span class="text-1"> <br> </span>
                <span class="text-2"></span>
            </div>
        </div>
    </div>
    <div class="forms">
        <div class="form-content">
            <div class="login-form">
                <div class="title">Login</div>
                <form action="candidatelogin" method="post">
                    <div class="input-boxes">
                        <div class="input-box">
                            <i class="fas fa-user"></i>
                            <input type="text" name="username" placeholder="Enter your Username" required>
                        </div>
                        <div class="input-box">
                            <i class="fas fa-lock"></i>
                            <input type="password" name="password" placeholder="Enter your password" required>
                        </div>

                        <div class="button input-box">
                            <input type="submit" value="Sumbit">
                        </div>
                        <div class="text sign-up-text">Don't have an account? <label for="flip">Sigup now</label></div>
                    </div>
                </form>
            </div>
            <div class="signup-form">
                <div class="title">Signup</div>
                <form action="canregister" method="post">
                    <div class="input-boxes">
                        <div class="input-box">
                            <i class="fas fa-user"></i>
                            <input type="text"name="username" placeholder="Enter your Username" required>
                        </div>
                        <div class="input-box">
                            <i class="fas fa-envelope"></i>
                            <input type="text" name="email" placeholder="Enter your email" required>
                        </div>
                        <div class="input-box">
                            <i class="fas fa-lock"></i>
                            <input type="password" name="password" placeholder="Enter your password" required>
                        </div>
                        <div class="button input-box">
                            <input type="submit" value="Sumbit">
                        </div>
                        <div class="text sign-up-text">Already have an account? <label for="flip">Login now</label></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%
    if (request.getSession().getAttribute("success") != null) {

%>

<script>
    Swal.fire(
        'Registration Success!',
        '',
        'success'
    )
</script>


<%
    }

%>

<%
    if (request.getSession().getAttribute("error") != null) {

%>

<script>
    Swal.fire({
        icon: 'error',
        title: 'Wrong Password',
        text: 'Try Again!',

    })

</script>


<%

        session=request.getSession();
        session.removeAttribute("error");
        session.invalidate();
    }

%>

</body>
</html>
