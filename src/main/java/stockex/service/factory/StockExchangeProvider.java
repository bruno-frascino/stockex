package stockex.service.factory;

import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Provider;

import stockex.service.StockExchange;

public class StockExchangeProvider implements Provider<StockExchange>{

	private final Map<String, StockExchange> mapBinder;
	
	@Inject
	public StockExchangeProvider(Map<String, StockExchange> mapBinder) {
		this.mapBinder = mapBinder;
	}
	
	@Override
	public StockExchange get() {
		return mapBinder.get("ASX");
	}

	
}
