package controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.entertainment_backend.dao.Cartdao;
import com.niit.entertainment_backend.dao.Categorydao;
import com.niit.entertainment_backend.dao.Supplierdao;
import com.niit.entertainment_backend.dao.Teledao;
import com.niit.entertainment_backend.dao.Userdao;
import com.niit.entertainment_backend.impl.Teledaoimpl;
import com.niit.entertainment_backend.model.Cartmodel;
import com.niit.entertainment_backend.model.Categorymodel;
import com.niit.entertainment_backend.model.Suppliermodel;
import com.niit.entertainment_backend.model.Telemodel;
import com.niit.entertainment_backend.model.Usermodel;

import helpers.Invoice;

@Controller
public class IndexController {
	
	
	@Autowired	
	private Teledao t_dao;
	
	@Autowired	
	private Categorydao c_dao;
	
	@Autowired
	private Userdao userdao;
	
	@Autowired
	private Supplierdao s_dao;
	
	@Autowired
	private Cartdao cart1;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
/*	@RequestMapping("/userlogged")
	public ModelAndView userLogged() { 
		ModelAndView mv = new ModelAndView("/");
		
		return mv;
	}*/
	@RequestMapping("/userlogged")
	public String userLogged() { 
		return "redirect:/";	
	}
	
	@RequestMapping("/")
	public ModelAndView index() {
		List<Categorymodel> list=c_dao.getAllCategoryDetails();
		  List<Suppliermodel> slist=s_dao.getAllCategoryDetails();
			ModelAndView mv = new ModelAndView("index");
			//System.out.println(list.get(0).getC_name());	
			//mv.addObject("slist", slist);
			mv.addObject("clist", list);
			mv.addObject("slist",slist);
			return mv;
		
	}
	
	@ModelAttribute
	  public void addAttributes(Model m){
	  m.addAttribute("clist",c_dao.getAllCategoryDetails());
	  }
	   
	
	
	
	@RequestMapping("/register")
	public ModelAndView reg(HttpServletRequest request)
	{
        String mail=request.getParameter("mail");
        String name=request.getParameter("name");
		String add=request.getParameter("address");
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("phone");
		String pass=request.getParameter("passwd");
		System.out.println(""+name+"mail"+"add"+add+"age"+age+"phone"+phone+"pass"+pass);
		Usermodel u=new Usermodel();
		u.setU_mail(mail);
		u.setUserAge(age);
		u.setUserPassword(pass);
		u.setUserPhno(phone);
		u.setUserRole("ROLE_USER");
		userdao.addUserDetails(u);
		
		
		ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}
	
	
	@RequestMapping("/product")
	public ModelAndView product(HttpServletRequest request) 
	{
		
        int id=Integer.valueOf(request.getParameter("id"));
        Telemodel p=t_dao.getProductDetail(id);
		ModelAndView mv = new ModelAndView("ProductDetails");
		List<Categorymodel> c=c_dao.getAllCategoryDetails();
		mv.addObject("list",c);
		mv.addObject("product", p);
		
		return mv;
	}
	
	
	@RequestMapping("/Checkout")
	public ModelAndView login() {
	ModelAndView mv = new ModelAndView("Checkout");
		return mv;
	}
	
	
	@RequestMapping("/registration")
	public ModelAndView registration() {

		ModelAndView mv = new ModelAndView("registration");
		
		return mv;
	}


	@RequestMapping("/noAccessPage")
	public ModelAndView noAccessPage() {

		ModelAndView mv = new ModelAndView("noAccessPage");
		
		return mv;
	}
	
	
	@RequestMapping("admin/ProductList")
	public ModelAndView ProductList(){
		List<Telemodel> list=t_dao.getAllProductDetails();
		ModelAndView m = new ModelAndView("ProductList");
		m.addObject("list", list);
	     return m;
	    		 }
	
	
	@RequestMapping("/productdetails")
	public ModelAndView addCarttable(HttpServletRequest request) 
	{
		
		int id=Integer.valueOf(request.getParameter("prodid"));
		
		int quan=Integer.valueOf(request.getParameter("prodquantity"));
		
		int price=Integer.valueOf(request.getParameter("prodprice"));
	
		System.out.println(""+id+""+quan+""+price);
		Telemodel p=t_dao.getProductDetail(id);
		
		Cartmodel g=new Cartmodel();
		g.setPrices(price);
		g.setQuantity(quan);
		g.setProductid(p);
		List<Cartmodel> list=cart1.checkExistance(id);
		int count=list.size();
		System.out.println("No of times: "+count);
		if(count==0)
		{
			cart1.save(g);
		}
		else
		{
			Cartmodel cart=cart1.getId(list.get(0).getCartid());
			int ex=cart.getQuantity();
			System.out.println("-----------Existance Count ="+ex+"\n current Count = "+quan+"------------\n---Total =-"+(ex+quan));
			int tot=ex+quan;
			cart.setQuantity(tot);
			cart1.update(cart);
		}
		 
		
		System.out.println(g);
		
		ModelAndView mv=new ModelAndView("viewcart");
		List<Cartmodel> cartList=cart1.getAll();
		
		mv.addObject("cartlist", cartList);
		return mv;
		
		
		

		
	}
	
	@RequestMapping("/cart_delete")
	public ModelAndView editCart(HttpServletRequest request)
	{
		int cid=Integer.valueOf(request.getParameter("id"));
		Cartmodel c=cart1.getId(cid);
		System.out.println(c);
		cart1.deleteById(c);
		
		ModelAndView mv=new ModelAndView("viewcart");
		List<Cartmodel> cartList=cart1.getAll();
		
		mv.addObject("cartlist", cartList);
		return mv;
	}
	
	
	@RequestMapping("/viewcart")
	public ModelAndView viewCart(){
		
		ModelAndView mv=new ModelAndView("viewcart");
		List<Cartmodel> cartList=cart1.getAll();
		
		mv.addObject("cartlist", cartList);
		return mv;
	}
	
	
	@RequestMapping("/Thank")	
	public ModelAndView thank() {

		ModelAndView mv = new ModelAndView("Thank");
		
		return mv;
	}


@RequestMapping(value="/summary")
public ModelAndView summary(HttpServletRequest request)
{
		
	
	Invoice summary=new Invoice();
	summary.setName(request.getParameter("name"));
	summary.setEmail(request.getParameter("email"));
	summary.setContact(request.getParameter("phone"));
	summary.setAddress(request.getParameter("textarea"));
	summary.setDate(request.getParameter("date"));
	ModelAndView m8=new ModelAndView("summary");
	m8.getModelMap().addAttribute("summary", summary);
	return m8;
	
}

}