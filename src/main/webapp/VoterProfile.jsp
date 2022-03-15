<%@ page import="com.example.evm.Voters.Voters" %>
<%@ page errorPage="error.jsp" %><%--
  Created by IntelliJ IDEA.
  User: Jawad
  Date: 3/11/2022
  Time: 4:15 PM
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

<jsp:include page="Votersbody.jsp"/>

<html>
<head>
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="CSS/Voterprofile.css"/>
</head>
<body>

<form action="UpdaterVoterservlet" method="post">
    <div class="container rounded bg-white mt-5 mb-5">
        <div class="row">
            <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5"
                                                                                             width="150px"
                                                                                             src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
                        class="font-weight-bold"><%=voter.getName()%></span><span
                        class="text-black-50"><%=voter.getEmail()%></span><span> </span></div>
            </div>
            <div class="col-md-5 border-right">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Profile Settings</h4>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-6"><label class="labels">Name</label><input type="text" class="form-control"
                                                                                       name="votername"
                                                                                       value="<%=voter.getName()%>">
                        </div>
                        <div class="col-md-6"><label class="labels">Username</label><input type="text" name="voterusername" class="form-control"
                                                                                           value="<%=voter.getUsername()%>"
                                                                                          >
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">NID Number</label><input type="text" name="nid"
                                                                                              class="form-control"
                                                                                              value="<%=voter.getId()%>">
                        </div>
                        <div class="col-md-12"><label class="labels">Area Code</label><input type="text" name="voterareacode"
                                                                                             class="form-control"
                                                                                             value="<%=voter.getAreacode()%>">
                        </div>
                        <div class="col-md-12"><label class="labels">Age</label><input type="text" name="votersge"
                                                                                       class="form-control"
                                                                                       placeholder="enter address line 2"
                                                                                       value="<%=voter.getAge()%>"></div>
                        <div class="col-md-12"><label class="labels">Gender</label><input type="text" name="votergender" class="form-control"
                                                                                          value="<%=voter.getGender()%>">
                        </div>

                        <div class="col-md-12"><label class="labels">Password</label><input type="text" name="voterpass"
                                                                                                 class="form-control"
                                                                                                 value="<%=voter.getPass()%>">
                        </div>

                        <div class="col-md-12"><label class="labels">Active Status</label> <lebel id="labelac"><input type="text"
                                                                                                                      class="form-control"
                                                                                                                      value="<%=voter.getIsActive()%>"></lebel>
                        </div>

                        <div class="mt-5 text-center">
                            <button type="submit" class="btn btn-primary profile-button" >Update Profile</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</form>
<%
    if(voter.getIsActive()==1){
%>
<script>
    document.getElementById("labelac").innerHTML="Active";
    document.getElementById("labelac").style.color="green"
</script>
<%
}else{
%>
<script>
    document.getElementById("labelac").innerHTML="Not Active"
    document.getElementById("labelac").style.color="red"
</script>

<%
    }
%>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
