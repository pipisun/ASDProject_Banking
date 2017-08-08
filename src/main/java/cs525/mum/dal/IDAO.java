package main.java.cs525.mum.dal;

import java.util.List;

public interface IDAO<T> {
	
	boolean add(T t);
	
	public T find(String accountNumber);
	
	public List<T> getAll();
	
}
