package com.cognizant.fraudmanagementsystem.model;

import java.util.Date;

public class Transaction {

    private int id;
    private long cardNo;
    private String userId;
    private String cardHolderName;
    private String cardType;
    private long accountNo;
    private Date expiryDate;
    private Date transactionDate;
    private String transactionDetails;
    private String remarks;
    private String fraudLevel;

    public Transaction() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCardNo() {
        return cardNo;
    }

    public void setCardNo(long cardNo) {
        this.cardNo = cardNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }
    
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(String transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFraudLevel() {
        return fraudLevel;
    }

    public void setFraudLevel(String fraudLevel) {
        this.fraudLevel = fraudLevel;
    }


    @Override
    public String toString() {
        return "Transaction [cardNo=" + cardNo + ", cardHolderName=" + cardHolderName
                + ", accountNo = " + accountNo + ", expiryDate=" + expiryDate + ", cardType=" + cardType
                + ", transactionDate=" + transactionDate + ", transactionDetails=" + transactionDetails + ", remarks=" + remarks
                + ", fraudLevel=" + fraudLevel + "]";
    }
}
