package com.antiphon.xiaomai.apps.action.web.backpacking;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.entity.backpacking.Backpacking;
import com.antiphon.xiaomai.modules.service.backpacking.BackpackingService;


@Controller
@RequestMapping(value = "/admin/backpacking")
public class BackpackingController {
	private final static String BASE_PATH = "backpacking/"; 
	 
	@Autowired
	private BackpackingService backpackingService;
	
		@RequestMapping(value = "list")
		public String list(@RequestParam(value="pageNo",defaultValue="1") int pageNo,String status,HttpServletRequest request) {
			request.setAttribute("backpacking_list", "active");
			request.setAttribute("backpacking_active", "active");
			Map<String,String> params=new HashMap<String, String>();
			params.put("status", status);
			PageView<Backpacking> pv=backpackingService.findPageView(pageNo, Constants.PAGE_SIZE_PC, params);
			request.setAttribute("pageView", pv);
			request.setAttribute("status", status);
			return BASE_PATH+"list";
		}
		
		
		@RequestMapping(value = "updateStatus")
		public String updateStatus(int status,String ids,HttpServletRequest request) {
			request.setAttribute("backpacking_list", "active");
			request.setAttribute("backpacking_active", "active");
			backpackingService.updateStatus(ids, status);
			return "redirect:/admin/backpacking/list";
		}
		
		
}
