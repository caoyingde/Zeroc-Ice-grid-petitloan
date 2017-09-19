package com.huilian.petitcredit.base.pushmsg.dao;

import java.util.List;
import java.util.Map;
public interface BaseDao<T> {

	public int getCountByCondition(Map<String, Object> conditionMap);

	public List<T> findByCondition(Map<String, Object> conditionMap);
	
	public T findByNum(String gameNum);
	
	public int update(T obj);
	
	public int insert(T obj);
	
	public int insertBatch(List<T> list);
	
	public int updateBatch(List<T> list);
}
