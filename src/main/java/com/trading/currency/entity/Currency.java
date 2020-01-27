package com.trading.currency.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Currency {


    private Long id;
    private String sourceCurrencyName;
    private String currencyValue;
    private String destinationCurrencyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
