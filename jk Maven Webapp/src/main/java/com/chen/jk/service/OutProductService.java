package com.chen.jk.service;

import java.util.List;

import com.chen.jk.vo.OutProductVO;

public interface OutProductService {

	public List<OutProductVO> find(String outPutTime);
}
