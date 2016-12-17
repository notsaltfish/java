package com.chen.jk.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.jk.dao.OutProductDao;
import com.chen.jk.service.OutProductService;
import com.chen.jk.vo.OutProductVO;

@Service
public class OutProductServiceImpl implements OutProductService{

	@Resource
	private OutProductDao outProductDao;
	
	
	public List<OutProductVO> find(String outPutTime) {
		Map<String,String> paraMap=new HashMap<String,String>();
		paraMap.put("outPutTime", outPutTime);
		
		return outProductDao.find(paraMap);
	}

}
