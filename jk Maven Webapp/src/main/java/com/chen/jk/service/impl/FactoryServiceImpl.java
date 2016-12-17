package com.chen.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.jk.dao.FactoryDao;
import com.chen.jk.domain.Factory;
import com.chen.jk.pagination.Page;
import com.chen.jk.service.FactoryService;

@Service 
public class FactoryServiceImpl implements FactoryService {
	@Resource
	private FactoryDao factoryDao;
	
	public List<Factory> findPage(Page page) {
		return factoryDao.findPage(page);
	}

	public List<Factory> find(Map paraMap) {
		
		return factoryDao.find(paraMap);
	}

	public Factory get(Serializable id) {
		return factoryDao.get(id);
	}

	public void insert(Factory entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setState("1");//默认设置为启用
		factoryDao.insert(entity);
	}

	@Override
	public void update(Factory entity) {
		factoryDao.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		factoryDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		factoryDao.delete(ids);
	}

	@Override
	public void start(Serializable[] ids) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state",1);//启用
		map.put("ids",ids);
		factoryDao.updateState(map);
	}

	@Override
	public void stop(Serializable[] ids) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state",0);//停止使用
		map.put("ids",ids);
		factoryDao.updateState(map);
	}

	
}
