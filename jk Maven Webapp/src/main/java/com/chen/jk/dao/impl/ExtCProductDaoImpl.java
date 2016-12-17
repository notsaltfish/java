package com.chen.jk.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.chen.jk.dao.ExtCProductDao;
import com.chen.jk.domain.ExtCProduct;

@Repository
public class ExtCProductDaoImpl extends BaseDaoImpl<ExtCProduct> implements ExtCProductDao{

	public ExtCProductDaoImpl(){
		super.setNs("com.chen.jk.mapper.ExtCProductMapper");
		
	}

	@Override
	public void deleteByContractProductId(Serializable[] ids) {
		this.getSqlSession().delete(super.getNs()+".deleteByContractProductId", ids);
		
	}

	@Override
	public void deleteByContractId(Serializable[] ids) {
		this.getSqlSession().delete(super.getNs()+".deleteByContractId",ids);		
	}
	
	
	
}
