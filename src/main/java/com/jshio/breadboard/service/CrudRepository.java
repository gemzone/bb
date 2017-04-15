package com.jshio.breadboard.service;

public interface CrudRepository<T>
{
	// findByOOOO
	
	
	
	// 하나의 데이터
	public T findOne(long id);
	
	// 하나의 데이터 저장
	public long save(T entity);
	
	public long count();
	
	public long exists();
	
}
