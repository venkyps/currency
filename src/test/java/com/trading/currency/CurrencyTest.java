package com.trading.currency;

import com.trading.currency.entity.Currency;
import com.trading.currency.repo.CurrencyRepository;
import com.trading.currency.service.ExchangeCurrency;
import com.trading.currency.vo.CurrencyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyTest {

    @Mock
    CurrencyRepository currencyRepository;

    @InjectMocks
    ExchangeCurrency exchangeCurrency;

    @Test
    public void testGetExchangeRate() throws Exception{
        when(currencyRepository.findAll()).thenReturn(getCurrencyData());
        assertEquals("0.74",exchangeCurrency.getExchangeRate("SGD","US").getCurrencyValue());
    }

    @Test
    public void testGetExchangeAmount() throws Exception{
        when(currencyRepository.findAll()).thenReturn(getCurrencyData());
        assertEquals("135.00",exchangeCurrency.getExchangedAmount("SGD","US","100").getCurrencyValue());
    }

    private List<Currency> getCurrencyData(){
        List<Currency> currencyList = new ArrayList<>();
        Currency currency = new Currency();
        currency.setDestinationCurrencyName("US");
        currency.setSourceCurrencyName("SGD");
        currency.setCurrencyValue("0.74");
        currencyList.add(currency);
        return currencyList;
    }
}
