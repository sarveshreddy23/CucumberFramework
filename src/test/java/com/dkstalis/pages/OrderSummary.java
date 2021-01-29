package com.dkstalis.pages;

import org.openqa.selenium.By;

public class OrderSummary {
    public static By hdr_OrderSummary = By.xpath("//p[text()='Order Summary']");
    public static By btn_CONTINUE = By.xpath("//span[text()='Continue']/../..");
}
