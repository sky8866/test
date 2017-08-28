package com.antiphon.xiaomai.modules.service.ticket;

import java.util.Map;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.entity.ticket.TicketIndent;

public interface TicketIndentService {

	public PageView<TicketIndent> findTicketIndentPage(Map<String,String> params);
	
	public String getPriceTotal(Long userId);
	
	public void SaveOrupdateTicketIndent(TicketIndent ticketIndent);
	
	public PageView<TicketIndent> findPageHqlTicketIndent(Map<String,String> params);
}
