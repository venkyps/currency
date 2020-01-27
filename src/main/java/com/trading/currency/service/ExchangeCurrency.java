package com.trading.currency.service;

import com.trading.currency.constants.ErrorConstants;
import com.trading.currency.entity.Currency;
import com.trading.currency.vo.CurrencyVO;
import com.trading.currency.repo.CurrencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;


@Service
public class ExchangeCurrency implements TradingCurrency {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeCurrency.class);

    private static BigDecimal exchangeRateforOneDollar =new BigDecimal("1");

    @Autowired
    private ErrorConstants errorConstants;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public CurrencyVO getExchangeRate(String sourceCurrencyName,String destinationCurrencyName) throws Exception {
            logger.info("Get the exchange rate for sourceCurrencyName "+sourceCurrencyName+" destination currency "+destinationCurrencyName);

            CurrencyVO exchangeAmountCurrency = new CurrencyVO();
            Currency exchangeValue = getCurrencyData(sourceCurrencyName,destinationCurrencyName);

            exchangeAmountCurrency.setCurrencyValue(exchangeValue.getCurrencyValue());
            exchangeAmountCurrency.setSourceCurrencyName(exchangeValue.getSourceCurrencyName());
            exchangeAmountCurrency.setDestinationCurrencyName(exchangeValue.getDestinationCurrencyName());

            return exchangeAmountCurrency;
    }

    @Override
    public CurrencyVO getExchangedAmount(String sourceCurrencyName,String destinationCurrencyName,String amount)throws  Exception {
            logger.info("Get the exchange amount for sourceCurrencyName "+sourceCurrencyName+" destination currency "+destinationCurrencyName+" amount"+amount);
            CurrencyVO exchangeAmountCurrency = new CurrencyVO();
            Currency exchangeValue = getCurrencyData(sourceCurrencyName,destinationCurrencyName);

            BigDecimal currencyValue = new BigDecimal(exchangeValue.getCurrencyValue());

            BigDecimal exchangeRate = exchangeRateforOneDollar.divide(currencyValue,2, RoundingMode.HALF_DOWN);

            BigDecimal exchangeRateForDollar = new BigDecimal(amount);

            BigDecimal currencyAmount = exchangeRateForDollar.multiply(exchangeRate);

            exchangeAmountCurrency.setCurrencyValue(currencyAmount.toString());
            exchangeAmountCurrency.setSourceCurrencyName(exchangeValue.getSourceCurrencyName());
            exchangeAmountCurrency.setDestinationCurrencyName(exchangeValue.getDestinationCurrencyName());

            logger.info("exchange amount::"+exchangeAmountCurrency.getCurrencyValue());
            return exchangeAmountCurrency;

    }

    private Currency getCurrencyData(String sourceCurrencyName,String destinationCurrencyName) throws Exception{
        logger.info("Fetch all currencies from DB");
        List<Currency> currencyList= currencyRepository.findAll();

            Optional<Currency> matchingObject =currencyList.stream().filter(
                    value->value.getSourceCurrencyName().toUpperCase().equals(sourceCurrencyName.toUpperCase())
                    && value.getDestinationCurrencyName().toUpperCase().equals(destinationCurrencyName.toUpperCase())).findFirst();

            logger.info("Returned matched value");

            if(matchingObject.isPresent()){
                return matchingObject.get();
            }else{
                throw new Exception(errorConstants.currencyNotExistsInDB);
            }
    }

}
