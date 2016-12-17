package com.chen.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.chen.jk.domain.Contract;
import com.chen.jk.pagination.Page;
import com.chen.jk.vo.ContractVO;

public interface ContractService {
	public List<Contract> findPage(Page page);				//分页查询
	public List<Contract> find(Map paraMap);				//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public Contract get(Serializable id);					//只查询一个，常用于修改
	public void insert(Contract entity);					//插入，用实体作为参数
	public void update(Contract entity);					//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);			//批量删除；支持整数型和字符串类型ID
	public void submit(Serializable[] ids);
	public void cancel(Serializable[] ids);
	public ContractVO view(String id);
	
}
