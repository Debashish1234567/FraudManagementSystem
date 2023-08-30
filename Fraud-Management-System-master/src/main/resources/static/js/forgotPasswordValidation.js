function validate() {
    var userId = document.getElementById("userId").value;
    var firstAnswer = document.getElementById("firstAnswer").value;
    var secondAnswer = document.getElementById("secondAnswer").value;
    var thirdAnswer = document.getElementById("thirdAnswer").value;
    var isValid = true;
    if (userId == null || userId.trim().length == 0) {
        document.getElementById("userIdError").innerHTML = "User id is blank";
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