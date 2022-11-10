package stockex.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stock extends BaseEntity<Long>{

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int quantity;
	
	public Stock() {
	}
	
	@Override
	public Long getId() {
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
