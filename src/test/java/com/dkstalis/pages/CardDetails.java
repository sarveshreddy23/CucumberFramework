package com.dkstalis.pages;

import org.openqa.selenium.By;

public class CardDetails {
    public static By hdr_Credit_DebitCard = By.xpath("//p[text()='Credit/Debit Card']");
    public static By txt_CardNumber = By.xpath("//input[@name='cardnumber']");
    public static By txt_ExpiryDate = By.xpath("//input[@placeholder='MM / YY']");
    public static By txt_CVV = By.xpath("//input[@placeholder='123']");
    public static By btn_PAYNOW = By.xpath("//span[text()='Pay Now']/../..");
    public static By txt_BankOtp = By.xpath("//input[@placeholder='112233']");
    public static By btn_OK = By.xpath("//button[@name='ok']");
    public static By lbl_TransactionFailed = By.xpath("//span[text()='Transaction failed']");

}
