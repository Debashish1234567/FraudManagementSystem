<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Forgot Password</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600&display=swap" rel="stylesheet">
    <link href="../css/registration.css" rel="stylesheet" type="text/css">
    <script src="../js/forgotPasswordValidation.js" type="text/javascript"></script>
</head>

<body>
    <div class="container">
        <h1>Forgot Password</h1>
        <form method="post" onsubmit="return validate()">
            <label>User Id</label>
            <input id="userId" type="text" name="id" placeholder="" />
            <p id="userIdError" class="error"></p>
            <label>What is your favourite colour?</label>
            <input id="firstAnswer" type="text" name="firstAnswer" placeholder="" />
            <p id="firstAnswerError" class="error"></p>
            <label>Which animal do you like?</label>
            <input id="secondAnswer" type="text" name="secondAnswer" placeholder="" />
            <p id="secondAnswerError" class="error"></p>
            <label>Which mobile company phone do you use?</label>
            <input id="thirdAnswer" type="text" name="thirdAnswer" placeholder="" />
            <p id="thirdAnswerError" class="error"></p>
            <button class="login-btn" type="submit">Next</button>
        </form>
    </div>
</body>

</html>