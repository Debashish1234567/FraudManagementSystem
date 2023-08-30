function validate() {
   
    var id = document.getElementById("userId").value;
    var password = document.getElementById("password").value;
    var isValid = true;
   
    if (id == null || id.trim().length == 0) {
        document.getElementById("userIdError").innerHTML = "User Id is blank";
        isValid = false;
    }
    if (password == null || password.trim().length == 0) {
        document.getElementById("passwordError").innerHTML = "Password is blank";
        isValid = false;
    }

    return isValid; 
}