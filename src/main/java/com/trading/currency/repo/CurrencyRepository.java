package com.trading.currency.repo;

import com.trading.currency.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CurrencyRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class CurrencyRowMapper implements RowMapper<Currency> {
        @Override
        public Currency mapRow(ResultSet rs, int rowNum) throws SQLException {
            Currency currency = new Currency();
            currency.setId(rs.getLong("id"));
            currency.setSourceCurrencyName(rs.getString("SOURCE_CURRENCY_NAME"));
            currency.setCurrencyValue(rs.getString("CURRENCY_VALUE"));
            currency.setDestinationCurrencyName(rs.getString("DESTINATION_CURRENCY_NAME"));
            return currency;
        }
    }

    public List< Currency > findAll() {
        return jdbcTemplate.query("select * from TBL_CURRENCY", new CurrencyRowMapper());
    }

}
