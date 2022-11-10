package stockex.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;

import stockex.persistence.dal.StockDAO;
import stockex.persistence.model.Stock;

public abstract class BaseStockExchange implements StockExchange {
  
  private final StockDAO stockDAO;
	private BigDecimal totalIncome;

  @Inject
	public BaseStockExchange(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

  @Override
	public Map<String, Integer> getOrderBookTotalVolume() {
		List<Stock> stocks = stockDAO.findAll(Stock.class);
		Map<String, Integer> orderBookTotalVolume = new HashMap<String, Integer>();
		for(Stock stock: stocks){
			orderBookTotalVolume.put(stock.getName(), stock.getQuantity());
		}
		return orderBookTotalVolume	;
	}

  
	public BigDecimal getTotalIncome() {
		return this.totalIncome;
	}	

  @Override
	public abstract BigDecimal getTradingCosts();

	@Override
	public void buy(String code, Integer units) throws InsufficientUnitsException, InvalidCodeException;

	@Override
	public void sell(String code, Integer units) throws InvalidCodeException;

}
