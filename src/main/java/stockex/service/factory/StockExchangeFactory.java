package stockex.service.factory;

import stockex.service.ASXStockExchangeImpl;
import stockex.service.CXAStockExchangeImpl;
import stockex.service.StockExchange;

public class StockExchangeFactory {
	
	public StockExchange getStockExchangeImplementation(String exchangeName){
	
		// not ideal but I got no much time left
		if(exchangeName.equals("asx")) {
			return new ASXStockExchangeImpl();
		}
		
		return new CXAStockExchangeImpl();
	}
}
