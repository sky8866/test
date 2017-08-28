package com.antiphon.xiaomai.apps.action.api.ticket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antiphon.xiaomai.apps.action.api.user.BaseController;
import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.modules.entity.ticket.TicketIndent;
import com.antiphon.xiaomai.modules.service.ticket.TicketIndentService;

@Controller
@RequestMapping(value = "/termial/Ticket/indent")
public class PhoneTicketIndentController  extends BaseController{
	
	@Autowired
	private TicketIndentService ticketIndentService;
	
	
	/**
	 * 订单提交
	 * 
	 * @param user_phone
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "saveIndent", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO saveIndent(TicketIndent ticketIndent,HttpServletResponse response, HttpServletRequest request) {
		ticketIndentService.SaveOrupdateTicketIndent(ticketIndent);
		BaseResponseDTO dto = new BaseResponseDTO("1", "成功！","1");
		return dto;
	}
	
	/**
	 * 订单提交
	 * 
	 * @param user_phone
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getIndent", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO getIndent(Long id,HttpServletResponse response, HttpServletRequest request) {
		BaseResponseDTO dto = new BaseResponseDTO("1", "成功！","1");
		return dto;
	}
	
}
