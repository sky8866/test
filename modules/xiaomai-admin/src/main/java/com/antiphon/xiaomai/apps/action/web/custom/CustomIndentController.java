package com.antiphon.xiaomai.apps.action.web.custom;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.entity.custom.CustomIndent;
import com.antiphon.xiaomai.modules.service.custom.CustomIndentService;
import com.antiphon.xiaomai.modules.service.custom.CustomPlayInfoService;
import com.antiphon.xiaomai.modules.service.indent.WithdrawalRecordService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;

@Controller
@RequestMapping(value = "/admin/custom/indent")
public class CustomIndentController {

	private final static String BASE_PATH = "custom/"; 
	
	@Autowired
	private CustomIndentService customIndentService;
	@Autowired
	private CustomPlayInfoService customPlayInfoService; 
	@Autowired
	private WithdrawalRecordService withdrawalRecordService;
	@Autowired
	MemberManager memberManager;
	/**
	 * 定制游订单列表
	 * @param status
	 * @param pageNumber
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "indentList")
	public String indentList(String status,@RequestParam(value = "page", defaultValue = "1") int  pageNumber,HttpServletRequest request) {
		request.setAttribute("custom_active", "active");
		request.setAttribute("contom_indent", "active");
		Long userId=memberManager.getUserId();
		Map<String,String> params=new HashMap<String, String>();
		params.put("userId", userId+"");
		params.put("status", status);
		PageView<CustomIndent> pageView= customIndentService.findPageCustomIndent(pageNumber,params);
		request.setAttribute("indentStatus", Constants.INDENT_STATUS); 
		request.setAttribute("pageView", pageView); 
		request.setAttribute("status", status); 
		return BASE_PATH+"indentList";
	}
	
	/**
	 * 上月核销单
	 * @param pageNo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "indentTotalList")
	public String indentTotalList(@RequestParam(value = "pageNo", defaultValue = "1") String  pageNo,HttpServletRequest request) {
		request.setAttribute("custom_active", "active");
		Map<String,String> params=new HashMap<String, String>();
		params.put("pageNo",pageNo);
		params.put("pageSize","10");
		params.put("userId",memberManager.getUserId()+"");
		PageView<CustomIndent>  pv=customIndentService.findPageHqlCustomIndent(params);
		request.setAttribute("pageView", pv);
		return BASE_PATH+"indentChargeOffList";
	}
	
	
	
	
	/**
	 * 上月核销总金额
	 * @param 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "indentTotal")
	@ResponseBody
	public Map<String,String>  indentTotalPrice(HttpServletRequest request) {
		Map<String,String> data=new HashMap<String, String>();
		Long id=memberManager.getUserId();
		String total=customIndentService.getPriceTotal(id);
		boolean flag=withdrawalRecordService.getSubmitted(id);
		data.put("total",total);
		data.put("flag", flag+"");
		return data;
	}
}
