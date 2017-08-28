package com.antiphon.xiaomai.modules.service.ticket;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.dto.ChoicenessTicketDto;
import com.antiphon.xiaomai.modules.dto.HotTicketDto;
import com.antiphon.xiaomai.modules.dto.TicketHomeDto;
import com.antiphon.xiaomai.modules.entity.ticket.TicketManage;

public interface TicketManageService {

	public PageView<TicketManage> findTicketManagePage(Map<String,String> params);
	
	public TicketManage findTicketManageById(Long id);
	
	public void saveOrUpdateCustomPlayInfo(TicketManage ticketManage);
	
	public List<ChoicenessTicketDto> getChoicenessTicketList();
	
	public List<HotTicketDto> getHotTicketList(String city,double longitude,double latitude,int pageSize);
	
	public List<HotTicketDto> getPageTicket(Map<String,String> params);
	
	public TicketHomeDto getTicketHome(Long id);
	
	public void updateStatus(String[] ids,int status);
}
