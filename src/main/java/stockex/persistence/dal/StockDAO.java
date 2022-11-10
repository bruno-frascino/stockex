package stockex.persistence.dal;

import stockex.persistence.model.Stock;

public interface StockDAO extends BasicDAO<Stock>{

	public Stock findByCode(String code);
}
