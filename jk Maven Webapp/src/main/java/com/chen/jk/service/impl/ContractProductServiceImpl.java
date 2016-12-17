package com.chen.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.jk.dao.ContractProductDao;
import com.chen.jk.dao.ExtCProductDao;
import com.chen.jk.domain.ContractProduct;
import com.chen.jk.pagination.Page;
import com.chen.jk.service.ContractProductService;
import com.chen.jk.util.UtilFuns;

@Service
public class ContractProductServiceImpl implements ContractProductService{
	
	@Resource
	private ContractProductDao contractProductDao;
	@Resource
	private ExtCProductDao extCProductDao;
	
	public List<ContractProduct> findPage(Page page) {
		return contractProductDao.findPage(page);
	}

	public List<ContractProduct> find(Map paraMap) {
		return contractProductDao.find(paraMap);
	}

	public ContractProduct get(Serializable id) {
		return contractProductDao.get(id);
	}

	public void insert(ContractProduct entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setAmount(entity.getPrice()*entity.getcNumber());
		contractProductDao.insert(entity);
	}

	public void update(ContractProduct entity) {
		if(UtilFuns.isNotEmpty(entity.getPrice())&&UtilFuns.isNotEmpty(entity.getcNumber()))
		entity.setAmount(entity.getPrice()*entity.getcNumber());
		
		contractProductDao.update(entity);
	}

	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		extCProductDao.deleteByContractProductId(ids);//级联删除货物对应的附件
		contractProductDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		extCProductDao.deleteByContractProductId(ids);//级联删除货物对应的附件
		contractProductDao.delete(ids);
	}

}
