function validate() {
    var cardNo = document.getElementById("cardNo").value;
    var userId = document.getElementById("userId").value;
    var cardHolderName = document.getElementById("cardHolderName").value;
    var cardType = document.getElementById("cardType").value;
    var accountNo = document.getElementById("accountNo").value;
    var expiryDate = document.getElementById("expiryDate").value;
    var transactionDate = document.getElementById("transactionDate").value;
    var transactionDetails = document.getElementById("transactionDetails").value;
    var remarks = document.getElementById("remarks").value;
    var fraudLevel = document.getElementById("fraudLevel").value;
    var isValid = true;

    if (cardNo == null || cardNo.trim().length == 0) {
        document.getElementById("cardNoError").innerHTML = "Card no. is blank";
        isValid = false;
    }

    if (userId == null || userId.trim().length == 0) {
        document.getElementById("userIdError").innerHTML = "User id is blank";
        isValid = false;
    }
    if (cardHolderName == null || cardHolderName.trim().length == 0) {
        document.getElementById("cardHolderNameError").innerHTML = "Card holder name is blank";
        isValid = false;
    }
    if (cardType == null || cardType.trim().length == 0) {
        document.getElementById("cardTypeError").innerHTML = "Card type is blank";
        isValid = false;
    }
    if (accountNo == null || accountNo.trim().length == 0) {
        document.getElementById("accountNoError").innerHTML = "Account no. is blank";
        isValid = false;
    }
    if (expiryDate == null || expiryDate.trim().length == 0) {
        document.getElementById("expiryDateError").innerHTML = "Expiry date is blank";
        isValid = false;
    }
    if (transactionDate == null || transactionDate.trim().length == 0) {
        document.getElementById("transactionDateError").innerHTML = "Transaction date is blank";
        isValid = false;
    }
    if (transactionDetails == null || transactionDetails.trim().length == 0) {
        document.getElementById("transactionDetailsError").innerHTML = "Transaction details is blank";
        isValid = false;
    }
    if (remarks == null || remarks.trim().length == 0) {
        document.getElementById("remarksError").innerHTML = "Remarks is blank";
        isValid = false;
    }
    if (fraudLevel == null || fraudLevel.trim().length == 0) {
        document.getElementById("fraudLevelError").innerHTML = "Fraud level is blank";
        isValid = false;
    }

    return isValid;
    
}