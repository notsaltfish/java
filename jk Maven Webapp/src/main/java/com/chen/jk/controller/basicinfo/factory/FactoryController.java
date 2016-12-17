package com.chen.jk.controller.basicinfo.factory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.jk.controller.BaseController;
import com.chen.jk.domain.Factory;
import com.chen.jk.service.FactoryService;


@Controller
public class FactoryController extends BaseController{
	@Resource
	private FactoryService factoryService; 
	
	
	@RequestMapping("/basicinfo/factory/list.action")
	public String list(Model model){
	//	System.out.println("88888");
		List<Factory> list = factoryService.find(null);
		model.addAttribute("dataList", list);
		
		return "/basicinfo/factory/jFactoryList.jsp";
	}
	
	@RequestMapping("/basicinfo/factory/toCreate.action")
	public String toCreate(){
		
		return "/basicinfo/factory/jFactoryCreat.jsp";
	}
	
	@RequestMapping("/basicinfo/factory/insert.action")
	public String insert(Factory factory){
		factoryService.insert(factory);
		return "redirect:/basicinfo/factory/list.action";
		
	}
	
	@RequestMapping("/basicinfo/factory/toUpdate.action")
	public String toUpdate(String id,Model model){
		Factory factory = factoryService.get(id);
		model.addAttribute("obj",factory);
		return "/basicinfo/factory/jFactoryUpdate.jsp";
	}
	
	@RequestMapping("/basicinfo/factory/update.action")
	public String update(Factory factory){
		factoryService.update(factory);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	@RequestMapping("/basicinfo/factory/deleteById.action")
	public String delete(String id){
		factoryService.deleteById(id);
		
	return "redirect:/basicinfo/factory/list.action";
	}
	
	@RequestMapping("/basicinfo/factory/delete.action")
	public String delete(String[] id){
		factoryService.delete(id);
		
	return "redirect:/basicinfo/factory/list.action";
	}
	
	
	@RequestMapping("/basicinfo/factory/toView.action")
	public String toView(String id,Model model){
			Factory factory = factoryService.get(id);
			model.addAttribute("obj", factory);
		return "/basicinfo/factory/jFactoryView.jsp";
	}
	
	@RequestMapping("/basicinfo/factory/start.action")
	public String start(String[] id){
		factoryService.start(id);
		
		return "redirect:/basicinfo/factory/list.action";
	}
	
	@RequestMapping("/basicinfo/factory/stop.action")
	public String stop(String[] id){
		factoryService.stop(id);
		
		return "redirect:/basicinfo/factory/list.action";
	}
}


