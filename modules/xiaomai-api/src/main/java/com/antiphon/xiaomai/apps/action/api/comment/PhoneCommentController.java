package com.antiphon.xiaomai.apps.action.api.comment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
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

import com.antiphon.xiaomai.common.bean.BaseResponseDTO;
import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.common.utils.UUID;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.dto.CommentDto;
import com.antiphon.xiaomai.modules.entity.comment.Comment;
import com.antiphon.xiaomai.modules.entity.img.Imgs;
import com.antiphon.xiaomai.modules.service.comment.CommentService;
import com.antiphon.xiaomai.modules.service.img.ImgsService;

@Controller
@RequestMapping(value = "/termial/comment")
public class PhoneCommentController {

	@Autowired
	private CommentService commentService;
	@Autowired
	ImgsService imgsService;
	/**
	 * 评论分页
	 * 
	 * @param
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "findPageCommentByResourceId", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO findPageCommentByUserId(String resourceId,String type,@RequestParam(value="pageNo",defaultValue="1") String pageNo,@RequestParam(value="pageSize",defaultValue="5") String pageSize,HttpServletResponse response, HttpServletRequest request) {
		Map<String,String> params=new HashMap<String, String>();
		params.put("resourceId", resourceId);
		params.put("type", type);
		params.put("pageNo", pageNo);
		params.put("pageSize", pageSize);
		CommentDto  commentDto=commentService.findPageCommentByParams(params);
		BaseResponseDTO dto = new BaseResponseDTO(1, "成功！",commentDto);
		return dto;
	}
	
	
	/**
	 * 新增评论
	 * 
	 * @param
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "saveComment", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDTO saveComment(Comment comment,HttpServletResponse response, HttpServletRequest request) {
		commentService.saveComment(comment);
		Set<MultipartFile> files = getFileSet(request);
		String module=Constants.IMGS_INDENT;
		Long id=comment.getId();
        for (MultipartFile myfile : files) {
            
            String fileName = myfile.getOriginalFilename();
           
            String ext = null;
            String imagename = null;
            ext = fileName.substring(fileName.lastIndexOf(".") + 1);
            String uuid=UUID.getUUID();
           
            imagename = uuid + "." + ext; // 构建文件名称
            if (ext != null) {
                try {
                    UploadUtils.saveImageFile(myfile, "/images/"+module+"/" + id,
                            imagename, ext, 60, true, request);
                    UploadUtils.saveImageFile(myfile, "/images/"+module+"/" + id,
                            imagename, ext, 120, true, request);
                    UploadUtils.saveImageFile(myfile, "/images/"+module+"/" + id,
                            imagename, ext, 200, request);
                    UploadUtils.saveImageFile(myfile, "/images/"+module+"/" + id,
                            imagename, ext, 700, request);
                 
                    Imgs img = new Imgs();
                    img.setImgName(imagename);
                    img.setModule(module);
                    img.setUserId(id);
                     this.imgsService.saveImgs(img);
                } catch (Exception e) {

                }
            }
        }
        
		BaseResponseDTO dto = new BaseResponseDTO("1", "成功","1");
		return dto;
	}
	
	
    
    private Set<MultipartFile> getFileSet(HttpServletRequest request) {
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
}
