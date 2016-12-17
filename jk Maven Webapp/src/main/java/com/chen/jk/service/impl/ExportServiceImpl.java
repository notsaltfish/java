package com.chen.jk.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.chen.jk.dao.ContractDao;
import com.chen.jk.dao.ExportDao;
import com.chen.jk.dao.ExportPrdouctDao;
import com.chen.jk.dao.ExtEPrdouctDao;
import com.chen.jk.domain.Contract;
import com.chen.jk.domain.Export;
import com.chen.jk.domain.ExportProduct;
import com.chen.jk.domain.ExtEProduct;
import com.chen.jk.pagination.Page;
import com.chen.jk.service.ExportService;
import com.chen.jk.util.UtilFuns;
import com.chen.jk.vo.ContractProductVO;
import com.chen.jk.vo.ContractVO;
import com.chen.jk.vo.ExtCProductVO;

@Service
public class ExportServiceImpl implements ExportService {

	@Resource
	private ExportDao exportDao;
	@Resource
	private ContractDao contractDao;
	@Resource
	private ExportPrdouctDao exportProductDao;
	@Resource
	private ExtEPrdouctDao extEProductDao;

	@Override
	public List<Export> findPage(Page page) {
		return exportDao.findPage(page);
	}

	@Override
	public List<Export> find(Map paraMap) {
		return exportDao.find(paraMap);
	}

	@Override
	public Export get(Serializable id) {
		// TODO Auto-generated method stub
		return exportDao.get(id);
	}

	@Override
	public void insert(Export entity) {

		exportDao.insert(entity);
	}

	@Override
	public void deleteById(Serializable id) {

		exportDao.deleteById(id);

	}

	@Override
	public void delete(Serializable[] ids) {

		exportDao.delete(ids);
	}

	@Override
	public void submit(Serializable[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		map.put("state", 1);
		exportDao.upateState(map);

	}

	@Override
	public void cancel(Serializable[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		map.put("state", 0);
		exportDao.upateState(map);

	}

	@Override
	public void insert(String[] ids) {
		String contractNos = "";
		Export export = new Export();
		export.setId(UUID.randomUUID().toString());
		List<ContractVO> vos = new ArrayList<ContractVO>();
		ContractVO cvo = null;
		for (String id : ids) {
			cvo = contractDao.view(id);
			vos.add(cvo);
			contractNos += cvo.getContractNo() + " "; // 注意这里的no和id不是同一个字段
		}
		export.setCustomerContract(UtilFuns.delLastChar(contractNos));
		export.setContractIDS(UtilFuns.joinStr(ids, ","));
		export.setState(0);
		exportDao.insert(export);

		List<ContractProductVO> pvos = null;
		List<ExtCProductVO> evos = null;
		ExportProduct ep = null;
		ExtEProduct eep = null;
		for (ContractVO vo : vos) {// 将每个合同从合同列表中拿出来
			pvos = vo.getContractProducts();
			for (ContractProductVO pvo : pvos) {// 将每个货物从合同中拿出来
				evos = pvo.getExtCProducts();
				ep = new ExportProduct();
				BeanUtils.copyProperties(pvo, ep);
				ep.setExportId(export.getId());
				ep.setId(UUID.randomUUID().toString());
				exportProductDao.insert(ep);
				for (ExtCProductVO evo : evos) {// 将每个货物的附件拿出来
					eep = new ExtEProduct();
					BeanUtils.copyProperties(pvo, ep);// spring的工具类可以将两个对象名字一样的属性复制
					eep.setExportProductId(ep.getId());
					eep.setId(UUID.randomUUID().toString());
					extEProductDao.insert(eep);
				}

			}

		}

	}

	@Override
	public List<Contract> getContractList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		return contractDao.find(map);
	}

	// addTRRecord(objId, id, productNo, cnumber, grossWeight, netWeight,
	// sizeLength, sizeWidth, sizeHeight, exPrice, tax) {

	public String getProductInfo(String id) {
		HashMap<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("exportId", id);
		List<ExportProduct> eps = exportProductDao.find(paraMap);
		StringBuffer info = new StringBuffer();
		for (ExportProduct ep : eps) {
			info.append("addTRRecord(\"mRecordTable\",").append("\"").append(UtilFuns.convertNull(ep.getId()))
					.append("\",").append("\"").append(UtilFuns.convertNull(ep.getProductNo())).append("\",")
					.append("\"").append(UtilFuns.convertNull(ep.getcNumber())).append("\",").append("\"")
					.append(UtilFuns.convertNull(ep.getGrossWeight())).append("\",").append("\"")
					.append(UtilFuns.convertNull(ep.getNetWeight())).append("\",").append("\"")
					.append(UtilFuns.convertNull(ep.getSizeLength())).append("\",").append("\"")
					.append(UtilFuns.convertNull(ep.getSizeWidth())).append("\",").append("\"")
					.append(UtilFuns.convertNull(ep.getSizeHeight())).append("\",").append("\"")
					.append(UtilFuns.convertNull(ep.getExPrice())).append("\",").append("\"")
					.append(UtilFuns.convertNull(ep.getTax())).append("\");")
			;
		}
		return info.toString();
	}

	@Override
	public void update(Export entity, String[] mr_id, String[] mr_productNo, Integer[] mr_cnumber,
			Double[] mr_grossWeight, Double[] mr_netWeight, Double[] mr_sizeLength, Double[] mr_sizeWidth,
			Double[] mr_sizeHeight, Double[] mr_exPrice, Double[] mr_tax, Integer[] mr_orderNo, Integer[] mr_changed) {

		for (int i = 0; i < mr_id.length; i++) {
			//if (mr_changed[i] != null && mr_changed[i] == 1) {
				ExportProduct ep = exportProductDao.get(mr_id[i]);
				ep.setcNumber(mr_cnumber[i]);
				ep.setGrossWeight(mr_grossWeight[i]);
				ep.setNetWeight(mr_netWeight[i]);
				ep.setSizeLength(mr_sizeLength[i]);
				ep.setSizeWidth(mr_sizeWidth[i]);
				ep.setSizeHeight(mr_sizeHeight[i]);
				ep.setExPrice(mr_exPrice[i]);
				ep.setTax(mr_tax[i]);
				ep.setOrderNo(mr_orderNo[i]);
				exportProductDao.update(ep);
			//}
		}
		exportDao.update(entity);

	}

}
