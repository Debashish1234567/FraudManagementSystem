function validate() {
   
    var id = document.getElementById("userId").value;
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var dob = document.getElementById("dob").value;
    var gender = document.getElementById("gender").value;
    var contactNo = document.getElementById("contactNo").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var firstAnswer = document.getElementById("firstAnswer").value;
    var secondAnswer = document.getElementById("secondAnswer").value;
    var thirdAnswer = document.getElementById("thirdAnswer").value;
    var isValid = true;
   
    if (id == null || id.trim().length == 0) {
        console.log(id);
        document.getElementById("userIdError").innerHTML = "User Id is blank";
        isValid = false;
    }
    if (firstName == null || firstName.trim().length == 0) {
        console.log(firstName);
        document.getElementById("firstNameError").innerHTML = "First Name is blank";
        isValid = false;
    }
    if (lastName == null || lastName.trim().length == 0) {
        document.getElementById("lastNameError").innerHTML = "Last Name is blank";
        isValid = false;
    }
    if (dob == null || dob.trim().length == 0) {
        document.getElementById("dobError").innerHTML = "Date of birth is blank";
        isValid = false;}
    if (gender == null || gender.trim().length == 0) {
        document.getElementById("genderError").innerHTML = "Select your gender";
        isValid = false;
    }
    if (contactNo == null || contactNo.trim().length == 0) {
        document.getElementById("contactNoError").innerHTML = "Contact No. is blank";
        isValid = false;
    }
    if (email == null || email.trim().length == 0) {
        document.getElementById("emailError").innerHTML = "Email is blank";
        isValid = false;
    }
    if (password == null || password.trim().length == 0) {
        document.getElementById("passwordError").innerHTML = "Password is blank";
        isValid = false;
    }
    if (firstAnswer == null || firstAnswer.trim().length == 0) {
        document.getElementById("firstAnswerError").innerHTML = "Required";
        isValid = false;
    }
    if (secondAnswer == null || secondAnswer.trim().length == 0) {
        document.getElementById("secondAnswerError").innerHTML = "Required";
        isValid = false;
    }
    if (thirdAnswer == null || thirdAnswer.trim().length == 0) {
        document.getElementById("thirdAnswerError").innerHTML = "Required";
        isValid = false;
    }

    return isValid; 
}