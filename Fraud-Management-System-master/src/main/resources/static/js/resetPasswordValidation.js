function validate() {
    var password = document.getElementById("password").value;
    var confirmNewPassword = document.getElementById("confirmNewPassword").value;
    var isValid = true;

    if (password == null || password.trim().length == 0) {
        document.getElementById("passwordError").innerHTML = "Password is required";
        isValid = false;
    }

    if (confirmNewPassword == null || confirmNewPassword.trim().length == 0) {
        document.getElementById("confirmNewPasswordError").innerHTML = "Re-enter new password";
        isValid = false;
    }

    if (confirmNewPassword != null && password != null) {
        if (confirmNewPassword !== password) {
            document.getElementById("confirmNewPasswordError").innerHTML = "Password does not match";
        }
    }

    return isValid;
}