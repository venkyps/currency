DROP TABLE IF EXISTS TBL_CURRENCY;

CREATE TABLE TBL_CURRENCY (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  SOURCE_CURRENCY_NAME VARCHAR(250) NOT NULL,
  CURRENCY_VALUE VARCHAR(250) NOT NULL,
  DESTINATION_CURRENCY_NAME VARCHAR(250) NOT NULL
);

