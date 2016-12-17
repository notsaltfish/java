package com.chen.jk.controller.cargo.contract;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.jk.controller.BaseController;
import com.chen.jk.domain.Contract;
import com.chen.jk.print.ContractPrint;
import com.chen.jk.print.ContractPrintTemplate;
import com.chen.jk.service.ContractService;
import com.chen.jk.vo.ContractVO;

@Controller
public class ContractController extends BaseController{
		@Autowired
		private ContractService contractService;
	
		
		@RequestMapping("/cargo/contract/list.action")
		public String list(Model model){
		//	System.out.println("88888");
			List<Contract> list = contractService.find(null);
			model.addAttribute("dataList", list);
			
			return "/cargo/contract/jContractList.jsp";
		}
		
		@RequestMapping("/cargo/contract/toCreate.action")
		public String toCreate(){
			
			
			return "/cargo/contract/jContractCreate.jsp";
		}
		
		@RequestMapping("/cargo/contract/insert.action")
		public String insert(Contract contract){
			contractService.insert(contract);
			return "redirect:/cargo/contract/list.action";
		}

		@RequestMapping("/cargo/contract/delete.action")
		public String delete(String[] id){
			contractService.delete(id);
			
			return "redirect:/cargo/contract/list.action";
		}
		
		@RequestMapping("/cargo/contract/toUpdate.action")
		public String toUpdate(String id,Model model){
			Contract contract = contractService.get(id);
			model.addAttribute("obj", contract);
			return "/cargo/contract/jContractUpdate.jsp";
		}
	
		@RequestMapping("/cargo/contract/update.action")
		public String update(Contract contract){
			contractService.update(contract);
			return "redirect:/cargo/contract/list.action";
		}
		
		@RequestMapping("/cargo/contract/toView.action")
		public String toView(String id,Model model){
			ContractVO contract  = contractService.view(id);
			model.addAttribute("obj", contract);
			return "/cargo/contract/jContractView.jsp";
		} 
		
		@RequestMapping("/cargo/contract/submit.action")
		public String submit(String[] id){
			contractService.submit(id);
			return "redirect:/cargo/contract/list.action";
		}
		
		@RequestMapping("/cargo/contract/cancel.action")
		public String cancel(String[] id){
			contractService.cancel(id);
			return "redirect:/cargo/contract/list.action";
		}
		
		@RequestMapping("/cargo/contract/print.action")
		public void print(String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
			ContractPrint cp = new ContractPrint();
			ContractVO vo = contractService.view(id);
			cp.print(vo, request.getSession().getServletContext().getRealPath("/"), response);
			
		}
		
		@RequestMapping("/cargo/contract/printTemplate.action")
		public void printByTemplate(String id,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, ParseException, IOException{
			ContractPrintTemplate cp = new ContractPrintTemplate();
			
			ContractVO obj = contractService.view(id);
			cp.print(obj, request.getSession().getServletContext().getRealPath("/"), response);
		
			
			
		}
}


