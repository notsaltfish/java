package com.chen.jk.dao;

import java.util.Map;

import com.chen.jk.domain.Export;

public interface ExportDao extends BaseDao<Export> {
   public void  upateState(Map map);
}
