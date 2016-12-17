package com.chen.jk.dao;

import java.util.Map;

import com.chen.jk.domain.Contract;
import com.chen.jk.vo.ContractVO;

public interface ContractDao extends BaseDao<Contract>{
	
	public void updateState(Map map);
	public ContractVO view(String id);
}
