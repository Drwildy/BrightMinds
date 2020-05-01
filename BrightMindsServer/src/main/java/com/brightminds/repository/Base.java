package com.brightminds.repository;

import java.util.List;

public interface Base<T>{
	
	void insert(T a);
	
	void update(T a);
	
	void delete(int a);
	
	List<T> getAll();
	
	T getById(int id); 
	
	T getByName(String name); 
}
