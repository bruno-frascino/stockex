package stockex.service;

import java.math.BigDecimal;
import java.util.Map;

import stockex.exceptions.InsufficientUnitsException;
import stockex.exceptions.InvalidCodeException;
import stockex.persistence.dal.StockDAO;

public class CXAStockExchangeImpl extends BaseStockExchange{

	private final StockDAO stockDAO;
	private BigDecimal totalIncome;
	
	@Override
	public void buy(String code, Integer units) throws InsufficientUnitsException, InvalidCodeException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sell(String code, Integer units) throws InvalidCodeException {
		// TODO Auto-generated method stub

	}

	@Override
	public BigDecimal getTradingCosts() {
		// TODO Auto-generated method stub
		return BigDecimal.valueOf(0.05d);
	}

}
