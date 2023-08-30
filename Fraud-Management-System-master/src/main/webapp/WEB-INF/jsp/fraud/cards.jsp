<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "com.cognizant.fraudmanagementsystem.model.Card"%>
<%@page import = "com.cognizant.fraudmanagementsystem.util.CurrentUser"%>
<html>
    <head>
        <title>Card Frauds</title>
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600&display=swap" rel="stylesheet">
        <link href="../css/data.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/export.js"></script>
    </head>
    <body>
        <nav>
            <li>Fraud Management System</li>
            <li>
                <a class="btn" href="/add-card-fraud">Add Card Fraud</a>   
                <a class="btn" id="logout-btn" href="/logout">Logout</a> 
            </li>    
        </nav>
        <div class="search">
            <form method="post" action="/card-search">
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
            <h1>Card Frauds</h1>
            <table id="data">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Account No.</th>
                        <th>Card No.</th>
                        <th>Fraud Level</th>
                        <th>Transaction Details</th>
                        <th>Action</th>
                    </tr>
                </thead>
        
                <% ArrayList<Card> cards = (ArrayList<Card>)request.getAttribute("cards");
                for(Card card : cards){ %>
                    <tbody>
                        <tr>
                            <td><%=card.getCardHolderName()%></td>
                            <td><%=card.getAccountNo()%></td>
                            <td><%=card.getCardNo()%></td>
                            <td><%=card.getFraudLevel()%></td>
                            <td><%=card.getTransactionDetails()%></td>
                            <td>
                                <%  String id = CurrentUser.id;
                                if (type.equals("Admin")) {%>
                                <form method="post" action="/card-delete-admin">
                                    <button class="btn" type="submit" name="id" value=<%=card.getId()%>>Delete</button>
                                </form>
                            <%} else if (card.getUserId().equals(id)) {%>
                                <form method="post" action="/card-delete">
                                    <button class="btn" type="submit" name="id" value=<%=card.getId()%>>Delete</button>
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