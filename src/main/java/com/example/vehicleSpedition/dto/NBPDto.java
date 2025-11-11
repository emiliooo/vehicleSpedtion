package com.example.vehicleSpedition.dto;

import java.util.List;

public class NBPDto {

    private String Code;
    private List<NBPRate> Rates;


    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public List<NBPRate> getRates() {
        return Rates;
    }

    public void setRates(List<NBPRate> rates) {
        Rates = rates;
    }
}
