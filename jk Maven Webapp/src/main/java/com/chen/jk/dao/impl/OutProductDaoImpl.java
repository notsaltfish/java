package com.chen.jk.dao.impl;

import org.springframework.stereotype.Repository;

import com.chen.jk.dao.OutProductDao;
import com.chen.jk.vo.OutProductVO;

@Repository
public class OutProductDaoImpl extends BaseDaoImpl<OutProductVO> implements OutProductDao{


	public OutProductDaoImpl(){
		super.setNs("com.chen.jk.mapper.OutProductMapper");
	}
	
}
