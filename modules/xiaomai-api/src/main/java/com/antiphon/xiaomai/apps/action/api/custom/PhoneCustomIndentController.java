package com.antiphon.xiaomai.apps.action.api.custom;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antiphon.xiaomai.apps.action.api.user.BaseController;
import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.modules.dto.CustomIndentDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomIndent;
import com.antiphon.xiaomai.modules.entity.custom.CustomPlayInfo;
import com.antiphon.xiaomai.modules.service.custom.CustomIndentService;
import com.antiphon.xiaomai.modules.service.custom.CustomPlayInfoService;

@Controller
@RequestMapping(value = "/termial/custom/indent")
public class PhoneCustomIndentController  extends BaseController{
	
	@Autowired
	private CustomIndentService customIndentService;
	
	@Autowired
	private CustomPlayInfoService customPlayInfoService;

	/**
	 * 订单玩法名称地市显示
	 * 
	 * @param user_phone
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getIndent", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO getIndent(Long playId,HttpServletResponse response, HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		String status = "1";
		String msg = "成功！";
		CustomIndentDto customIndentDto = null;
		try {
			CustomPlayInfo customPlayInfo =customPlayInfoService.findCustomPlayInfo(playId);
			//前端对象
			customIndentDto=new CustomIndentDto();
			customIndentDto.setLoginId(customPlayInfo.getUserId());
			customIndentDto.setPlayId(playId);
			customIndentDto.setPlayCity(customPlayInfo.getPlayCity());
			customIndentDto.setPlayName(customPlayInfo.getPlayName());
			customIndentDto.setPlayPrice(customPlayInfo.getPlayPrice());
			customIndentDto.setCustomId(customPlayInfo.getCustomId());
		} catch (Exception e) {
			status = "0";
			msg = "请求失败，请稍后再试";
		}
		BaseResponseDTO dto = new BaseResponseDTO(status, msg,customIndentDto);
		return dto;
	}
	
	
	/**
	 * 订单提交
	 * 
	 * @param user_phone
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "saveIndent", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO saveIndent(CustomIndent customIndent,HttpServletResponse response, HttpServletRequest request) {
		customIndentService.SaveOrupdateCustomIndent(customIndent);
		BaseResponseDTO dto = new BaseResponseDTO("1", "成功！","1");
		return dto;
	}
	
}
