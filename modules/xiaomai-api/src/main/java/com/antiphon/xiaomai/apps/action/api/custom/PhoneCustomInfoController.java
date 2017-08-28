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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antiphon.xiaomai.apps.action.api.user.BaseController;
import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.modules.dto.CommentDto;
import com.antiphon.xiaomai.modules.dto.CustomInfoDetailDto;
import com.antiphon.xiaomai.modules.dto.CustomInfoDto;
import com.antiphon.xiaomai.modules.dto.CustomInfoHomeDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomInfo;
import com.antiphon.xiaomai.modules.entity.custom.CustomLabel;
import com.antiphon.xiaomai.modules.service.comment.CommentService;
import com.antiphon.xiaomai.modules.service.custom.CustomInfoService;
import com.antiphon.xiaomai.modules.service.custom.CustomLabelService;
import com.antiphon.xiaomai.modules.service.custom.CustomLanguageService;

@Controller
@RequestMapping(value = "/termial/custom")
// termial
public class PhoneCustomInfoController extends BaseController {
	@Autowired
	private CustomInfoService customInfoService;
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CustomLanguageService customLanguageService;
	
	@Autowired
	private CustomLabelService customLabelService;
	/**
	 * 定制师列表
	 * 
	 * @param user_phone
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO list(String playCity, String playType,String synthesize,String sex,
			@RequestParam(value = "pageNo", defaultValue = "1") String pageNo,
			HttpServletResponse response, HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("playCity",playCity);
		params.put("playType", playType);
		params.put("synthesize", synthesize);
		params.put("pageNo", pageNo);
		params.put("pageSize", "5");
		params.put("sex",sex);
		String status = "1";
		String msg = "成功！";
		 List<CustomInfoDto> data=customInfoService.getCustomInfoHomeByParams(params);
		BaseResponseDTO dto = new BaseResponseDTO(status, msg,data);
		return dto;
	}
	

	/**
	 * 定制师首页
	 * 
	 * @param user_phone
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "customHome", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO customHome(Long customId,HttpServletResponse response, HttpServletRequest request) {
		CustomInfoHomeDto customInfoHomeDto=customInfoService.getCustomInfoHome(customId);
		BaseResponseDTO dto = new BaseResponseDTO("1", "成功！",customInfoHomeDto);
		return dto;
	}
	
	
	/**
	 * 评论分页接口
	 * 
	 * @param user_phone
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "findPageComment", method = RequestMethod.POST)
	@ResponseBody
	public CommentDto findPageComment(@RequestParam(value = "pageSize", defaultValue = "5") String pageSize,@RequestParam(value = "pageNo", defaultValue = "1") String pageNo,HttpServletResponse response, HttpServletRequest request) {
		Map<String,String> params=new HashMap<String, String>();
		params.put("pageNo", pageNo);
		params.put("pageSize", pageSize);
		CommentDto commentDto=commentService.findPageCommentByParams(params);
		return commentDto;
	}
	
	/**
	 * 定制师个人详细信息
	 * 
	 * @param user_phone
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getCustomInfoDetail", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO getCustomInfoDetail(Long userId,HttpServletResponse response, HttpServletRequest request) {
		String status = "1";
		String msg = "成功！";
		CustomInfoDetailDto dto=null;
		try {
			CustomInfo customInfo=customInfoService.getCustomInfoByuserId(userId);
			if(customInfo!=null){
			dto=new CustomInfoDetailDto();
			dto.setNickname(customInfo.getNickname());
			dto.setInhabitCity(customInfo.getCity());
			dto.setHometown(customInfo.getHometown());
			dto.setInhabitTime(customInfo.getInhabitTime());
			dto.setMajor(customInfo.getMajor());
			dto.setProfession(customInfo.getProfession());
			dto.setSchoolTag(customInfo.getSchoolTag());
			dto.setEducation(customInfo.getEducation());
			dto.setChinese(customInfo.getChinese());
			dto.setEnglish(customInfo.getEnglish());
			dto.setCantonese(customInfo.getCantonese());
			dto.setDrivingLicense(customInfo.getDrivingLicense());
			dto.setVehicle(customInfo.getVehicle());
			dto.setVehicleModel(customInfo.getVehicleModel());
			
			}
		} catch (Exception e) {
			status = "0";
			msg = "请求失败，请稍后再试";
		}
		BaseResponseDTO result = new BaseResponseDTO(status,msg,dto);
		return result;
	}
	
	
	/**
	 * 修改定制师个人信息
	 * 
	 * @param user_phone
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "saveOrUpdateCustomInfo", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO saveOrUpdateCustomInfo(CustomInfo customInfo,HttpServletResponse response, HttpServletRequest request) {
		customInfoService.saveOrUpdateCustomInfoAppoint(customInfo);
		BaseResponseDTO result = new BaseResponseDTO("1","成功！","1");
		return result;
	}
	
	
	
	/**
	 * 修改定制师个人信息--语言表
	 * 
	 * @param user_phone
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "saveOrUpdateCustomLanguage", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO saveOrUpdateCustomLanguage(HttpServletResponse response, HttpServletRequest request) {
		String[] languages=request.getParameterValues("languages");
		String id=request.getParameter("id");
		customLanguageService.saveOrUpdateCustomLanguage(Long.parseLong(id),languages);
		BaseResponseDTO result = new BaseResponseDTO("1","成功！","1");
		return result;
	}
	
	
	/**
	 * 修改定制师个人信息--个性标签
	 * 
	 * @param user_phone
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "saveOrUpdateCustomLabel", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO saveOrUpdateCustomLabel(HttpServletResponse response, HttpServletRequest request) {
		String[] label=request.getParameterValues("label");
		String id=request.getParameter("id");
		customLabelService.saveOrUpdateCustomLabel(Long.parseLong(id), label);
		BaseResponseDTO result = new BaseResponseDTO("1","成功！","1");
		return result;
	}
	
}
