<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "com.cognizant.fraudmanagementsystem.model.Transaction"%>
<%@page import = "com.cognizant.fraudmanagementsystem.util.CurrentUser"%>
<html>
    <head>
        <title>Transaction Frauds</title>
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600&display=swap" rel="stylesheet">
        <link href="../css/data.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/export.js"></script>
    </head>
    <body>
        <nav>
            <li>Fraud Management System</li>
            <li>
                <a class="btn" href="/add-transaction-fraud">Add Transaction Fraud</a>   
                <a class="btn" id="logout-btn" href="/logout">Logout</a> 
            </li>    
        </nav>
        <div class="search">
            <form method="post" action="/transaction-search">
                <input type="text" name="query" placeholder="query">
                <select name="type">
                    <option value="cardType">Card Type</option>
                    <option value="userId">User Id</option>
                    <option value="fraudLevel">FraudLevel</option>
                </select>
                <button class="btn" type="submit">Search</button>
                <% 
                    String type = CurrentUser.type;
                    if (type.equals("Admin")) {%>
                    <button class="btn" onclick="exportData()">Export</button>
                <%}%>
            </form>
        </div>
        <div class="container">
            <h1>Transaction Frauds</h1>
            <table id="data">
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Account No.</td>
                        <td>Card No.</td>
                        <td>Fraud Level</td>
                        <td>Transaction Details</td>
                        <td>Action</td>
                    </tr>
                </thead>
        
                <% ArrayList<Transaction> transactions = (ArrayList<Transaction>)request.getAttribute("transactions");
                for(Transaction transaction : transactions){ %>
                    <tbody>
                        <tr>
                            <td><%=transaction.getCardHolderName()%></td>
                            <td><%=transaction.getAccountNo()%></td>
                            <td><%=transaction.getCardNo()%></td>
                            <td><%=transaction.getFraudLevel()%></td>
                            <td><%=transaction.getTransactionDetails()%></td>
                            <td>
                                <%  String id = CurrentUser.id;
                                if (type.equals("Admin")){%>
                                <form method="post" action="/transaction-delete-admin">
                                    <button class="btn" type="submit" name="id" value=<%=transaction.getId()%>>Delete</button>
                                </form>
                            <%} else if(transaction.getUserId().equals(id)) {%>
                                <form method="post" action="/transaction-delete">
                                    <button class="btn" type="submit" name="id" value=<%=transaction.getId()%>>Delete</button>
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