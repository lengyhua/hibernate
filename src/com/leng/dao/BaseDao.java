package com.leng.dao;

import java.util.List;


public interface BaseDao<T> {
	
	public void save(T t);
	public T get(int id);
	public void delete(int id);
	public List<T> query();
	public void update(T t);
	
}
