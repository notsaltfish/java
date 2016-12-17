package com.chen.jk.dao.impl;

import org.springframework.stereotype.Repository;

import com.chen.jk.dao.ExtEPrdouctDao;
import com.chen.jk.domain.ExtEProduct;

@Repository
public class ExtEProductDaoImpl extends BaseDaoImpl<ExtEProduct> implements ExtEPrdouctDao{

	public ExtEProductDaoImpl(){
		super.setNs("com.chen.jk.mapper.ExtEProductMapper");
		
	}

	
	
}
