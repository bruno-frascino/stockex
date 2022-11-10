package stockex.persistence.dal;

import java.io.Serializable;
import java.util.List;

public interface BasicDAO<T> {
	
	//C
	public T save(T entity);
	
	//R
	public T findById(Class<T> clazz, Serializable id);
	
	//R
	public List<T> findAll(Class<T> clazz);
	
	//U
	public T update(T entity);
	

}
