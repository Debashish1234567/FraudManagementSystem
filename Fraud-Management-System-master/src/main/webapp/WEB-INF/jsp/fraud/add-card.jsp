<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Add Card Fraud</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600&display=swap" rel="stylesheet">
    <link href="../css/addCard.css" rel="stylesheet" type="text/css">
    <script src="../js/addCardValidation.js" type="text/javascript"></script>
</head>

<body>
    <nav>
        <li>Fraud Management System</li>
        <li><a id="logout-btn" href="/logout">Logout</a></li>        
    </nav>
    <div class="container">
        <h1>Add a card fraud</h1>
        <form method="post" onsubmit="return validate()" modelAttribute="card">
            <label>Card No.</label>
            <input id="cardNo" type="text" name="cardNo" placeholder="Enter your card no."/>
            <p id="cardNoError" class="error"></p>
            <label>User Id</label>
            <input id="userId" type="text" name="userId" placeholder="Enter user id."  />
            <p id="userIdError" class="error"></p>
            <label>Card Holder Name</label>
            <input id="cardHolderName" type="text" name="cardHolderName" placeholder="Enter card holder name."  />
            <p id="cardHolderNameError" class="error"></p>
            <label>Card Type</label>
            <select id="cardType" name="cardType">
                <option value="">Select card type</option>
                <option value="Debit">Debit</option>
                <option value="Credit">Credit</option>
            </select>
            <p id="cardTypeError" class="error"></p>
            <label>Account No.</label>
            <input id="accountNo" type="text" name="accountNo" placeholder="Enter your account no."  />
            <p id="accountNoError" class="error"></p>
            <label>Card expiry date</label>
            <input id="expiryDate" type="text" name="expiryDate" placeholder="Enter your card expiry date"  />
            <p id="expiryDateError" class="error"></p>
            <label>Transaction Date</label>
            <input id="transactionDate" type="text" name="transactionDate" placeholder="Transaction date"  />
            <p id="transactionDateError" class="error"></p>
            <label>Transaction Details</label>
            <input id="transactionDetails" type="text" name="transactionDetails" placeholder="Transaction Details"  />
            <p id="transactionDetailsError" class="error"></p>
            <label>Remarks</label>
            <input id="remarks" type="text" name="remarks" placeholder="Remarks"  />
            <p id="remarksError" class="error"></p>
            <label>Fraud Level</label>
            <select id="fraudLevel" name="fraudLevel">
                <option value="">Select fraud level</option>
                <option value="Extreme">Extreme</option>
                <option value="High">High</option>
                <option value="Medium">Medium</option>
                <option value="Low">Low</option>
            </select>
            <p id="fraudLevelError" class="error"></p>
            <button id="add-btn" type="submit">Add</button>
        </form>
    </div>
</body>

</html>