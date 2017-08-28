package com.antiphon.xiaomai.apps.action.api.user;

 

 

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.common.utils.UUID;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.dto.UserInfoDto;
import com.antiphon.xiaomai.modules.entity.user.User;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
import com.antiphon.xiaomai.modules.service.user.UserService;
 

@Controller
@RequestMapping(value = "/termial/user")
public class PhoneUserController extends BaseController{
	
	private final static String BASE_PATH = "user/"; 
	@Autowired private MemberManager memberManager;
	
	@Autowired private UserService userService;
	
	@RequestMapping(value = "")
	public String word(HttpServletRequest request) {
		 request.setAttribute("user_active", "active");
		return BASE_PATH+"home";
	}
	
	
	@RequestMapping(value = "findUserInfo")
	@ResponseBody
	public BaseResponseDTO userInfo(Long id,HttpServletRequest request) {
		User user=userService.findUser(id);
		UserInfoDto userInfoDto=new UserInfoDto();
		userInfoDto.setName(user.getName());
		userInfoDto.setPhone(user.getMobile());
		userInfoDto.setIdentity(user.getIdentity());
		userInfoDto.setEmail(user.getEmail());
		userInfoDto.setPicture(user.getPicture());
		userInfoDto.setSex(user.getGender());
		userInfoDto.setCity(user.getCity());
		return new BaseResponseDTO("1", "成功！",userInfoDto);
	}
	
	
	@RequestMapping(value = "updatePhone")
	@ResponseBody
	public BaseResponseDTO updatePhone(Long id,String phone,HttpServletRequest request) {
		userService.updatePhone(id, phone);
		return new BaseResponseDTO("1", "成功！","1");
	}
	
	
	@RequestMapping(value = "updateUser")
	@ResponseBody
	public BaseResponseDTO updatePhone(User user, MultipartFile photo,HttpServletRequest request) {
		String url=null;
		User suser=userService.findUser(user.getId());
	    if(photo!=null&&!photo.isEmpty()){
	    	url=uploadPhoto(photo,request);
	    	suser.setPicture(url);
	    }
	
	    if(StringUtils.isNotEmpty(user.getCity())){
		suser.setCity(user.getCity());
	    }
	    if(StringUtils.isNotEmpty(user.getName())){
		suser.setName(user.getName());
	    }
		suser.setGender(user.getGender());
		
		userService.updateUser(suser);
		return new BaseResponseDTO("1", "成功！","1");
	}
	
	private String uploadPhoto(MultipartFile photo,HttpServletRequest request){
		 String imagename = null;
		if(photo!=null&& !photo.isEmpty()){
			 String fileName = photo.getOriginalFilename();
	         String ext = null;
	         ext = fileName.substring(fileName.lastIndexOf(".") + 1);
	         String uuid=UUID.getUUID();
	         imagename = uuid + "." + ext; // 构建文件名称
				try {
					UploadUtils.saveImageFile(photo, "/images/user/" + "55",
					         imagename, ext, 60, true, request);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return imagename;
	}
	
 
}
