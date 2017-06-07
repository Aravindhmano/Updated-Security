package controllers;



import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.entertainment_backend.dao.Categorydao;
import com.niit.entertainment_backend.dao.Supplierdao;
import com.niit.entertainment_backend.dao.Teledao;
import com.niit.entertainment_backend.model.Categorymodel;
import com.niit.entertainment_backend.model.Suppliermodel;
import com.niit.entertainment_backend.model.Telemodel;



@Controller
class CategoryController {
    
    @Autowired
    private Categorydao categorys;
    @Autowired
    private Supplierdao suppliers;
    @Autowired
    private Teledao teleDao;
    
    
    /* @RequestMapping(value ="/add")
        public ModelAndView add() {
            System.out.println("in add");
         ModelAndView c1=new ModelAndView("Adding");
            return c1;
        }*/
     
    @RequestMapping(value ="/admin/add")
    public ModelAndView add() {

		List<Categorymodel> list=categorys.getAllCategoryDetails();
	  List<Suppliermodel> slist=suppliers.getAllCategoryDetails();
		ModelAndView mv = new ModelAndView("Adding");
		mv.addObject("clist", list);
		mv.addObject("slist",slist);
		return mv;
        
	// ModelAndView c1=new ModelAndView("Adding");
	//	return c1;
    }
     
     @RequestMapping(value ="/admin/category")
        public ModelAndView addcategory(HttpServletRequest request)
        {
            
         /*String c_id=String.valueOf(request.getParameter("cId"));*/
    	 int c_id=Integer.parseInt(request.getParameter("cId"));
            String c_name=request.getParameter("cn");
            System.out.println(c_id+"---"+c_name);
            categorys.addCategoryDetails(new Categorymodel(c_id,c_name,null));
            List<Categorymodel> list=categorys.getAllCategoryDetails();
      	  List<Suppliermodel> slist=suppliers.getAllCategoryDetails();
      		ModelAndView mv = new ModelAndView("Adding");
      		//System.out.println(list.get(0).getC_name());	
      		//mv.addObject("slist", slist);
      		
      		mv.addObject("clist", list);
      		mv.addObject("slist",slist);
      		return mv;
            
        }
     
     
     
     @RequestMapping(value ="/admin/supplier")
     public ModelAndView addsupplier(HttpServletRequest request)
     {
         
      /*String s_id=String.valueOf(request.getParameter("sId"));*/
    	 int
    	 s_id=Integer.parseInt(request.getParameter("sId"));
         String s_name=request.getParameter("sn");
         System.out.println(s_id+"---"+s_name);
        suppliers.addSupplierDetails(new Suppliermodel(s_id,s_name));
        List<Categorymodel> list=categorys.getAllCategoryDetails();
  	  List<Suppliermodel> slist=suppliers.getAllCategoryDetails();
  		ModelAndView mv = new ModelAndView("Adding");
  		//System.out.println(list.get(0).getC_name());	
  		//mv.addObject("slist", slist);
  		mv.addObject("clist", list);
  		mv.addObject("slist",slist);
  		return mv;
     }
     
     @RequestMapping(value ="/admin/product")
     public ModelAndView addproduct(@RequestParam("file") MultipartFile file ,HttpServletRequest request)
     {
         
         /*String p_id=request.getParameter("pid");*/
    	 int p_id=Integer.parseInt(request.getParameter("pid"));
         String p_name=request.getParameter("pn");
         /*String p_img=request.getParameter("pimg");*/
         String originalfile = file.getOriginalFilename();
         int p_price=Integer.valueOf(request.getParameter("pp"));
         /*String p_cat=request.getParameter("pc");*/
         int p_cat=Integer.parseInt(request.getParameter("pc"));
         /*String p_sc=request.getParameter("psc");*/
         int p_sc=Integer.parseInt(request.getParameter("psc"));
         String pdes=request.getParameter("pd");
         System.out.println(p_id+"---"+p_name+p_cat+p_price+p_sc);
         Categorymodel c=categorys.getCategoryDetails(p_cat);
         Suppliermodel s=suppliers.getSupplierDetails(p_sc);
         Telemodel t=new Telemodel();

      
         t.setProdId(p_id);
         t.setImage(originalfile);
         t.setProdDescription(pdes);
         t.setProdName(p_name);
         t.setProdPrice(p_price);
         t.setProdCategory(c);       
         t.setProdSupplier(s);
        
         teleDao.addProduct(t);
         String filepath = request.getSession().getServletContext().getRealPath("/") + "resources/product/" + file.getOriginalFilename();
 		
 		System.out.println(filepath);
 		try {
 			byte imagebyte[] = file.getBytes();
 			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
 			fos.write(imagebyte);
 			fos.close();
 			} catch (IOException e) {
 			e.printStackTrace();
 			} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 			}
         
