package stockex.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;

import stockex.exceptions.InsufficientUnitsException;
import stockex.exceptions.InvalidCodeException;
import stockex.persistence.dal.StockDAO;
import stockex.persistence.model.Stock;

public class ASXStockExchangeImpl extends BaseStockExchange {
		
	@Override
	public BigDecimal getTradingCosts() {
		// TODO get it from DB
		return BigDecimal.valueOf(0.07d);
	}

	@Override
	public void buy(String code, Integer units) throws InsufficientUnitsException, InvalidCodeException {
		Map<String, Integer> orderBookTotalVolume = getOrderBookTotalVolume();
		Integer availableUnits = orderBookTotalVolume.get(code);
		if (availableUnits == null) {
			throw new InvalidCodeException();
		}
		
		if (units > availableUnits ) {
			throw new InsufficientUnitsException();
		}
		
		// Record in transaction table
		// update balance (income)
		
	}

	@Override
	public void sell(String code, Integer units) throws InvalidCodeException {
		Map<String, Integer> orderBookTotalVolume = getOrderBookTotalVolume();
		Integer availableUnits = orderBookTotalVolume.get(code);
		if (availableUnits == null) {
			throw new InvalidCodeException();
		}
				
		// Record in transaction table
		// update balance (income)
		
	}

}
