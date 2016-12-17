package com.chen.jk.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.chen.jk.dao.ExportDao;
import com.chen.jk.domain.Export;
import com.chen.jk.pagination.Page;

@Repository
public class ExportDaoImpl extends BaseDaoImpl<Export> implements ExportDao{

	
	public ExportDaoImpl(){
		super.setNs("com.chen.jk.mapper.ExportMapper");
		
	}
	
	
	public void upateState(Map map) {
		super.getSqlSession().update(this.getNs()+".updateState",map);
	}




	@Override
	public List<Export> findPage(Page page) {
		// TODO Auto-generated method stub
		return super.findPage(page);
	}

	@Override
	public List<Export> find(Map map) {
		// TODO Auto-generated method stub
		return super.find(map);
	}

	@Override
	public Export get(Serializable id) {
		return super.get(id);
	}

	@Override
	public void insert(Export entity) {
		super.insert(entity);
	}

	@Override
	public void update(Export entity) {
		super.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		super.delete(ids);
	}

	
}
