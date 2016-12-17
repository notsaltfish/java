package com.chen.jk.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.chen.jk.dao.ContractProductDao;
import com.chen.jk.domain.ContractProduct;

@Repository
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao{

	public ContractProductDaoImpl(){
		super.setNs("com.chen.jk.mapper.ContractProductMapper");
	}


	public void deleteByContractId(Serializable[] ids) {
		this.getSqlSession().delete(super.getNs()+".deleteByContractId", ids);
		
	}
}
