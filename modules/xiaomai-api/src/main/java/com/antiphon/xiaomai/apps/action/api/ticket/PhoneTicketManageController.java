package com.antiphon.xiaomai.apps.action.api.ticket;

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
import com.antiphon.xiaomai.modules.dto.ChoicenessTicketDto;
import com.antiphon.xiaomai.modules.dto.HotTicketDto;
import com.antiphon.xiaomai.modules.dto.TicketHomeDto;
import com.antiphon.xiaomai.modules.service.ticket.TicketManageService;

@Controller
@RequestMapping(value = "/termial/ticket")
public class PhoneTicketManageController  extends BaseController{
	
	@Autowired
	private  TicketManageService ticketManageService;
	
	/**
	 * 精选人气景点
	 * 
	 * @param 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getChoicenessTicketList", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO getChoicenessTicketList(HttpServletResponse response, HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		String status = "1";
		String msg = "成功！";
		List<ChoicenessTicketDto>  data=ticketManageService.getChoicenessTicketList();
		BaseResponseDTO dto = new BaseResponseDTO(status, msg,data);
		return dto;
	}
	
	/**
	 * 热门景点
	 * 
	 * @param 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getHotTicketList", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO getHotTicketList(String city,Double longitude,Double latitude,int pageSize,HttpServletResponse response, HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		String status = "1";
		String msg = "成功！";
		List<HotTicketDto>  data=ticketManageService.getHotTicketList(city,longitude,latitude,pageSize);
		BaseResponseDTO dto = new BaseResponseDTO(status, msg,data);
		return dto;
	}
	
	
	
	/**
	 * 全部景点
	 * 
	 * @param 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getPageTicket", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO getPageTicket(String ticketCity,String ticketType,String longitude,String latitude,String near, String distance,String pageNo,@RequestParam(value = "pageSize", defaultValue = "5") String pageSize,HttpServletResponse response, HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ticketCity", ticketCity);//所在城市
		params.put("ticketType", ticketType);//主题类型
		params.put("distance", distance);//离我距离内
		params.put("longitude", longitude);//经度
		params.put("latitude", latitude);//纬度
		params.put("near", near);//由近到远
		params.put("pageNo", pageNo);//当前页
		params.put("pageSize", pageSize);//页大小
		String status = "1";
		String msg = "成功！";
		List<HotTicketDto>data= ticketManageService.getPageTicket(params);
		BaseResponseDTO dto = new BaseResponseDTO(status, msg,data);
		return dto;
	}
	
	
	/**
	 * 景点详情页
	 * 
	 * @param 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getTicketHome", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO getTicketHome(Long id,HttpServletResponse response, HttpServletRequest request) {
		String status = "1";
		String msg = "成功！";
		TicketHomeDto data=ticketManageService.getTicketHome(id);
		BaseResponseDTO dto = new BaseResponseDTO(status, msg,data);
		return dto;
	}
	
	
	/**
	 * 门票类型-常量
	 * 
	 * @param 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getTicketType", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO getTicketType(Long id,HttpServletResponse response, HttpServletRequest request) {
		String status = "1";
		String msg = "成功！";
		BaseResponseDTO dto = new BaseResponseDTO(status, msg,Constants.TICKET_TYPE);
		return dto;
	}
	
}
