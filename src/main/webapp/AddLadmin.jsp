<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>

<%
    response.setHeader("Cache-control","no-cache,no-store,must-revalidate");

    String msg= (String) session.getAttribute("cecuser");
    if(msg==null){
        response.sendRedirect("CECadminlogin.jsp");
    }

%>

<jsp:include page="CECadminbody.jsp"/>

<%

    if(request.getParameter("submit")!=null)
    {
        String uname = request.getParameter("uname");
        String areacode = request.getParameter("areacode");
        String pass = request.getParameter("pass");

        Connection con;
        PreparedStatement pst;
        ResultSet rs;

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/evm_db","root","1234");

        pst = con.prepareStatement("insert into localadmin (ladid,ladusername,ladareacode,ladpass)values(?,?,?,?)");

        pst.setString(1, null);
        pst.setString(2, uname);
        pst.setString(3, areacode);
        pst.setString(4, pass);
        pst.executeUpdate();

%>
<script>
    alert("Record Added");
</script>
<%
    }
%>



<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<style>
    .col-sm-4,textshow{
        margin: auto;
        width: 50%;
        border: 3px solid green;
        padding: 10px;
    }

    .col-sm-8{
        margin: auto;
       margin-left: 300px ;
        margin-top: 10px;
    }

</style>
</head>
<body>
<center><h1 >Local Admin Add and Delete</h1></center>
</br>
<div class="row">
    <div class="col-sm-4">
        <form method="POST" action="#">

            <div alight="left">
                <label class="form-label">User Name</label>
                <input type="text" class="form-control" placeholder="User Name-" name="uname" id="uname" required>
            </div>

            <div alight="left">
                <label class="form-label">Area Code</label>
                <input type="text" class="form-control" placeholder="Area Code" name="areacode" id="areacode" required>
            </div>

            <div alight="left">
                <label class="form-label">Passwpord</label>
                <input type="text" class="form-control" placeholder="Password" name="pass" id="pass" required>
            </div>


            </br>

            <div alight="right">
                <input type="submit" id="submit" value="submit" name="submit" class="btn btn-info">
                <input type="reset" id="reset" value="reset" name="reset" class="btn btn-warning">

            </div>

        </form>
    </div>

    <div class="col-sm-8">
        <div class="panel-body">
            <table id="tbl-student" class="table table-responsive table-bordered" cellpadding="0" width="100%">
                <thead>
                <tr>
                    <th>Admin Name</th>
                    <th>Area Code</th>
                    <th>Password</th>
                    <th>Delete</th>
                </tr>
                    <%

                                Connection con;
                                PreparedStatement pst;
                                ResultSet rs;

                                Class.forName("com.mysql.jdbc.Driver");
                                con = DriverManager.getConnection("jdbc:mysql://localhost/evm_db","root","1234");

                                  String query = "select * from localadmin";
                                  Statement st = con.createStatement();

                                    rs =  st.executeQuery(query);

                                        while(rs.next())
                                        {
                                            String id = rs.getString("ladid");
                                   %>

                <tr>

                    <td><%=rs.getString("ladusername") %>
                    </td>
                    <td><%=rs.getString("ladareacode") %>
                    </td>
                    <td><%=rs.getString("ladpass") %>
                    </td>
                    <td><a href="deleteadmin?id=<%=id%>"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
                </tr>
                    <%
                                 }
                               %>


            </table>
        </div>

    </div>
</div>

</body>
</html>