package com.antiphon.xiaomai.apps.action.web.img;

 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List; 
import java.util.Set;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;   
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.common.utils.UUID;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.Maxresult;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.entity.cate.CateShop;
import com.antiphon.xiaomai.modules.entity.img.Imgs;
import com.antiphon.xiaomai.modules.entity.user.User;
import com.antiphon.xiaomai.modules.service.cate.CateShopService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;
  


@Controller
@RequestMapping(value = "/admin/ajax/img")
public class ImgAjaxController {
	  @Autowired ImgsService imgsService;
 
     @Autowired MemberManager meberManager;
    @RequestMapping(value = "upload",method =RequestMethod.POST)
    @ResponseBody
    public String update(String module,
    		HttpServletRequest request,HttpServletResponse response) {
             
    		try{
    			Long userId=this.meberManager.getUserId();
    		    
    	           Set<MultipartFile> files = getFileSet(request);
    	           StringBuffer sb=new StringBuffer();
    	           for (MultipartFile myfile : files) {
    	              
    	                   String fileName = myfile.getOriginalFilename();
    	                  
    	                   String ext = null;
    	                   String imagename = null;
    	                   ext = fileName.substring(fileName.lastIndexOf(".") + 1);
    	                   String uuid=UUID.getUUID();
    	                  
    	                   imagename = uuid + "." + ext; // 构建文件名称
    	                   if (ext != null) {
                               try {
                                   UploadUtils.saveImageFile(myfile, "/images/"+module+"/" + userId,
                                           imagename, ext, 60, true, request);
                                   UploadUtils.saveImageFile(myfile, "/images/"+module+"/" + userId,
                                           imagename, ext, 120, true, request);
                                   UploadUtils.saveImageFile(myfile, "/images/"+module+"/" + userId,
                                           imagename, ext, 200, request);
                                   UploadUtils.saveImageFile(myfile, "/images/"+module+"/" + userId,
                                           imagename, ext, 700, request);
                                   
                                
                                
                               
                                   Imgs img = new Imgs();
                                   img.setImgName(imagename);
                                   
                                   img.setModule(module);
                                   img.setUserId(userId);
                                   
                                    this.imgsService.saveImgs(img);
                                    sb.append(img.getId()).append(",");
                               } catch (Exception e) {

                               }
                           }
    	               }
  
	    		 sb.deleteCharAt(sb.length()-1);
	    	 
	    		
	    		return  sb.toString();
	    	}catch (Exception e) {
				return "";
			}
     
  
  }
    
    @RequestMapping(value = "del",method =RequestMethod.POST)
    @ResponseBody
    public String del(Long id,
    		HttpServletRequest request,HttpServletResponse response) {
     
    		try{
	    		 this.imgsService.delImgs(id);
	    		 
	    		return  "true";
	    	}catch (Exception e) {
	    		e.printStackTrace();
				return "false";
			}
     
  
  }
    
    public static Set<MultipartFile> getFileSet(HttpServletRequest request) {
        try{
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Set<MultipartFile> fileset = new LinkedHashSet<MultipartFile>();
            for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
                String key = (String) it.next();
                MultipartFile file = multipartRequest.getFile(key);
                if (file.getOriginalFilename().length() > 0) {
                    fileset.add(file);
                }
            }
            return fileset;
        }catch (Exception ex) {
        	ex.printStackTrace();
            return null;
        }
     
    }
 

    public String uploadImgResourceId(String module,String resourceId,
    		HttpServletRequest request,HttpServletResponse response) {
             
    		try{
    			Long userId=this.meberManager.getUserId();
    		    
    	           Set<MultipartFile> files = getFileSet(request);
    	           StringBuffer sb=new StringBuffer();
    	           for (MultipartFile myfile : files) {
    	              
    	                   String fileName = myfile.getOriginalFilename();
    	                  
    	                   String ext = null;
    	                   String imagename = null;
    	                   ext = fileName.substring(fileName.lastIndexOf(".") + 1);
    	                   String uuid=UUID.getUUID();
    	                  
    	                   imagename = uuid + "." + ext; // 构建文件名称
    	                   if (ext != null) {
                               try {
                                   UploadUtils.saveImageFile(myfile, "/images/"+module+"/" + userId,
                                           imagename, ext, 60, true, request);
                                   UploadUtils.saveImageFile(myfile, "/images/"+module+"/" + userId,
                                           imagename, ext, 120, true, request);
                                   UploadUtils.saveImageFile(myfile, "/images/"+module+"/" + userId,
                                           imagename, ext, 200, request);
                                   UploadUtils.saveImageFile(myfile, "/images/"+module+"/" + userId,
                                           imagename, ext, 700, request);
                                   
                                
                                
                               
                                   Imgs img = new Imgs();
                                   img.setImgName(imagename);
                                   
                                   img.setModule(module);
                                   img.setUserId(userId);
                                   
                                    this.imgsService.saveImgs(img);
                                    sb.append(img.getId()).append(",");
                               } catch (Exception e) {

                               }
                           }
    	               }
  
	    		 sb.deleteCharAt(sb.length()-1);
	    	 
	    		
	    		return  sb.toString();
	    	}catch (Exception e) {
				return "";
			}
    		
  }
    
    
    
    
}


