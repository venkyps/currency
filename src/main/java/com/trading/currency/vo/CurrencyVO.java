package com.trading.currency.vo;

import java.math.BigDecimal;

public class CurrencyVO {

    private String sourceCurrencyName;
    private String currencyValue;
    private String destinationCurrencyName;

    public String getSourceCurrencyName() {
        return sourceCurrencyName;
    }

    public void setSourceCurrencyName(String sourceCurrencyName) {
        this.sourceCurrencyName = sourceCurrencyName;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(String currencyValue) {
        this.currencyValue = currencyValue;
    }

    public String getDestinationCurrencyName() {
        return destinationCurrencyName;
    }

    public void setDestinationCurrencyName(String destinationCurrencyName) {
        this.destinationCurrencyName = destinationCurrencyName;
    }

    @Override
    public String toString() {
        return "CurrencyVO{" +
                "sourceCurrencyName='" + sourceCurrencyName + '\'' +
                ", currencyValue='" + currencyValue + '\'' +
                ", destinationCurrencyName='" + destinationCurrencyName + '\'' +
                '}';
    }
}

