package com.antiphon.xiaomai.app.action.quartz;

import org.springframework.beans.factory.annotation.Autowired;

import com.antiphon.xiaomai.modules.dao.custom.CustomInfoDao;
import com.antiphon.xiaomai.modules.dao.ticket.TicketManageDao;



public class SynthesizeTotal {
	@Autowired
	private CustomInfoDao customInfoDao;
	
	@Autowired
	private TicketManageDao ticketManageDao;
	
	/**
	 * 统计定制师的销量评分，评论总条数
	 */
	public void statisticsCustomInfoTotal() {
		customInfoDao.updateCustomInfo();
	}

	/**
	 * 门票销量，总金额统计
	 */
	public void ticketTotal() {
		ticketManageDao.updateSalesTotal();
	}
	
	
	/**
	 *  每月6号结清上月销售额
	 */
	public void lastMonthMoneyTotal() {
		
	}
	
		 
}
