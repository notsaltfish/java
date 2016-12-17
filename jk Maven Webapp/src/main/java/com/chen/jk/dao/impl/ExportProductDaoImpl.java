package com.chen.jk.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.chen.jk.dao.ExportPrdouctDao;
import com.chen.jk.domain.ExportProduct;

@Repository
public class ExportProductDaoImpl extends BaseDaoImpl<ExportProduct> implements ExportPrdouctDao{

	public ExportProductDaoImpl(){
		super.setNs("com.chen.jk.mapper.ExportProductMapper");
		
	}

	
	
}
