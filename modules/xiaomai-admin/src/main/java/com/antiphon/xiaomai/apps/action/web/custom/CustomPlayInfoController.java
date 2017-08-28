package com.antiphon.xiaomai.apps.action.web.custom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.entity.custom.CustomInfo;
import com.antiphon.xiaomai.modules.entity.custom.CustomPlayInfo;
import com.antiphon.xiaomai.modules.service.custom.CustomInfoService;
import com.antiphon.xiaomai.modules.service.custom.CustomPlayInfoService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;

@Controller
@RequestMapping(value = "/admin/custom/play")
public class CustomPlayInfoController {
	
private final static String BASE_PATH = "custom/"; 
	
	@Autowired
	private CustomPlayInfoService customPlayInfoService; 
	@Autowired
	MemberManager memberManager;
	@Autowired
	private CustomInfoService customInfoService;
	
	@RequestMapping(value = "playList")
	public String list(@RequestParam(value = "page", defaultValue = "1") int  pageNo,HttpServletRequest request) {
		request.setAttribute("custom_active", "active");
		request.setAttribute("contom_play", "active");
		Long userId=memberManager.getUserId();
		Map<String,String> params=new HashMap<String, String>();
		params.put("userId", userId+"");
		PageView<CustomPlayInfo> pageView= customPlayInfoService.findPageCustomPlayInfo(pageNo, params);
		request.setAttribute("pageView", pageView); 
		return BASE_PATH+"playList";
	}
	/**
	 * 跳转新增或修改页面
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "skipSaveOrUpdatePlay")
	public String skipSaveOrUpdatePlay(Long id,HttpServletRequest request) {
		request.setAttribute("custom_active", "active");
		request.setAttribute("contom_play", "active");
		if(id!=null){
		CustomPlayInfo customPlayInfo=customPlayInfoService.findCustomPlayInfo(id);
		request.setAttribute("customPlayInfo", customPlayInfo);
		}
		//玩法类型
		request.setAttribute("playTypes",Constants.PLAY_TYPES); 
		return BASE_PATH+"addPlay";
	}
	
	/**
	 * 新增或修改
	 * @param customPlayInfo
	 * @param filename
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "saveOrUpdatePlay")
	public void saveOrUpdatePlay(CustomPlayInfo customPlayInfo,MultipartFile filename,HttpServletRequest request,HttpServletResponse response) {
		try {
			String paht="/images/play/";//存放路径
			if(filename!=null &&filename.getSize()>0){
				String sqlpaht=UploadUtils.saveFile(filename, request,paht,customPlayInfo.getPlayCoverUrl());//头像
				//图片上传
				customPlayInfo.setPlayCoverUrl(sqlpaht);
			}
			Long userId=memberManager.getUserId();
			CustomInfo customInfo=customInfoService.getCustomInfoByuserId(userId);//定制师id
			customPlayInfo.setCustomId(customInfo.getId());
			customPlayInfo.setUserId(userId);
			customPlayInfo.setStatus(1);
			customPlayInfoService.saveOrUpdateCustomPlayInfo(customPlayInfo);
			response.sendRedirect(request.getContextPath()+"/admin/custom/play/skipSaveOrUpdatePlay?id="+customPlayInfo.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "delPlay")
	public void delPlay(Long id,HttpServletRequest request,HttpServletResponse response) {
		try {
			customPlayInfoService.delPlayInfo(id);
			response.sendRedirect(request.getContextPath()+"/admin/custom/play/playList");
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "updateStatus")
	@ResponseBody
	public Map<String,String> updateStatus(String ids,@RequestParam(value = "status", defaultValue = "1") int  status,HttpServletRequest request,HttpServletResponse response) {
		String msg="操作成功！";
		try {
			customPlayInfoService.updateStatus(ids, status);
		} catch (Exception e) {
			e.printStackTrace();
			msg="操作失败！";
		}
		Map<String,String> data=new HashMap<String, String>();
		data.put("msg", msg);
		return  data;
	}
}
