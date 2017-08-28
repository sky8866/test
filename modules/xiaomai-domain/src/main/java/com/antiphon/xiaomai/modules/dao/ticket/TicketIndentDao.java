package com.antiphon.xiaomai.modules.dao.ticket;

import java.util.Map;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.entity.ticket.TicketIndent;

public interface TicketIndentDao extends HibernateDao<TicketIndent>{
	public String getPriceTotal(Long userId);
	
	public String findPageTicketIndentByUserId(Long userId);
	
	public PageView<TicketIndent> findPageSqlTicketIndent(Map<String, String> params);
	
	public int updateIndentStatus(Long id);
}
