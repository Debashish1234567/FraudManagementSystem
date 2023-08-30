<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600&display=swap" rel="stylesheet">
    <link href="../css/dashboard.css" rel="stylesheet" type="text/css">
</head>
<body>
    <nav>
        <li>Fraud Management System</li>
        <li><a id="logout-btn" href="/logout">Logout</a></li>        
    </nav>
    <div class="container">
        <div class="card-wrapper">
            <div id="card" class="card"></div>
            <a href="/card-admin">Credit/Debit</a>
        </div>
        <div class="card-wrapper">
            <div id="transaction" class="card"></div>
            <a href="/transaction-admin">Transaction</a>
        </div>
        <div class="card-wrapper">
            <div id="claim" class="card"></div>
            <a href="/claim-admin">Claim</a>
        </div>
        <div class="card-wrapper">
            <div id="user" class="card"></div>
            <a href="/manage-users">Manage Users</a>
        </div>
        
    </div>
</body>

</html>