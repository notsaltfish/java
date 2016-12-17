package com.chen.jk.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chen.jk.dao.ContractDao;
import com.chen.jk.dao.FactoryDao;
import com.chen.jk.domain.Contract;
import com.chen.jk.domain.Factory;
import com.chen.jk.pagination.Page;
import com.chen.jk.vo.ContractVO;

@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao {


	public ContractDaoImpl(){
		super.setNs("com.chen.jk.mapper.ContractMapper");
		
	}

	@Override
	public void updateState(Map map) {

		super.getSqlSession().update(super.getNs()+".updateState", map);
	}

	@Override
	public ContractVO view(String id) {
		return super.getSqlSession().selectOne(super.getNs()+".view", id);
	} 
	
	
	
}
