package com.trading.currency.service;

import com.trading.currency.vo.CurrencyVO;

public interface TradingCurrency {

    CurrencyVO getExchangeRate(String sourceCurrencyName,String destinationCurrencyName) throws Exception;
    CurrencyVO getExchangedAmount(String sourceCurrencyName,String destinationCurrencyName,String amount) throws Exception;
}
