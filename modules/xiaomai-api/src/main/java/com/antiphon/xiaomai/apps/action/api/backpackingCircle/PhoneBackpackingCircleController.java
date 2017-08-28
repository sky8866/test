package com.antiphon.xiaomai.apps.action.api.backpackingCircle;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.antiphon.xiaomai.apps.fileUploadUtils.FileSetUtils;
import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.common.utils.SpringBeanLocator;
import com.antiphon.xiaomai.common.utils.UUID;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.entity.backpackingCircle.BackpackingCircle;
import com.antiphon.xiaomai.modules.entity.img.Imgs;
import com.antiphon.xiaomai.modules.service.backpackingCircle.BackpackingCircleService;
import com.antiphon.xiaomai.modules.service.img.impl.ImgsServiceImpl;

@Controller
@RequestMapping(value = "/termial/BackpackingCircle")
public class PhoneBackpackingCircleController {
	@Autowired
	private BackpackingCircleService backpackingCircleService;
	
	
	/**
	 * 发布约伴-圈子
	 */
	@RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO save(@Valid BackpackingCircle backpackingCircle,HttpServletRequest request) throws Exception{
		backpackingCircleService.saveBackpackingCircle(backpackingCircle);
		String module=Constants.IMGS_BACKPACKING_CIRCLE;
		Long userId=backpackingCircle.getUserId();
		//FileSetUtils.getFileSet(request, module, userId, backpackingCircle.getId());
		getFileSet(request, module, userId, backpackingCircle.getId());
		BaseResponseDTO dto=new  BaseResponseDTO("1","成功！");
    	return dto; 
    }
	
	   public void getFileSet(HttpServletRequest request,String module,Long userId,Long resourceId) {
	        try{
	            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	            String ext = null;
	            String imagename = null;
	            String uuid="";
	            for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
	                String key = (String) it.next();
	                MultipartFile file = multipartRequest.getFile(key);
	                String fileName = file.getOriginalFilename();
	                ext = fileName.substring(fileName.lastIndexOf(".") + 1);
	                uuid=UUID.getUUID();
	                imagename = uuid + "." + ext; // 构建文件名称
	                
	                if (fileName.length() > 0) {
	                        UploadUtils.saveImageFile(file, "/images/"+module+"/" + userId,
	                                imagename, ext, 60, true, request);
	                        UploadUtils.saveImageFile(file, "/images/"+module+"/" + userId,
	                                imagename, ext, 120, true, request);
	                        UploadUtils.saveImageFile(file, "/images/"+module+"/" + userId,
	                                imagename, ext, 200, request);
	                        UploadUtils.saveImageFile(file, "/images/"+module+"/" + userId,
	                                imagename, ext, 700, request);
	                     
	                        Imgs img = new Imgs();
	                        img.setImgName(imagename);
	                        img.setModule(module);
	                        img.setUserId(userId);
	                        img.setResourceId(resourceId);
	                        ImgsServiceImpl imgsService = (ImgsServiceImpl)SpringBeanLocator.getBean("ImgsServiceImpl");
	                        imgsService.saveImgs(img);
	                }
	       
	            }
	            
	            
	        }catch (Exception ex) {
	        	ex.printStackTrace();
	        }
	     
	    }
    
	
}
