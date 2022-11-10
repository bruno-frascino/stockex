package stockex;

import java.util.Map;
import java.util.Random;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import stockex.exceptions.InsufficientUnitsException;
import stockex.exceptions.InvalidCodeException;
import stockex.service.StockExchange;
import stockex.service.factory.StockExchangeFactory;
import stockex.service.factory.StockExchangeModule;

public class Assignment {
	
	private final StockExchangeFactory stockExchangeFactory;
	private static final String STOCK_NAB = "NAB";
	private static final String STOCK_CBA = "CBA";
	private static final String STOCK_QAN = "QAN";
	
		
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
			// no binder, returning via new
			StockExchange stockExchange = stockExchangeFactory.getStockExchangeImplementation(exchangeName);
			// 
			Random random = new Random();
			int randomNumberOfIterations = random.nextInt(30); // arbitrary cap number
			// random buy and sell
			for (int i = 0; i < randomNumberOfIterations; i++) {				

				stockExchange.buy(STOCK_CBA, random.nextInt(200));
				stockExchange.buy(STOCK_QAN, random.nextInt(200));
				stockExchange.buy(STOCK_NAB, random.nextInt(200));
				
				stockExchange.buy(STOCK_CBA, random.nextInt(100));
				stockExchange.buy(STOCK_QAN, random.nextInt(100));
				stockExchange.buy(STOCK_NAB, random.nextInt(100));
			}
						
			//remaining volume of stocks
			Map<String, Integer> orderBookMap = stockExchange.getOrderBookTotalVolume();
			for (String stockCode : orderBookMap.keySet()) {
				System.out.println("Stock units remaining for " + stockCode + ": " + orderBookMap.get(stockCode));
			}
			
			// total income of the exchange
			System.out.println("Total income for exchange: " + exchangeName + ": " + stockExchange.getTotalIncome());

		} catch(InsufficientUnitsException exception) {
			System.out.println(exception); 
		} catch(InvalidCodeException exception) {
			System.out.println(exception);
		}
	}

}
