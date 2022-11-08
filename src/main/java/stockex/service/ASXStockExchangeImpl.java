package stockex.service;

import java.math.BigDecimal;
import java.util.Map;

import stockex.exceptions.InsufficientUnitsException;
import stockex.exceptions.InvalidCodeException;

public class ASXStockExchangeImpl implements StockExchange {

	
	@Override
	public Map<String, Integer> getOrderBookTotalVolume() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getTradingCosts() {
		// TODO get it from DB
		return BigDecimal.valueOf(0.07d);
	}

	@Override
	public void buy(String code, Integer units) throws InsufficientUnitsException, InvalidCodeException {
		
	}

	@Override
	public void sell(String code, Integer units) throws InvalidCodeException {
		// TODO Auto-generated method stub
		
	}

}
