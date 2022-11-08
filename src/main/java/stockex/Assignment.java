package stockex;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import stockex.exceptions.InsufficientUnitsException;
import stockex.exceptions.InvalidCodeException;
import stockex.service.StockExchange;
import stockex.service.factory.StockExchangeModule;

public class Assignment {
	
	private final StockExchange stockExchange;
	
	@Inject
	public Assignment(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector(new StockExchangeModule());
		Assignment assignment = injector.getInstance(Assignment.class); 
		
		//
		assignment.trade();
	}
	
	public void trade() {
		try {
			// TODO
			this.stockExchange.buy(null, null);
			// Implementation is hardcoded atm
			System.out.println("Trading costs: " + this.stockExchange.getTradingCosts());
		} catch(InsufficientUnitsException exception) {
			System.out.println(exception);
		} catch(InvalidCodeException exception) {
			System.out.println(exception);
		}
	}

}
