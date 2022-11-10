package stockex.service;

import java.math.BigDecimal;
import java.util.Map;

import stockex.exceptions.InsufficientUnitsException;
import stockex.exceptions.InvalidCodeException;

public interface StockExchange {

	/**
	* Buy stock
	*/
    void buy(String code, Integer units) throws InsufficientUnitsException,
        InvalidCodeException;
    /**
     * Sell stock
     */
    void sell(String code, Integer units) throws InvalidCodeException;
    /**
     * Report aggregate volume available for each code
     */
    Map<String, Integer> getOrderBookTotalVolume();
    /**
     * Returns dollar value of trading activity
     */
    BigDecimal getTradingCosts();
    
    
    BigDecimal getTotalIncome();
}
