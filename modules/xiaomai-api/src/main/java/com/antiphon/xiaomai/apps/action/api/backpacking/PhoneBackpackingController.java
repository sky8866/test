package com.antiphon.xiaomai.apps.action.api.backpacking;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.antiphon.xiaomai.apps.action.api.user.BaseController;
import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.common.utils.UUID;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.dto.BackpackingListDto;
import com.antiphon.xiaomai.modules.entity.backpacking.Backpacking;
import com.antiphon.xiaomai.modules.entity.img.Imgs;
import com.antiphon.xiaomai.modules.service.backpacking.BackpackingService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;

@Controller
@RequestMapping(value = "/termial/backpacking")
public class PhoneBackpackingController extends BaseController {
	@Autowired
	private BackpackingService backpackingService;
	
	@Autowired
	ImgsService imgsService;
	
	/**
	 * 发布约伴
	 */
	@RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO save(@Valid Backpacking backpacking,HttpServletRequest request) throws Exception{
		backpackingService.saveBackpacking(backpacking);
		String module=Constants.IMGS_BACKPACKING;
		Long userId=backpacking.getUserId();
		
		getFileSet(request,module,userId,backpacking.getId());// 多个file上传
		BaseResponseDTO dto=new  BaseResponseDTO("1","成功！");
    	return dto; 
    }
	
	
	/**
	 * 列表
	 */
	@RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO list(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="5")int pageSize,String type,String sex,String city,String longitude,String latitude,String near,HttpServletRequest request) throws Exception{
		Map<String,String> params=new HashMap<String,String>();
		params.put("type", type);
		params.put("city", city);
		params.put("sex", sex);
		params.put("near", near);
		params.put("longitude",longitude);
		params.put("latitude", latitude);
		List<BackpackingListDto> data=backpackingService.findPageList(pageNo, pageSize, params);
		BaseResponseDTO dto=new  BaseResponseDTO("1","成功！",data);
    	return dto; 
    }
	
	/**
	 * 我感兴趣累加
	 */
	@RequestMapping(value = "interest",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO interest(Long id,HttpServletRequest request) throws Exception{
		backpackingService.addCount(id);
    	return new  BaseResponseDTO("1","成功！","1"); 
    }
	
    /**
     * 多个file上传
     * @param request
     * @return
     */
    private  void getFileSet(HttpServletRequest request,String module,Long userId,Long resourceId) {
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
                        this.imgsService.saveImgs(img);
                }
       
            }
            
            
        }catch (Exception ex) {
        	ex.printStackTrace();
        }
     
    }
    
    
    
    
}
