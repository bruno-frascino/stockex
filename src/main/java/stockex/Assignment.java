package stockex;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import stockex.exceptions.InsufficientUnitsException;
import stockex.exceptions.InvalidCodeException;
import stockex.service.StockExchange;
import stockex.service.factory.StockExchangeFactory;
import stockex.service.factory.StockExchangeModule;

public class Assignment {
	
//	private final StockExchange stockExchange;
	private final StockExchangeFactory stockExchangeFactory;
	
//	@Inject
//	public Assignment(StockExchange stockExchange) {
//		this.stockExchange = stockExchange;
//	}
	
	@Inject
	public Assignment(StockExchangeFactory stockExchangeFactory) {
		this.stockExchangeFactory = stockExchangeFactory;
	}


	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector(new StockExchangeModule());
		Assignment assignment = injector.getInstance(Assignment.class); 
		
		// todo validation of the input
		String exchangeName = args[1];
		
		//
		assignment.trade(exchangeName);
	}
	
	public void trade(String exchangeName) {
		try {
			// Implementation is hardcoded atm
			StockExchange stockExchange = stockExchangeFactory.getStockExchangeImplementation(exchangeName);
			stockExchange.buy(null, null);
			System.out.println("Trading costs: " + stockExchange.getTradingCosts());
		} catch(InsufficientUnitsException exception) {
			System.out.println(exception);
		} catch(InvalidCodeException exception) {
			System.out.println(exception);
		}
	}

}
