package com.antiphon.xiaomai.apps.action.api.custom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antiphon.xiaomai.apps.action.api.user.BaseController;
import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.modules.dto.CommentDto;
import com.antiphon.xiaomai.modules.dto.CustomHomeDto;
import com.antiphon.xiaomai.modules.dto.CustomHomeHotCityDto;
import com.antiphon.xiaomai.modules.dto.CustomPlayHomeDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomInfo;
import com.antiphon.xiaomai.modules.entity.custom.CustomLabel;
import com.antiphon.xiaomai.modules.entity.custom.CustomPlayInfo;
import com.antiphon.xiaomai.modules.service.comment.CommentService;
import com.antiphon.xiaomai.modules.service.custom.CustomInfoService;
import com.antiphon.xiaomai.modules.service.custom.CustomLabelService;
import com.antiphon.xiaomai.modules.service.custom.CustomPlayInfoService;

@Controller
@RequestMapping(value = "/termial/custom/play")
public class PhoneCustomPlayInfo extends BaseController{

	@Autowired
	private CustomPlayInfoService customPlayInfoService;
	
	@Autowired
	private CustomInfoService customInfoService;
	
	@Autowired
	private CustomLabelService customLabelService;
	
	@Autowired
	private CommentService commentService;
	/**
	 * 玩法详情
	 * 
	 * @param
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getCustomPlayInfo", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO getCustomPlayInfo(String playId,HttpServletResponse response, HttpServletRequest request) {
		String status = "1";
		String msg = "成功！";
		CustomPlayHomeDto customPlayHomeDto = null;
		try {
			CustomPlayInfo  playInfo=customPlayInfoService.findCustomPlayInfo(Long.parseLong(playId));//玩法详情
			CustomInfo customInfo=customInfoService.getCustomInfoByuserId(playInfo.getId());//定制师信息
			List<CustomLabel> customLabels=customLabelService.getCustomLabelList(playInfo.getUserId());//个性标签
			customPlayHomeDto=new CustomPlayHomeDto();
			customPlayHomeDto.setPlayCoverUrl(playInfo.getPlayCoverUrl());
			customPlayHomeDto.setPlayName(playInfo.getPlayName());
			customPlayHomeDto.setPlayCity(playInfo.getPlayCity());
			customPlayHomeDto.setCustomLabels(customLabels);
			customPlayHomeDto.setCustomName(customInfo.getNickname());
			customPlayHomeDto.setCustomPhotoUrl(customInfo.getPictureLink());
			customPlayHomeDto.setPlayContent(playInfo.getPlayContent());
			customPlayHomeDto.setPlayBookings(playInfo.getPlayBookings());
			
			Map<String,String> params=new HashMap<String, String>();
			params.put("userId",playInfo.getUserId().toString());
			params.put("page","1");
			CommentDto commentDto=commentService.findPageCommentByParams(params);//评论表
			customPlayHomeDto.setCommentDto(commentDto);
		} catch (Exception e) {
			status = "0";
			msg = "请求失败，请稍后再试";
		}
		BaseResponseDTO dto = new BaseResponseDTO(status, msg,customPlayHomeDto);
		return dto;
	}
	
	
	/**
	 * 定制师--热门目的地
	 * 
	 * @param
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "hotCity", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO hotCity(HttpServletResponse response, HttpServletRequest request) {
		String status = "1";
		String msg = "成功！";
		List<CustomHomeHotCityDto> data=customPlayInfoService.getCustomHomeHotCityDtoList();
		BaseResponseDTO dto = new BaseResponseDTO(status, msg,data);
		return dto;
	}
	
	
	/**
	 * 玩法类型
	 * 
	 * @param
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getPlayTypes", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO getPlayTypes(HttpServletResponse response, HttpServletRequest request) {
		String status = "1";
		String msg = "成功！";
		BaseResponseDTO dto = new BaseResponseDTO(status, msg,Constants.PLAY_TYPES);
		return dto;
	}
	
	
	/**
	 * 综合排序
	 * 
	 * @param
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getPlayOrder", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO getPlayOrder(HttpServletResponse response, HttpServletRequest request) {
		BaseResponseDTO dto = new BaseResponseDTO("1", "成功!",Constants.PLAY_ORDER);
		return dto;
	}
	
	

	
	
}
