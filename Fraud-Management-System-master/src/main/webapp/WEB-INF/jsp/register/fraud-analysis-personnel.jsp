<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Register</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600&display=swap" rel="stylesheet">
    <link href="../css/registration.css" rel="stylesheet" type="text/css">
    <script src="../js/registrationValidation.js" type="text/javascript"></script>
</head>

<body>
    <div class="container">
        <h1>Register as Fraud Analysis Personnel</h1>
        <form method="post" onsubmit="return validate()" modelAttribute="user">
            <label>User ID</label>
            <input id="userId" type="text" name="id" placeholder="Enter Your ID" autofocus/>
            <p id="userIdError" class="error"></p>
            <label>First Name</label>
            <input id="firstName" type="text" name="firstName" placeholder="Enter your first name"/>
            <p id="firstNameError" class="error"></p>
            <label>Last Name</label>
            <input id="lastName" type="text" name="lastName" placeholder="Enter your last name" />
            <p id="lastNameError" class="error"></p>
            <label>Date of Birth</label>
            <input id="dob" type="text" name="dob" placeholder="Enter your date of birth"/>
            <p id="dobError" class="error"></p>
            <label>Gender</label>
            <select id="gender" name="gender">
                <option value="">Select your gender</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>
            <p id="genderError" class="error"></p>
            <label>Contact No.</label>
            <input id="contactNo" type="text" name="contactNo" placeholder="Enter your contact no."/>
            <p id="contactNoError" class="error"></p>
            <label>Email</label>
            <input id="email" type="email" name="email" placeholder="Enter your email"/>
            <p id="emailError" class="error"></p>
            <label>Password</label>
            <input id="password" type="password" name="password" placeholder="Enter password" />
            <p id="passwordError" class="error"></p>
            <label>What is your favourite colour?</label>
            <input id="firstAnswer" type="text" name="firstAnswer" placeholder="Green" />
            <p id="firstAnswerError" class="error"></p>
            <label>Which animal do you like?</label>
            <input id="secondAnswer" type="text" name="secondAnswer" placeholder="Dog"/>
            <p id="secondAnswerError" class="error"></p>
            <label>Which mobile company phone do you use?</label>
            <input id="thirdAnswer" type="text" name="thirdAnswer" placeholder="Mobile Company" />
            <p id="thirdAnswerError" class="error"></p>
            <button class="login-btn" type="submit">Register</button>
        </form>
    </div>
</body>

</html>