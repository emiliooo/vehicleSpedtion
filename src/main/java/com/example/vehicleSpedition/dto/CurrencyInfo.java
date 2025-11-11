package com.example.vehicleSpedition.dto;


public class CurrencyInfo {
    private String code;
    private String date;
    private double rate;

    public CurrencyInfo(String code, String date, double rate) {
        this.code = code;
        this.date = date;
        this.rate = rate;
    }


    public String getCode() { return code; }
    public String getDate() { return date; }
    public double getRate() { return rate; }
}