         List<Categorymodel> list=categorys.getAllCategoryDetails();
   	  List<Suppliermodel> slist=suppliers.getAllCategoryDetails();
   		ModelAndView mv = new ModelAndView("Adding");
   		//System.out.println(list.get(0).getC_name());	
   		//mv.addObject("slist", slist);
   		mv.addObject("clist", list);
   		mv.addObject("slist",slist);
   		return mv;
     }
     
     @RequestMapping(value ="/admin/product_update")
     public ModelAndView editProduct(@RequestParam("file") MultipartFile file,HttpServletRequest request)
     {
         
    	 System.out.print("\n.....In Controller.....\n");
         /*String p_id=request.getParameter("pid");*/
    	 int p_id=Integer.parseInt(request.getParameter("p_id"));
         String p_name=request.getParameter("p_name");
         int p_price=Integer.valueOf(request.getParameter("p_price"));
         /*String p_cat=request.getParameter("pc");*/
         int p_cat=Integer.parseInt(request.getParameter("c_id"));
         /*String p_sc=request.getParameter("psc");*/
         int p_sc=Integer.parseInt(request.getParameter("s_id"));
         String pdes=request.getParameter("p_desc");
         System.out.println(p_id+"---"+p_name+p_cat+p_price+p_sc);
         Categorymodel c=categorys.getCategoryDetails(p_cat);
         Suppliermodel s=suppliers.getSupplierDetails(p_sc);
         Telemodel t=new Telemodel();

         String original=file.getOriginalFilename();
         t.setProdId(p_id);
         t.setImage(original);
         t.setProdDescription(pdes);
         t.setProdName(p_name);
         t.setProdPrice(p_price);
         t.setProdCategory(c);       
         t.setProdSupplier(s);
        
         teleDao.updateProductDetails(t);
         String filepath = request.getSession().getServletContext().getRealPath("./") + "resources/product/" + file.getOriginalFilename();
  		
  		System.out.println(filepath);
  		try {
  			byte imagebyte[] = file.getBytes();
  			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
  			fos.write(imagebyte);
  			fos.close();
  			} catch (IOException e) {
  			e.printStackTrace();
  			} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			}
      /*   List<Categorymodel> list=categorys.getAllCategoryDetails();
   	  List<Suppliermodel> slist=suppliers.getAllCategoryDetails();*/
   	  List<Telemodel> list=teleDao.getAllProductDetails();
   	  
   		ModelAndView mv = new ModelAndView("ProductList");
   		//System.out.println(list.get(0).getC_name());	
   		//mv.addObject("slist", slist);
   		/*mv.addObject("clist", list);*/
   		mv.addObject("list",list);
   		return mv;
     }
     @RequestMapping(value="/admin/product_delete")
 	public ModelAndView deleteProduct(HttpServletRequest request){
 		
    	 System.out.println(request.getParameter("id"));
 		Telemodel p=teleDao.getProductDetail(Integer.valueOf(request.getParameter("id")));
 		System.out.print(p);
 	teleDao.delete(p);
 	List<Telemodel> list=teleDao.getAllProductDetails();
 	System.out.println(list);
 	ModelAndView mv = new ModelAndView("ProductList");	
 	mv.addObject("list",list);
 	return mv;
 	}
     
     
     @RequestMapping(value="/admin/product_edit")
 	public ModelAndView editProducts(HttpServletRequest request){	
 	int id=Integer.parseInt(request.getParameter("id"));
 	ModelAndView mv=new ModelAndView("productEdit");
 	  List<Categorymodel> list=categorys.getAllCategoryDetails();
   	  List<Suppliermodel> slist=suppliers.getAllCategoryDetails();
   	  mv.addObject("product",teleDao.getProductDetail(id) );	
 	mv.addObject("slist", slist);
 	mv.addObject("clist", list);
 	return mv;
 	}

     @RequestMapping("/productfilter")
 	public ModelAndView productListFilter(HttpServletRequest request)
 	{ 
 		List<Telemodel> list=teleDao.getFilterProducts(Integer.valueOf(request.getParameter("id")));
 		//List<Product> list=productDao.getProducts();
 		ModelAndView mv = new ModelAndView("productfilter");	
 		mv.addObject("list",list);
 		return mv;
 	}
     
     
     
}
		