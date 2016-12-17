package com.chen.jk.dao.impl;

import org.springframework.stereotype.Repository;

import com.chen.jk.dao.SysCodeDao;
import com.chen.jk.domain.SysCode;

@Repository
public class SysCodeDaoImpl extends BaseDaoImpl<SysCode> implements SysCodeDao{

	public SysCodeDaoImpl(){
		super.setNs("com.chen.jk.mapper.SysCodeMapper");
	}
}
