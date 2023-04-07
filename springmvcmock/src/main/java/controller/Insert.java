package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.jese8.dao.empdao;

import dao.empdao;
import dto.Empdto;
@Controller
public class Insert {
	
	@RequestMapping("/insert")
	public ModelAndView insert(){
		ModelAndView modelAndView=new ModelAndView("insert.jsp");
		Empdto dto=new Empdto();
		modelAndView.addObject("idfc1", dto);
		return modelAndView;
		
	}
	@ResponseBody
	@RequestMapping("/value")
	public void data(Empdto dto){
		empdao dao=new empdao();
		dao.insert(dto);
		
	}
	@RequestMapping("/delete")
	public ModelAndView delete(){
		ModelAndView modelAndView=new ModelAndView("delete.jsp");
		Empdto empdto=new Empdto();
		modelAndView.addObject("idfc2", empdto);
		return modelAndView;
		
	}
	@RequestMapping("remove")
	@ResponseBody
	public String clean(Empdto empdto){
		empdao dao1=new empdao();
		Empdto empdto1=dao1.findbyId(empdto.getEmpid());
		dao1.deletedata(empdto1);
		return "successfully deleted" + empdto.getEmpid();
		
	}
	@RequestMapping("/fetch")
	public ModelAndView fetch() {
		ModelAndView modelAndView = new ModelAndView("fetch.jsp");
		Empdto empdto2 = new Empdto();
		modelAndView.addObject("idfc3", empdto2);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/retrive")
	public ModelAndView fetch1(String empid) {
		empdao empdao7=new empdao();
		Empdto empdto3 = empdao7.fetch(empid);
		ModelAndView modelAndView = new ModelAndView("fetch1.jsp");
		modelAndView.addObject("idfc4", empdto3);
		return modelAndView;
	}
	

}
