package com.antiphon.xiaomai.modules.dao.ticket;

import java.util.List;
import java.util.Map;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.dto.ChoicenessTicketDto;
import com.antiphon.xiaomai.modules.dto.HotTicketDto;
import com.antiphon.xiaomai.modules.dto.TicketHomeDto;
import com.antiphon.xiaomai.modules.entity.ticket.TicketManage;

public interface TicketManageDao extends HibernateDao<TicketManage>{

	/**
	 * 精选人气景点
	 * @return
	 */
	public List<ChoicenessTicketDto> getChoicenessTicketList();
	

	/**
	 * 热门景点
	 * @return
	 */
	public List<HotTicketDto> getHotTicketList(String city,double longitude,double latitude,int pageSize);
	
	
	/**
	 * 全部景点
	 * @return
	 */
	public List<HotTicketDto> getPageTicket(Map<String,String> params);
	
	
	/**
	 * 统计销量
	 * @return
	 */
	public void updateSalesTotal();
	
	/**
	 * 修改状态
	 * @return
	 */
	public void updateStatus(String[] ids,int status);

}
