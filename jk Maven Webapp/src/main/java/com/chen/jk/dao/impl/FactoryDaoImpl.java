package com.chen.jk.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chen.jk.dao.FactoryDao;
import com.chen.jk.domain.Factory;
import com.chen.jk.pagination.Page;

@Repository
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao {


	public FactoryDaoImpl(){
		super.setNs("com.chen.jk.mapper.FactoryMapper");
		
	}

	@Override
	public void updateState(Map map) {

		super.getSqlSession().update(super.getNs()+".updateState", map);
	} 
	
	
	
}
