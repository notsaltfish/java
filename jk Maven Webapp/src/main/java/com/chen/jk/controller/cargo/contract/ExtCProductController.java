package com.chen.jk.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.jk.controller.BaseController;
import com.chen.jk.domain.ExtCProduct;
import com.chen.jk.domain.Factory;
import com.chen.jk.domain.SysCode;
import com.chen.jk.service.ExtCProductService;
import com.chen.jk.service.FactoryService;
import com.chen.jk.service.SysCodeService;

@Controller
public class ExtCProductController extends BaseController{

	@Resource
	private ExtCProductService extCProductService;
	@Resource
	private FactoryService factoryService; 
	@Resource
	private SysCodeService sysCodeService;
	
	
	
	@RequestMapping("/cargo/extcproduct/tocreate.action")
	public String toCreate(String contractProductId,Model model){
		List<Factory> factoryList = factoryService.find(null);
		Map<String,String> paraMap = new HashMap<String,String>();
		paraMap.put("parentId", "0104");//获取所有的包装类型0104代表数字字典表中包装类型代码
		List<SysCode> cTypeList = sysCodeService.find(paraMap);
		HashMap<String,String> maps = new HashMap<String,String>();
		maps.put("contractProductId", contractProductId);
		List<ExtCProduct> dataList = extCProductService.find(maps);//获取该货物的附件信息
		model.addAttribute("dataList", dataList);
		model.addAttribute("factoryList", factoryList);
		model.addAttribute("contractProductId", contractProductId);
		model.addAttribute("cTypeList", cTypeList);
		
		return "/cargo/contract/jExtCProductCreate.jsp";
	}
	
	@RequestMapping("/cargo/extcproduct/insert.action")
	public String insert(ExtCProduct extCProduct,Model model){
		extCProductService.insert(extCProduct);
		model.addAttribute("contractProductId", extCProduct.getId());
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
	@	RequestMapping("/cargo/extcproduct/toupdate.action")
	public String toUpdate(String id, Model model){
		Map<String,String> paraMap = new HashMap<String,String>();
		paraMap.put("parentId", "0104");//获取所有的包装类型0104代表数字字典表中包装类型代码
		List<Factory> factoryList = factoryService.find(null);
		List<SysCode> cTypeList = sysCodeService.find(paraMap);
		model.addAttribute("factoryList", factoryList);
		model.addAttribute("cTypeList", cTypeList);
		
		ExtCProduct product = extCProductService.get(id);
		model.addAttribute("obj",product);
		return "/cargo/contract/jExtCProductUpdate.jsp";
	}
	
	@RequestMapping("/cargo/extcproduct/update.action")
	public String update(ExtCProduct extproduct,Model model,String contractProductId){
		extCProductService.update(extproduct);
		model.addAttribute("contractProductId", contractProductId);
		
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
	@RequestMapping("/cargo/extcproduct/delete.action")
	public String deleteById(String id,String contractProductId,Model model){
		extCProductService.deleteById(id);
		model.addAttribute("contractProductId", contractProductId);
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
}
