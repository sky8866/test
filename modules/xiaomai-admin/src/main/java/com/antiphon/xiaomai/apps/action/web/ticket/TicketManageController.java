package com.antiphon.xiaomai.apps.action.web.ticket;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.entity.ticket.TicketManage;
import com.antiphon.xiaomai.modules.service.ticket.TicketManageService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;


@Controller
@RequestMapping(value = "/admin/ticket")
public class TicketManageController {
	
	private final static String BASE_PATH = "ticket/"; 

	@Autowired
	private TicketManageService ticketManageService;
	@Autowired
	MemberManager memberManager;
	/**
	 * 门票列表
	 * @param status
	 * @param pageNumber
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "ticketList")
	public String ticketList(String status,@RequestParam(value = "pageNo", defaultValue = "1") int  pageNo,HttpServletRequest request) {
		Map<String,String> params=new HashMap<String, String>();
		params.put("userId", memberManager.getUserId()+"");
		params.put("pageNo", pageNo+"");
		params.put("pageSize","10");
		PageView<TicketManage> pageView=ticketManageService.findTicketManagePage(params);
		request.setAttribute("pageView",pageView); 
		request.setAttribute("ticketStatus",Constants.TICKET_STATUS); 
		request.setAttribute("ticket_li", "active");
		request.setAttribute("ticket_active", "active");
		return BASE_PATH+"ticketList";
	}
	
	
	@RequestMapping(value = "skipSaveOrUpdateTicket")
	public String skipSaveOrUpdateTicket(Long id,HttpServletRequest request) {
		if(id!=null){
			TicketManage ticketManage=ticketManageService.findTicketManageById(id);
			request.setAttribute("data", ticketManage);
			}
		request.setAttribute("ticketStatus", Constants.TICKET_STATUS);
		request.setAttribute("ticketType", Constants.TICKET_TYPE);
		request.setAttribute("ticket_li", "active");
		request.setAttribute("ticket_active", "active");
		return BASE_PATH+"addTicket";
	}
	
	
	@RequestMapping(value = "saveOrUpdateTicket")
	public String saveOrUpdateTicket(TicketManage ticketManage,MultipartFile filename,HttpServletRequest request,HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			if(filename!=null &&filename.getSize()>0){
				String paht="/images/ticket/";//存放路径
				String sqlpaht=UploadUtils.saveFile(filename, request,paht,ticketManage.getTicketPhotoUrl());//封面
				//图片上传
				ticketManage.setTicketPhotoUrl(sqlpaht);
			}
			
			ticketManage.setUserId(memberManager.getUserId());
			ticketManageService.saveOrUpdateCustomPlayInfo(ticketManage);
			redirectAttributes.addFlashAttribute("message",  "提交成功，等待审核！");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message",  "提交失败！");
		}
		return  "redirect:/admin/ticket/skipSaveOrUpdateTicket?id="+ticketManage.getId();
	}
	
	@RequestMapping(value = "delTicket")
	public void delTicket(Long id,HttpServletRequest request,HttpServletResponse response) {
		try {
			response.sendRedirect(request.getContextPath()+"/admin/custom/play/playList");
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "updateStatus")
	public String updateStatus(@RequestParam(value = "status", defaultValue = "1") int  status,HttpServletRequest request,HttpServletResponse response) {
		try {
			String[] ids=request.getParameterValues("entryId");
			ticketManageService.updateStatus(ids,status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  "redirect:/admin/ticket/ticketList";
	}
	

}
