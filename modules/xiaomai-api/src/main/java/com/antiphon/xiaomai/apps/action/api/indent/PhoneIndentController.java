package com.antiphon.xiaomai.apps.action.api.indent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antiphon.xiaomai.apps.action.api.user.BaseController;
import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.modules.dto.IndentDto;
import com.antiphon.xiaomai.modules.service.indent.IndentService;

@Controller
@RequestMapping(value = "/termial/indent")
public class PhoneIndentController  extends BaseController{
	
	@Autowired
	private  IndentService indentService;
	

	/**
	 *	我的订单列表
	 * 
	 * @param 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "findPageIndent", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO findPageIndent(Long userId,String status,@RequestParam(value = "pageSize", defaultValue = "5") int  pageSize,@RequestParam(value = "pageNo", defaultValue = "1") int  pageNo,HttpServletResponse response, HttpServletRequest request) {
		List<IndentDto>  data=indentService.findPageIndent(userId,status,pageNo,Constants.PAGE_SIZE_PHONE);
		BaseResponseDTO dto = new BaseResponseDTO("1", "成功！",data);
		return dto;
	}
	
	
	/**
	 *	我的-取消订单
	 * 
	 * @param 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "updateIndentStatus", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO updateIndentStatus(Long indentId,int type,HttpServletResponse response, HttpServletRequest request) {
		indentService.updateIndentStatus(indentId, type);
		BaseResponseDTO dto = new BaseResponseDTO("1", "成功！","1");
		return dto;
	}
	
}
