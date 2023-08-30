<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>New Password</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600&display=swap" rel="stylesheet">
    <link href="../css/registration.css" rel="stylesheet" type="text/css">
    <script src="../js/resetPasswordValidation.js" type="text/javascript"></script>
</head>

<body>
    <div class="container">
        <h1>New Password</h1>
        <form method="post" onsubmit="return validate()">
            <label>New Password</label>
            <input id="password" type="password" name="newPassword" placeholder="" autofocus />
            <p id="passwordError" class="error"></p>
            <label>Confirm New Password</label>
            <input id="confirmNewPassword" type="password" name="confirmNewPassword" placeholder="" />
            <p id="confirmNewPasswordError" class="error"></p>
            <button class="login-btn" type="submit">Reset</button>
        </form>
    </div>
</body>

</html>