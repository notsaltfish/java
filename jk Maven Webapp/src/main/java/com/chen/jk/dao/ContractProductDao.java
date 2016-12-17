package com.chen.jk.dao;

import java.io.Serializable;

import com.chen.jk.domain.ContractProduct;

public interface ContractProductDao extends BaseDao<ContractProduct> {
	public void deleteByContractId(Serializable[] ids);
}
