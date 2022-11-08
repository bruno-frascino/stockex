package stockex.service;

import java.math.BigDecimal;
import java.util.Map;

import stockex.exceptions.InsufficientUnitsException;
import stockex.exceptions.InvalidCodeException;

public class CXAStockExchangeImpl implements StockExchange {

	@Override
	public void buy(String code, Integer units) throws InsufficientUnitsException, InvalidCodeException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sell(String code, Integer units) throws InvalidCodeException {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, Integer> getOrderBookTotalVolume() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getTradingCosts() {
		// TODO Auto-generated method stub
		return BigDecimal.valueOf(0.05d);
	}

}
