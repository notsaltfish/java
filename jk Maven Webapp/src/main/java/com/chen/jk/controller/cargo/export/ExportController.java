package com.chen.jk.controller.cargo.export;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.jk.controller.BaseController;
import com.chen.jk.domain.Contract;
import com.chen.jk.domain.Export;
import com.chen.jk.service.ExportService;

@Controller
public class ExportController extends BaseController {

	@Resource
	private ExportService exportService;
	
	@RequestMapping("/cargo/export/list.action")
	public String list(Model model){
		List<Export> dataList = exportService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/export/jExportList.jsp";
	}
	
	@	RequestMapping("/cargo/export/contractList.action")
	public String contractList(Model model,Map<String,String> map){
		List<Contract> dataList = exportService.getContractList();
		model.addAttribute("dataList", dataList);
		
		String name="test";
		String name2 = "test2";
		map.put("name", name);
		model.addAttribute("name2", name2);
		return "/cargo/export/jContractList.jsp";
	}
	
	
	
	@RequestMapping("/cargo/export/insert.action")
	public String insert(String[] id){
		exportService.insert(id);
		
		return "redirect:/cargo/export/contractList.action";
	}
	
	     @RequestMapping("/cargo/export/toUpdate.action")
    	public String toUpdate(String id,Model model){
    		Export obj = exportService.get(id);
    		String pInfo  = exportService.getProductInfo(id);
	    	model.addAttribute("obj", obj);
	    	model.addAttribute("productInfos",pInfo);
	    	return "/cargo/export/jExportUpdate.jsp";
    	}
	
	     @RequestMapping("/cargo/export/update.action")
	    	public String update(Export export,
	    			String[] mr_id,
	    			String[] mr_productNo,
	    			Integer[] mr_cnumber,
	    			Double[] mr_grossWeight,
	    			Double[] mr_netWeight,
	    			Double[] mr_sizeLength,
	    			Double[] mr_sizeWidth,
	    			Double[] mr_sizeHeight,
	    			Double[] mr_exPrice,
	    			Double[] mr_tax,
	    			Integer[] mr_orderNo,
 	    			Integer[] mr_changed){
	    	//addTRRecord(objId, id, productNo, cnumber, grossWeight, netWeight, 
	    	//sizeLength, sizeWidth, sizeHeight, exPrice, tax) {

	    		exportService.update( export, mr_id, mr_productNo,
		    			 mr_cnumber, mr_grossWeight, mr_netWeight, mr_sizeLength,
		    			 mr_sizeWidth,mr_sizeHeight, mr_exPrice,
		    			 mr_tax,mr_orderNo, mr_changed);
	    		
		    	return "redirect:/cargo/export/list.action";
	    	}
		
}

