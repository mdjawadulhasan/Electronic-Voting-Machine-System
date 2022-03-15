<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.evm.LocalAdmin.LocalAdminUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page errorPage="error.jsp" %>--%>

<%
    String user = (String) session.getAttribute("username");
    if (user == null) {
        response.sendRedirect("localadminlogin.jsp");
    }

%>


<jsp:include page="LAdminbody.jsp"/>

<!DOCTYPE html>
<html>
<head>
    <title>Vote Result</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        .col-sm-8{
            margin: auto;
            margin-left: 300px ;
            margin-top: 10px;
        }
    </style>
</head>
<body>


<%
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost/evm_db", "root", "1234");
    String query = "select ladareacode from localadmin where ladusername='" + user + "'";
    Statement st = con.createStatement();
    int areacode = 0;
    rs = st.executeQuery(query);

    while (rs.next()) {
        areacode = rs.getInt("ladareacode");
    }

%>

<div class="col-sm-8">
    <div class="panel-body">
        <table id="tbl-student" class="table table-responsive table-bordered" cellpadding="0" width="100%">
            <thead>
            <tr>
                <th>Candidate Name</th>
                <th>Total Vote</th>
            </tr>
                <%


                                 query= "SELECT candname,COUNT(*) as total FROM votecount WHERE areacode='"+ areacode+"' GROUP BY canid order by  total DESC";
                                 st = con.createStatement();

                                    rs =  st.executeQuery(query);

                                        while(rs.next())
                                        {

                                   %>

            <tr>
                <td><%=rs.getString("candname") %>
                </td>
                <td><%=rs.getInt("total") %>
                </td>
            </tr>
                <%
                                 }
                               %>


        </table>
    </div>

</div>


</body>
</html>