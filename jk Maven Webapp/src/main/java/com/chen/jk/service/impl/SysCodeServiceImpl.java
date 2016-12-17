package com.chen.jk.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.jk.dao.SysCodeDao;
import com.chen.jk.domain.SysCode;
import com.chen.jk.service.SysCodeService;

@Service
public class SysCodeServiceImpl implements SysCodeService{

	@Resource
	private SysCodeDao sysCodeDao;
	
	@Override
	public List<SysCode> find(Map paraMap) {
		return sysCodeDao.find(paraMap);
	}

}
