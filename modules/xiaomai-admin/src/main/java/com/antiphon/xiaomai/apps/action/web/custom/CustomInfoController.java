package com.antiphon.xiaomai.apps.action.web.custom;

 

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.entity.custom.CustomInfo;
import com.antiphon.xiaomai.modules.entity.custom.CustomLabel;
import com.antiphon.xiaomai.modules.entity.custom.CustomLanguage;
import com.antiphon.xiaomai.modules.service.custom.CustomInfoService;
import com.antiphon.xiaomai.modules.service.custom.CustomLabelService;
import com.antiphon.xiaomai.modules.service.custom.CustomLanguageService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;


@Controller
@RequestMapping(value = "/admin/custom")
public class CustomInfoController {
	protected static final Logger log = Logger.getLogger(CustomInfoController.class);
	
	private final static String BASE_PATH = "custom/"; 
	
	@Autowired
	private CustomInfoService customInfoService; 
	
	@Autowired 
	private CustomLanguageService customLanguageService;
	
	@Autowired 
	private CustomLabelService customLabelService;
	@Autowired
	MemberManager memberManager;
	
	@RequestMapping(value = "customList")
	public String list(@RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) {
		return BASE_PATH+"userList";
	}
	
	/**
	 * 根据登陆id获取定制师个人信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getCustomInfo")
	public String getCustomInfo(HttpServletRequest request) {
		request.setAttribute("contominfo", "active");
		request.setAttribute("custom_active", "active");
		Long id=memberManager.getUserId();//获取登陆id
		//主表
		CustomInfo  customInfo=customInfoService.getCustomInfoByuserId(id);
		Long customId=customInfo.getId();
		//语言表
		List<CustomLanguage>  customLanguageList=customLanguageService.getCustomLanguageList(id);
		//个性标签
		List<CustomLabel>  customLabelList=customLabelService.getCustomLabelList(id);
		//个性标签全部
		request.setAttribute("customLabels",Constants.CUSTOM_LABELS); 
		request.setAttribute("glanguages",Constants.GLANGUAGES); 
		request.setAttribute("flanguages",Constants.FLANGUAGES); 
		
		request.setAttribute("customInfo",customInfo); 
		request.setAttribute("customLanguageList",customLanguageList); 
		request.setAttribute("customLabelList",customLabelList); 
		return BASE_PATH+"home";
	}
 
	@RequestMapping(value = "saveOrUpdateCustomInfo",method =RequestMethod.POST)
	public String saveOrUpdateCustomInfo(CustomInfo customInfo,MultipartFile filename,HttpServletRequest request,HttpServletResponse response) {
		String path=request.getContextPath();
		try {
			if(filename!=null&&filename.getSize()>0){
				String paht="/images/custom/";//存放路径
				String sqlpaht=UploadUtils.saveFile(filename, request,paht,customInfo.getPictureLink());//头像
				//图片上传
				customInfo.setPictureLink(sqlpaht);
			}
			customInfo.setUserId(memberManager.getUserId());//获取登陆id);
			customInfoService.saveOrUpdateCustomInfo(customInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/custom/getCustomInfo";
	}
}




