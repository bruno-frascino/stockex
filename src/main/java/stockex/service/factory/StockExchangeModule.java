package stockex.service.factory;

import com.google.inject.multibindings.MapBinder;

import stockex.service.ASXStockExchangeImpl;
import stockex.service.CXAStockExchangeImpl;
import stockex.service.StockExchange;

public class StockExchangeModule extends com.google.inject.AbstractModule {

	@Override
	protected void configure() {
		
		MapBinder<String, StockExchange> mapBinder = MapBinder.newMapBinder(binder(), String.class, StockExchange.class);
		mapBinder.addBinding("ASX").to(ASXStockExchangeImpl.class);
		mapBinder.addBinding("CXA").to(CXAStockExchangeImpl.class);
		
		bind(StockExchange.class).toProvider(StockExchangeProvider.class);
	}
	
	
}
