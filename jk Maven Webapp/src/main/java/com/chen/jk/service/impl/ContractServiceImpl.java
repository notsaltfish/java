package com.chen.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.jk.dao.ContractDao;
import com.chen.jk.dao.ContractProductDao;
import com.chen.jk.dao.ExtCProductDao;
import com.chen.jk.domain.Contract;
import com.chen.jk.pagination.Page;
import com.chen.jk.service.ContractService;
import com.chen.jk.vo.ContractVO;

@Service
public class ContractServiceImpl implements ContractService{
	
	@Autowired
	private ContractDao contractDao;
	@Resource
	private ContractProductDao contractProductDao;
	@Resource
	private ExtCProductDao extCProductDao;
	
	
	@Override
	public List<Contract> findPage(Page page) {
		return contractDao.findPage(page);
	}

	@Override
	public List<Contract> find(Map paraMap) {
		return contractDao.find(paraMap);
	}

	@Override
	public Contract get(Serializable id) {
		return contractDao.get(id);
	}

	@Override
	public void insert(Contract entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setState(0);
		contractDao.insert(entity);
	}

	@Override
	public void update(Contract entity) {
		contractDao.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		extCProductDao.deleteByContractId(ids);//根据合同id删除附件
		contractProductDao.deleteByContractId(ids);//根据合同id删除货物
		contractDao.deleteById(id);
		
	}

	@Override
	public void delete(Serializable[] ids) {
		extCProductDao.deleteByContractId(ids);//根据合同id删除附件
		contractProductDao.deleteByContractId(ids);//根据合同id删除货物
		contractDao.delete(ids);
	}

	@Override
	public void submit(Serializable[] ids) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ids", ids);
		map.put("state", 1);
		contractDao.updateState(map);
	}

	@Override
	public void cancel(Serializable[] ids) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ids", ids);
		map.put("state", 0);
		contractDao.updateState(map);
	}

	@Override
	public ContractVO view(String id) {
		return contractDao.view(id);
	}

	
}
