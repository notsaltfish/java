package com.chen.jk.dao;

import java.io.Serializable;

import com.chen.jk.domain.ExtCProduct;

public interface ExtCProductDao extends BaseDao<ExtCProduct>{

	public void deleteByContractProductId(Serializable[] ids);
	
	public void deleteByContractId(Serializable[] ids);
}
