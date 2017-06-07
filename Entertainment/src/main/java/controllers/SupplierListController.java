package controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.entertainment_backend.dao.Supplierdao;
import com.niit.entertainment_backend.model.Suppliermodel;


@Controller
public class SupplierListController 
{
	@Autowired
    private Supplierdao suppliers;
	
	@RequestMapping(value ="/admin/SupplierList")
    public ModelAndView add() {
			List<Suppliermodel> list=suppliers.getAllSupplierDetails();
			ModelAndView m = new ModelAndView("SupplierList");
			m.addObject("list", list);
		     return m;	   
	
    }

}
