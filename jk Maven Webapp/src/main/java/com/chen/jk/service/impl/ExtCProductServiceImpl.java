package com.chen.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.jk.dao.ExtCProductDao;
import com.chen.jk.domain.ExtCProduct;
import com.chen.jk.pagination.Page;
import com.chen.jk.service.ExtCProductService;

@Service
public class ExtCProductServiceImpl implements ExtCProductService{

	@Resource
	private ExtCProductDao extCProductDao;
	
	
	public List<ExtCProduct> findPage(Page page) {
		return extCProductDao.findPage(page);
	}

	public List<ExtCProduct> find(Map paraMap) {
		
		return extCProductDao.find(paraMap);
	}

	public ExtCProduct get(Serializable id) {

		return extCProductDao.get(id);
	}

	@Override
	public void insert(ExtCProduct entity) {
		String uuid = UUID.randomUUID().toString();
		entity.setId(uuid);
		extCProductDao.insert(entity);
	}

	@Override
	public void update(ExtCProduct entity) {

		extCProductDao.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		extCProductDao.deleteById(id);
		
	}

	@Override
	public void delete(Serializable[] ids) {

		extCProductDao.delete(ids);
	}


}
