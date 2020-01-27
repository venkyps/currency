package com.trading.currency.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:error.properties")
public class ErrorConstants {

    @Value("${currencyName.blank}")
    public String currencyBlank;

    @Value("${currencyName.notExistsInDB}")
    public String currencyNotExistsInDB;
}
