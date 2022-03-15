<%@ page import="com.example.evm.Voters.Voters" %>
<%@ page errorPage="error.jsp" %>

<%--
  Created by IntelliJ IDEA.
  User: Jawad
  Date: 3/14/2022
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    Voters voter = (Voters) session.getAttribute("currentvoter");
    if (voter == null) {
        response.sendRedirect("VotersRegistration.jsp");

    } else {
       /* PrintWriter pw=response.getWriter();
        pw.println("Hello ! ");
        pw.println(voter.getUsername());*/
    }

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voter ID Card</title>
    <link rel="icon" href="Images/icon.jpg" type="image/icon type">
    <script src="https://raw.githack.com/eKoopmans/html2pdf/master/dist/html2pdf.bundle.js"></script>
    <style>
        #div1{
            border: 3px solid black;
            width: 680px;
            height: 380px;
            margin-left: 400px;
            margin-top: 40px;
            padding: 0px;
        }
        #img1{
            width: 90px;
            float: left;
        }
        #div2{
            float: left;
            margin-top: 10px;
        }
        #label1{
            font-size: 30px;
            font-weight: bold;
            margin-left: 66px;
            opacity: 0.7;
        }
        #label2{
            color: #0aac12;
            font-size: 25px;
            font-weight: bold;
        }
        #label3{
            color: #e77863;
            font-weight: bold;
            font-size: 24px;
            margin-left: 40px;
        }
        #label4{
            color: #373b3b;
            font-size: 24px;
            font-weight: bold;
        }
        #hr1{
            width: 680px;
            border: 1px solid black;
            background-color: black;
            height: 1px;
            margin-top: 120px;
        }
        #div3{
            float: left;
        }
        #img2{
            width: 250px;
        }
        #img3{
            width: 200px;
            height: 70px;
            margin-left: 8px;
        }
        #label5{
            font-weight: bold;
            font-size: 24px;
            opacity: 0.8;
        }
        p{
            margin-bottom: 0px;
        }
        #label8{
            font-size: 25px;
            font-weight: bold;
        }
        #label6{
            font-weight: bold;
            font-size: 24px;
            margin-left: 10px;
        }
        #labelac{
            font-weight: bold;
            font-size: 24px;
            margin-left: 10px;
        }
        #label7{
            color: #f90605;
            font-weight: bold;
            font-size: 27px;
            margin-left: 10px;
        }
        #label9{
            font-size: 28px;
            font-weight: bold;
            color: #f90605;
            margin-left: 10px;
        }
        .printbtn {

            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 20px;
        }
        .printbtn:hover {
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
            cursor: pointer;
        }
    </style>
</head>
<body>
<div id="nidcard">
    <div id="div1">
        <img id="img1" src="bangladesh1.png" alt="">
        <div id="div2">
            <label id="label1">গণপ্রজাতন্ত্রী বাংলাদেশ সরকার</label><br>
            <label id="label2">Government of the People's Republic of Bangladesh</label><br>
            <label id="label3">National ID CARD</label>
            <label id="label4">/ জাতীয় পরিচয় পত্র</label><br>
        </div>
        <hr id="hr1">
        <div id="div3">
            <img id="img2" src="user.png" alt=""><br>

        </div>
        <div id="div4">
            <p style="margin-top: 6px;"><label id="label5">Name:</label><label id="label6"> <%=voter.getName()%> </label><label id="label6"></label></p>
            <p style="margin-top: 6px;"><label id="label5">Age:</label> <label id="label6"><%=voter.getAge()%></label><label id="label6"></label></p>
            <p style="margin-top: 6px;"><label id="label5">Gender:</label><label id="label6"><%=voter.getGender()%></label> <label id="label6"></label></p>
            <p style="margin-top: 6px;"><label id="label5">Areacode:</label><label id="label6"><%=voter.getAreacode()%> </label><label id="label6"></label></p>
            <p style="margin-top: 6px;"><label id="label5">Nid:</label><label id="label6"><%=voter.getId()%> </label><label id="label6"></label></p>
            <p style="margin-top: 6px;"><label id="label5">Active Status:</label><label id="labelac"><%=voter.getIsActive()%></label> <label id="label6"></label></p>
        </div>
    </div>

</div>
    <button onclick="printDiv('nidcard')" class="printbtn">Print</button>

<%
    if(voter.getIsActive()==1){
        %>
<script>
    document.getElementById("labelac").innerHTML="Active";
</script>
    <%
    }else{
%>
<script>
    document.getElementById("labelac").innerHTML="Not Active"
</script>

<%
    }
%>


<script>
    function printDiv(divName){
        var printContents = document.getElementById(divName).innerHTML;
        var originalContents = document.body.innerHTML;

        document.body.innerHTML = printContents;

        window.print();

        document.body.innerHTML = originalContents;

    }
</script>

</body>
</html>