package com.antiphon.xiaomai.apps.action.web.advertising;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.antiphon.xiaomai.apps.action.web.img.ImgAjaxController;
import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.common.utils.UUID;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.entity.advertising.Advertising;
import com.antiphon.xiaomai.modules.entity.img.Imgs;
import com.antiphon.xiaomai.modules.service.advertising.AdvertisingService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;

@Controller
@RequestMapping(value = "/admin/advertising")
public class AdvertisingController {
	private final static String BASE_PATH = "advertising/"; 
	@Autowired
	private AdvertisingService advertisingService;
	@Autowired
	private ImgsService imgsService;
	
	@Autowired
	private MemberManager memberManager;
	
	@RequestMapping(value = "list")
	public String list(@RequestParam(value="pageNo",defaultValue="1")int pageNo,HttpServletRequest request) {
		 
		 request.setAttribute("advertising_active", "active");
		 request.setAttribute("advertising_tab", "active");
		PageView<Advertising> pageView=advertisingService.getPageAdvertising(pageNo,Constants.PAGE_SIZE_PC,null);
		request.setAttribute("pageView", pageView);
		request.setAttribute("sort",Constants.ADVERTISING_SORT); 
		request.setAttribute("type",Constants.ADVERTISING_TYPE); 
		return BASE_PATH+"list";
	}
	
	/**
	 * 跳转新增或修改页面
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "skipSaveOrUpdateAdvertising")
	public String skipSaveOrUpdatePlay(Long id,HttpServletRequest request) {
		request.setAttribute("advertising_active", "active");
		request.setAttribute("advertising_tab", "active");
		if(id!=null){
			Advertising advertising =advertisingService.getAdvertisingByUserId(id);
			List<Imgs>  imgs=imgsService.findImgsList("resourceId",advertising.getId());
			advertising.setImgs(imgs);
			request.setAttribute("data",advertising); 
		}
		request.setAttribute("sort",Constants.ADVERTISING_SORT); 
		request.setAttribute("type",Constants.ADVERTISING_TYPE); 
		return BASE_PATH+"addAdvertising";
	}
	
	/**
	 * 新增或修改
	 * @param customPlayInfo
	 * @param MultipartFile filename,
	 * @param request
	 * @param response 
	 */
	@RequestMapping(value = "saveOrUpdateAdvertising")
	public String saveOrUpdateAdvertising(Advertising advertising,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) {
		try {
			advertising.setUserId(memberManager.getUserId());
			advertising=advertisingService.saveOrUpdateAdvertising(advertising);
			redirectAttributes.addFlashAttribute("message","保存成功");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message","保存失败");
		}
		return "redirect:/admin/advertising/skipSaveOrUpdateAdvertising?id="+advertising.getId();
	}
	
	
	/**
	 * 异步新增或修改图片
	 * @param customPlayInfo
	 * @param MultipartFile filename,
	 * @param request
	 * @param response 
	 */
	@RequestMapping(value = "saveOrUpdateImg")
	@ResponseBody
	public String saveOrUpdateImg(Long id,HttpServletRequest request,HttpServletResponse response) {
		try {
			if(id==null){
				Advertising advertising=new Advertising();
				advertising=advertisingService.saveOrUpdateAdvertising(advertising);
				id=advertising.getId();
				uploadImgResourceId("advertsing",advertising.getId(),request);
			}else{
				uploadImgResourceId("advertsing",id,request);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return id+"";
	}
	
	
	/**
	 * 删除
	 * @param customPlayInfo
	 * @param MultipartFile filename,
	 * @param request
	 * @param response 
	 */
	@RequestMapping(value = "deleteAdvertising")
	public String deleteAdvertising(Long id,HttpServletRequest request,HttpServletResponse response) {
		try {
			advertisingService.deleteAdvertising(id);
			imgsService.delImgsByResourceId(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/advertising/list";
	}
	
	
	
	
	 public void uploadImgResourceId(String module,Long resourceId,
	    		HttpServletRequest request) {
	    		try{
	    		    String imagename = null;
	    			Long userId=this.memberManager.getUserId();
	    		    
	    	           Set<MultipartFile> files = ImgAjaxController.getFileSet(request);
	    	           for (MultipartFile myfile : files) {
	    	              
	    	                   String fileName = myfile.getOriginalFilename();
	    	                  
	    	                   String ext = null;
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
	                                   img.setResourceId(resourceId);
	                                   this.imgsService.saveImgs(img);
	                               } catch (Exception e) {

	                               }
	                           }
	    	               }
	  
		    		
		    	}catch (Exception e) {
				}
	    		
	    		
	  }
	 
	
	
}
