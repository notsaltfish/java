package com.chen.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.chen.jk.domain.Contract;
import com.chen.jk.domain.Export;
import com.chen.jk.pagination.Page;

public interface ExportService {
	public List<Export> findPage(Page page);				//分页查询
	public List<Export> find(Map paraMap);				//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public Export get(Serializable id);					//只查询一个，常用于修改
	public void insert(Export entity);					//插入，用实体作为参数
	public void update(Export entity, String[] mr_id, String[] mr_productNo,
									Integer[] mr_cnumber, Double[] mr_grossWeight, 
									Double[] mr_metWeight, Double[] mr_sizeLength,
									Double[] mr_sizeWidth, Double[] mr_sizeHeight,
									Double[] mr_exPrice, Double[] mr_tax, Integer[] mr_orderNo, 
									Integer[] mr_changed);					
	//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);			//批量删除；支持整数型和字符串类型ID
	public void submit(Serializable[] ids);
	public void cancel(Serializable[] ids);
	public void insert(String[] ids);
	public List<Contract> getContractList();
	public String getProductInfo(String id);
	
}
