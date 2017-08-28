package com.antiphon.xiaomai.apps.action.web.ticket;

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
import com.antiphon.xiaomai.modules.entity.ticket.TicketIndent;
import com.antiphon.xiaomai.modules.service.indent.WithdrawalRecordService;
import com.antiphon.xiaomai.modules.service.ticket.TicketIndentService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;

@Controller
@RequestMapping(value = "/admin/ticket/indent")
public class TicketIndentController {
	private final static String BASE_PATH = "ticket/"; 
	
	@Autowired
	private TicketIndentService ticketIndentService;
	@Autowired
	private WithdrawalRecordService withdrawalRecordService;
	@Autowired
	MemberManager memberManager;
	/**
	 * 门票订单列表 
	 * @param pageNo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "indentList")
	public String indentList(@RequestParam(value = "pageNo", defaultValue = "1") String  pageNo,HttpServletRequest request) {
		Map<String,String> params=new HashMap<String, String>();
		params.put("pageNo",pageNo);
		params.put("pageSize","10");
		request.setAttribute("ticket_indent_li", "active");
		request.setAttribute("ticket_active", "active");
		PageView<TicketIndent>  pv=ticketIndentService.findTicketIndentPage(params);
		request.setAttribute("indentStatus", Constants.INDENT_STATUS); 
		request.setAttribute("pageView", pv);
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
		Map<String,String> params=new HashMap<String, String>();
		params.put("pageNo",pageNo);
		params.put("pageSize","10");
		params.put("chargeOff", "已核销");
		params.put("userId",memberManager.getUserId()+"");
		PageView<TicketIndent>  pv=ticketIndentService.findPageHqlTicketIndent(params);
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
	public Map<String,String> indentTotalPrice(HttpServletRequest request) {
		Map<String,String> data=new HashMap<String, String>();
		Long id=memberManager.getUserId();
		String total=ticketIndentService.getPriceTotal(id);
		boolean flag=withdrawalRecordService.getSubmitted(id);
		data.put("total", total);
		data.put("flag", flag+"");
		return data;
	}
	
	
}
