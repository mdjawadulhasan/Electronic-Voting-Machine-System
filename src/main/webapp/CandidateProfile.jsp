<%@ page import="com.example.evm.Candidate.Candidates" %>
<%@ page errorPage="error.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: Jawad
  Date: 3/12/2022
  Time: 8:03 PM
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


<jsp:include page="Candidatebody.jsp"/>



<html>
<head>
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="CSS/Voterprofile.css"/>
</head>
<body>

<form action="Updatercandidate" method="post">
    <div class="container rounded bg-white mt-5 mb-5">
        <div class="row">
            <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5"
                                                                                             width="150px"
                                                                                             src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
                        class="font-weight-bold"><%=cn.getName()%></span><span
                        class="text-black-50"><%=cn.getEmail()%></span><span> </span></div>
            </div>
            <div class="col-md-5 border-right">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Profile Settings</h4>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-6"><label class="labels">Name</label><input type="text" class="form-control"
                                                                                       name="cnname"
                                                                                       value="<%=cn.getName()%>">
                        </div>
                        <div class="col-md-6"><label class="labels">Username</label><input type="text" name="cnusername" class="form-control"
                                                                                           value="<%=cn.getUsername()%>"
                                                                                           >
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">NID Number</label><input type="text" name="cnid"
                                                                                              class="form-control"
                                                                                              value="<%=cn.getId()%>">
                        </div>
                        <div class="col-md-12"><label class="labels">Area Code</label><input type="text" name="cnareacode"
                                                                                             class="form-control"
                                                                                             value="<%=cn.getAreacode()%>">
                        </div>
                        <div class="col-md-12"><label class="labels">Age</label><input type="text" name="cnage"
                                                                                       class="form-control"
                                                                                       value="<%=cn.getAge()%>"></div>
                        <div class="col-md-12"><label class="labels">Gender</label><input type="text" name="cngender" class="form-control"
                                                                                          value="<%=cn.getGender()%>">
                        </div>

                        <div class="col-md-12"><label class="labels">Password</label><input type="text" name="cnpass"
                                                                                            class="form-control"
                                                                                            value="<%=cn.getPass()%>">
                        </div>

                        <div class="col-md-12"><label class="labels">Active Status</label><lebel id="labelac"><input type="text"
                                                                                                                     class="form-control"
                                                                                                                     value="<%=cn.getIsActive()%>"></lebel>
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
    if(cn.getIsActive()==1){
%>
<script>
    document.getElementById("labelac").innerHTML=" Active";

</script>
<%
}else{
%>
<script>
    document.getElementById("labelac").innerHTML=" Not Active"

</script>

<%
    }
%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>

