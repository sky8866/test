package com.antiphon.xiaomai.apps.fileUploadUtils;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.antiphon.xiaomai.common.utils.SpringBeanLocator;
import com.antiphon.xiaomai.common.utils.UUID;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.entity.img.Imgs;
import com.antiphon.xiaomai.modules.service.img.impl.ImgsServiceImpl;

public class FileSetUtils {
	
	 /**
     * 多个file上传
     * @param request
     * @return
     */
    public static void getFileSet(HttpServletRequest request,String module,Long userId,Long resourceId) {
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
