package com.antiphon.xiaomai.modules.service.ticket.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.common.utils.UtilDate;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.dao.indent.IndentDao;
import com.antiphon.xiaomai.modules.dao.ticket.TicketIndentDao;
import com.antiphon.xiaomai.modules.entity.indent.Indent;
import com.antiphon.xiaomai.modules.entity.ticket.TicketIndent;
import com.antiphon.xiaomai.modules.service.ticket.TicketIndentService;

@Service
public class TicketIndentServiceImpl implements TicketIndentService {
	@Autowired 
	private TicketIndentDao ticketIndentDao;
	@Autowired 
	private IndentDao indentDao;
	@Override
	public PageView<TicketIndent> findTicketIndentPage(Map<String, String> params) {
		int pageNo=Integer.parseInt(params.get("pageNo"));
		int pageSize=Integer.parseInt(params.get("pageSize"));
		String chargeOff=params.get("chargeOff");
		String updateTime=params.get("updateTime");
		PageView<TicketIndent> pv=new PageView<TicketIndent>(pageSize,pageNo);
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
/*		if(StringUtils.isNotEmpty(chargeOff)){
			filters.add(new PropertyFilter("chargeOff", MatchType.EQ, chargeOff));
		}*/
	/*	if(StringUtils.isNotEmpty(updateTime)){
			filters.add(new PropertyFilter("updateTime", MatchType.LT, new Date()));
		}*/
		pv.setOrderby("updateTime", "desc");
		pv.setQueryResult(ticketIndentDao.findPage(pv, filters));
		return pv;
	}
	@Override
	public String getPriceTotal(Long userId) {
		return ticketIndentDao.getPriceTotal(userId);
	}
	@Override
	public void SaveOrupdateTicketIndent(TicketIndent ticketIndent) {
		ticketIndentDao.save(ticketIndent);
		Indent indent=new Indent();//总订单记录
		indent.setIndentId(ticketIndent.getId());
		indent.setStatus(1);
		indent.setUserId(ticketIndent.getUserId());
		indent.setType(Constants.INDENT_TYPE_TICKET);
		indentDao.save(indent);
	}
	@Override
	public PageView<TicketIndent> findPageHqlTicketIndent(Map<String, String> params) {
		int pageNo=Integer.parseInt(params.get("pageNo"));
		int pageSize=Integer.parseInt(params.get("pageSize"));
		Long userId=Long.parseLong(params.get("userId"));
		
		PageView<TicketIndent> pv=new PageView<TicketIndent>(pageSize,pageNo);
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("chargeTime", MatchType.GE, UtilDate.getMaxMonthOneDate()));
		filters.add(new PropertyFilter("chargeTime", MatchType.LT, UtilDate.getMonthOneDate()));
		filters.add(new PropertyFilter("userId",MatchType.EQ,userId));
		filters.add(new PropertyFilter("chargeOff",MatchType.EQ,"已核销"));
		pv.setQueryResult(ticketIndentDao.findPage(pv, filters));
		return pv;
	}

}
