<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "com.cognizant.fraudmanagementsystem.model.FraudAnalysisPersonnel"%>
<%@page import = "com.cognizant.fraudmanagementsystem.util.CurrentUser"%>
<html>
    <head>
        <title>Manage Users</title>
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600&display=swap" rel="stylesheet">
        <link href="../css/data.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/export.js"></script>
    </head>
    <body>
        <nav>
            <li>Fraud Management System</li>
            <li>
                <a class="btn" href="/add-user">Add User</a>   
                <a class="btn" id="logout-btn" href="/logout">Logout</a> 
                <button class="btn" onclick="exportData()">Export</button>
            </li>    
        </nav>
        <div class="container">
            <h1>Users</h1>
            <table id="data">
                <thead>
                    <tr>
                        <td>Id</td>
                        <td>Name</td>
                        <td>Gender</td>
                        <td>Email</td>
                        <td>Authorization</td>
                        <td>Action</td>
                    </tr>
                </thead>
        
                <% ArrayList<FraudAnalysisPersonnel> users = (ArrayList<FraudAnalysisPersonnel>)request.getAttribute("users");
                for(FraudAnalysisPersonnel user : users){ %>
                    <tbody>
                        <tr>
                            <td><%=user.getId()%></td>
                            <td><%=user.getFirstName() + " " + user.getLastName()%></td>
                            <td><%=user.getGender()%></td>
                            <td><%=user.getEmail()%></td>
                            <td>
                                <%if(user.getIsAuthorized() == 0) { %>
                                    Rejected
                                <%} else if(user.getIsAuthorized() == 1) { %> 
                                    Pending
                                <%} else { %> 
                                    Authorized
                                <%}%>
                            </td>
                            <td>
                                <%if(user.getIsAuthorized() == 0) { %>
                                    <form method="post" action="/accept-user">
                                        <button class="btn" type="submit" name="id" value=<%=user.getId()%>>Accept</button>
                                    </form>
                                <%} else if(user.getIsAuthorized() == 1) { %> 
                                    <form method="post" action="/accept-user">
                                        <button class="btn" type="submit" name="id" value=<%=user.getId()%>>Accept</button>
                                    </form>
                                    <form method="post" action="/reject-user">
                                        <button class="btn" type="submit" name="id" value=<%=user.getId()%>>Reject</button>
                                    </form>
                                <%} else { %> 
                                    <form method="post" action="/reject-user">
                                        <button class="btn" type="submit" name="id" value=<%=user.getId()%>>Reject</button>
                                    </form>
                                <%}%>
                            </td>
                        </tr>
                    </tbody>
                    <%}%>
            </table>
        </div>
    </body>
</html>