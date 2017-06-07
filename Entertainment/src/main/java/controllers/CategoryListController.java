package controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.entertainment_backend.dao.Categorydao;
import com.niit.entertainment_backend.model.Categorymodel;

@Controller
public class CategoryListController 
{
	@Autowired	
	private Categorydao c_dao;
	
	
	@RequestMapping("admin/CategoryList")
	public ModelAndView CategoryList(){
		List<Categorymodel> list=c_dao.getAllCategoryDetails();
		ModelAndView m = new ModelAndView("CategoryList");
		m.addObject("list", list);
	     return m;
	    		 }

}
