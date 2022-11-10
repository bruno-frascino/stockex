package stockex.service.factory;

import stockex.persistence.dal.StockDAOImp;
import stockex.service.ASXStockExchangeImpl;
import stockex.service.CXAStockExchangeImpl;
import stockex.service.StockExchange;

public class StockExchangeFactory {
	
//	private MapBinder<String, StockExchange> exchangeImplBinder; 
	
//	@Inject
//	public StockExchangeFactory(MapBinder<String, StockExchange> mapBinder) {
//		this.exchangeImplBinder = mapBinder;
//	}
	
	public StockExchange getStockExchangeImplementation(String exchangeName){
	
		// 
		if(exchangeName.toUpperCase().equals("ASX")) {
			// TODO fix mapBinder
			return new ASXStockExchangeImpl(new StockDAOImp());
		}
		
		return new CXAStockExchangeImpl();
	}
}
