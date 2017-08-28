package com.antiphon.xiaomai.apps.action.web.cate;

 

import java.util.ArrayList;
import java.util.List; 

import javax.servlet.http.HttpServletRequest;   
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;   
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;   
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.Maxresult;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.entity.cate.Category; 
import com.antiphon.xiaomai.modules.service.cate.CategoryService; 
  


@Controller
@RequestMapping(value = "/admin/cate/category")
public class CategoryController {
	private final static String URL="/admin/cate/category";
	private final static String BASE_PATH = "cate/"; 
	@Autowired private CategoryService coategoryService; 
	@RequestMapping(value = "")
	
	public String list(String query,Long parentid,String starttime,String endtime,@RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) {
		 
		request.setAttribute("meishi_active", "active");
		request.setAttribute("category_active", "active");	
			PageView<Category> pageView = new PageView<Category>(Maxresult.MAX10,page);
			List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
			 
			 
			
			 if(parentid!=null){
		        	
	        	 filters.add(new PropertyFilter("parent.id", MatchType.EQ, parentid));
			}else{
			
				 filters.add(new PropertyFilter("parent", MatchType.NULL, null));

			}
			 if(StringUtils.isNotEmpty(query)){
					filters.add(new PropertyFilter("name", MatchType.LIKE, query));
				}
			pageView.setQueryResult(this.coategoryService.findPage(pageView, filters));
		 
			request.setAttribute("pageView", pageView); 
	
			request.setAttribute("parentid", parentid); 
		return BASE_PATH+"category";
	}
	
	@RequestMapping(value="create" , method = RequestMethod.GET)
	public String createForm(String parentid,Model model){
		model.addAttribute("meishi_active", "active");
		model.addAttribute("parentid", parentid);
		model.addAttribute("action", "create");
		return BASE_PATH + "categoryForm";
	}
	@RequestMapping(value="create" , method = RequestMethod.POST)
	public String create(@Valid Category type,Long parentid,Model model,RedirectAttributes redirectAttributes){
		model.addAttribute("meishi_active", "active");
		try {
			if(parentid!=null) type.setParent(new Category(parentid));
			this.coategoryService.saveCategory(type);
			
			redirectAttributes.addFlashAttribute("message",  "添加成功");
			 
			
		} catch (Exception e) {
			model.addAttribute("action", "create"); 
			redirectAttributes.addFlashAttribute("message",  "添加失败！");
			model.addAttribute("parentid", parentid);
			return BASE_PATH + "categoryForm";
		}

		return  "redirect:"+URL;
	}
 
	@RequestMapping(value="update/{id}/{page}" , method = RequestMethod.GET)
	public String update_ui(@PathVariable("id") Long id, @PathVariable("page") String page,HttpServletRequest request){
		request.setAttribute("meishi_active", "active"); 
		request.setAttribute("category_active", "active");	
		Category type=this.coategoryService.findCategory(id);
		request.setAttribute("type", type);
		request.setAttribute("page", page);
		request.setAttribute("action", "update");
		return  BASE_PATH +"categoryForm";
	}
	
	@RequestMapping(value="update" , method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("preloadCategory") Category type,Model model, RedirectAttributes redirectAttributes,String page){
	
		model.addAttribute("meishi_active", "active"); 
		model.addAttribute("category_active", "active");	
		try {
			this.coategoryService.updateCategory(type);
			redirectAttributes.addFlashAttribute("message", "更新成功");
			 
			
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "操作失败");
		}
		return  "redirect:"+URL+"?page="+page;
	}
	@RequestMapping(value="delete/{id}/{page}" , method = RequestMethod.GET)
	public String del(@PathVariable("id") Long id,@PathVariable("page") String page, RedirectAttributes redirectAttributes){
	
		try{
			 
			 
			
		this.coategoryService.delCategory(id);
		
			
		redirectAttributes.addFlashAttribute("message", "删除成功");
			
		}catch (Exception e) { 
			redirectAttributes.addFlashAttribute("message", "操作失败！");
			
		}
		
	
		
		return  "redirect:"+URL+"?page="+page;
	}
	
	@RequestMapping(value="delete" , method = RequestMethod.POST)
	public String del_type(Long[] typeid,String page,RedirectAttributes redirectAttributes){
		try{
			 
		 
			
			this.coategoryService.delCategory(typeid);
			
			redirectAttributes.addFlashAttribute("message", "删除成功");
		}catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "删除不成功");
		}
	
		 
		
		
		return  "redirect:"+URL+"?page="+page;
	}
	 
	
	
	/**
	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果
	 * 
	 */
	@ModelAttribute("preloadCategory")
	public Category getNewsType(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			return this.coategoryService.findCategory(id);
		}
		return null;
	}
	
	
  
}


