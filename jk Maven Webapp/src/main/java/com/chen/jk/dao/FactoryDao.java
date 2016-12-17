package com.chen.jk.dao;

import java.util.Map;

import com.chen.jk.domain.Factory;

public interface FactoryDao extends BaseDao<Factory>{
	
	public void updateState(Map map);
	
}
