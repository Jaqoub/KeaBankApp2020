package com.example.keabankapp.Model;

public class TransActions {
    private String transActionsName;
    private String message;
    private Long FromReg;
    private Long fromAccountNumber;
    private Long ToReg;
    private Long toAccountNumber;
    private String date;
    private String transActionsAmount;
    private Double currentDeposit;

    public TransActions(){}

    public TransActions(String transActionsName, Long fromReg, Long fromAccountNumber, Long toReg, Long toAccountNumber, String date, String transActionsAmount){
        this.transActionsName = transActionsName;
        this.FromReg = fromReg;
        this.fromAccountNumber = fromAccountNumber;
        this.ToReg = toReg;
        this.toAccountNumber = toAccountNumber;
        this.date = date;
        this.transActionsAmount = transActionsAmount;
    }

    public TransActions(String transActionsName, String message,Long fromReg, Long toReg,Long fromAccountNumber, Long toAccountNumber, String date, String transActionsAmount){
        this.transActionsName = transActionsName;
        this.message = message;
        this.FromReg = fromReg;
        this.fromAccountNumber = fromAccountNumber;
        this.ToReg = toReg;
        this.toAccountNumber = toAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.date = date;
        this.transActionsAmount = transActionsAmount;

    }

    public TransActions(String transActionsName, String date, String transActionsAmount, Double currentDeposit){
        this.transActionsName = transActionsName;
        this.date = date;
        this.transActionsAmount = transActionsAmount;
        this.currentDeposit = currentDeposit;
    }

    public String getTransActionsName() {
        return transActionsName;
    }

    public void setTransActionsName(String transActionsName) {
        this.transActionsName = transActionsName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getFromReg() {
        return FromReg;
    }

    public void setFromReg(Long fromReg) {
        FromReg = fromReg;
    }

    public Long getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(Long fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public Long getToReg() {
        return ToReg;
    }

    public void setToReg(Long toReg) {
        ToReg = toReg;
    }

    public Long getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(Long toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransActionsAmount() {
        return transActionsAmount;
    }

    public void setTransActionsAmount(String transActionsAmount) {
        this.transActionsAmount = transActionsAmount;
    }

    public Double getCurrentDeposit() {
        return currentDeposit;
    }

    public void setCurrentDeposit(Double currentDeposit) {
        this.currentDeposit = currentDeposit;
    }
}
