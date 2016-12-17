package com.chen.jk.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.jk.controller.BaseController;
import com.chen.jk.domain.ContractProduct;
import com.chen.jk.domain.Factory;
import com.chen.jk.service.ContractProductService;
import com.chen.jk.service.FactoryService;

@Controller
public class ContractProductController extends BaseController{
	@Resource
	private ContractProductService contractProductService;
	@Resource
	private FactoryService factoryService;
	
	/**
	 * 前往添加货物页面
	 * @param contractId
	 * @param model
	 * @return
	 */
	@RequestMapping("/cargo/contractproduct/tocreate.action")
	public String toCreate(String contractId,Model model){
		model.addAttribute("contractId", contractId);
		List<Factory> factoryList = factoryService.find(null);
		HashMap<String,String> paraMap= new HashMap<String,String>();
		paraMap.put("contractId", contractId);
		List<ContractProduct> contractProduct = contractProductService.find(paraMap);
		model.addAttribute("factoryList", factoryList);
		model.addAttribute("dataList", contractProduct);
		return "/cargo/contract/jContractProductCreate.jsp";
	}
	
	/**
	 * 新增一条合同货物记录
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping("/cargo/contractproduct/insert.action")
	public String insert(ContractProduct product,Model model){
		contractProductService.insert(product);
		model.addAttribute("contractId", product.getContractId());
		return "redirect:/cargo/contractproduct/tocreate.action";
	}
	
	/**
	 * 前往修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/cargo/contractproduct/toupdate.action")
	public String toUpdate(String id,Model model){
		ContractProduct obj= contractProductService.get(id);
		List<Factory> factoryList = factoryService.find(null);
		model.addAttribute("obj", obj);
		model.addAttribute("factoryList", factoryList);
		return "/cargo/contract/jContractProductUpdate.jsp";
	}
	
	/**
	 * 修改
	 * @param obj
	 * @return
	 */
	@RequestMapping("/cargo/contractproduct/update.action")
	public String update(ContractProduct obj){
		contractProductService.update(obj);
	
		return "redirect:/cargo/contractproduct/tocreate.action";
	}
	
	@RequestMapping("/cargo/contractproduct/delete.action")
	public String deleteById(String id){
		contractProductService.deleteById(id);
		return "redirect:/cargo/contractproduct/tocreate.action";
	}
	
}
