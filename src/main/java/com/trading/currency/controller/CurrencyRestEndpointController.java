package com.trading.currency.controller;

import com.trading.currency.constants.ErrorConstants;
import com.trading.currency.vo.CurrencyVO;
import com.trading.currency.service.ExchangeCurrency;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/currency")
public class CurrencyRestEndpointController {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyRestEndpointController.class);

    @Autowired
    private ExchangeCurrency exchangeCurrency;

    @Autowired
    private ErrorConstants errorConstants;

    @GetMapping(path="/getExchangeRate")
    @ResponseBody
    public CurrencyVO getExchangeRate(@RequestParam (value = "sourceCurrencyName") String sourceCurrencyName,@RequestParam (value = "destinationCurrencyName")String destinationCurrencyName) throws Exception{
        if(!StringUtils.isBlank(sourceCurrencyName) && !StringUtils.isBlank(destinationCurrencyName)){
              logger.info("Get the exchange rate for sourceCurrencyName "+sourceCurrencyName+" destination currency "+destinationCurrencyName);
             return exchangeCurrency.getExchangeRate(sourceCurrencyName,destinationCurrencyName);
        }else{
            throw new Exception(errorConstants.currencyBlank);
        }
    }

    @GetMapping(path="/getExchangeAmount")
    @ResponseBody
    public CurrencyVO getExchangeRateAmount(@RequestParam (value = "sourceCurrencyName") String sourceCurrencyName,
                                            @RequestParam (value = "destinationCurrencyName")String destinationCurrencyName,
                                            @RequestParam (value = "amount")String amount)throws Exception{
        if(!StringUtils.isBlank(sourceCurrencyName) && !StringUtils.isBlank(destinationCurrencyName)){
            logger.info("Get the exchange amount for sourceCurrencyName "+sourceCurrencyName+" destination currency "+destinationCurrencyName);
            return exchangeCurrency.getExchangedAmount(sourceCurrencyName,destinationCurrencyName,amount);
        }else{
            throw new Exception(errorConstants.currencyBlank);
        }
    }

}
