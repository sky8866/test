package com.antiphon.xiaomai.modules.service.ticket.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.common.utils.DistanceUtils;
import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.dao.ticket.TicketManageDao;
import com.antiphon.xiaomai.modules.dto.ChoicenessTicketDto;
import com.antiphon.xiaomai.modules.dto.HotTicketDto;
import com.antiphon.xiaomai.modules.dto.TicketHomeDto;
import com.antiphon.xiaomai.modules.entity.ticket.TicketManage;
import com.antiphon.xiaomai.modules.service.ticket.TicketManageService;


@Service
public class TicketManageServiceImpl implements TicketManageService {

	@Autowired 
	private TicketManageDao ticketManageDao;

	@Override
	public PageView<TicketManage> findTicketManagePage(Map<String, String> params) {
		int pageNo=Integer.parseInt(params.get("pageNo"));
		int pageSize=Integer.parseInt(params.get("pageSize"));
		PageView<TicketManage> pv=new PageView<TicketManage>(pageSize,pageNo);
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("userId", MatchType.EQ, Long.parseLong(params.get("userId"))));
		pv.setOrderby("createTime", "desc");
		pv.setQueryResult(ticketManageDao.findPage(pv, filters));
		return pv;
	}

	@Override
	public TicketManage findTicketManageById(Long id) {
		return ticketManageDao.find(id);
	}

	@Override
	public void saveOrUpdateCustomPlayInfo(TicketManage ticketManage) {
		if(ticketManage.getId()==null){
			ticketManageDao.save(ticketManage);
		}else{
			//修改主表
			ticketManageDao.update(ticketManage);
			//删除关联副表
		}
		
	}

	@Override
	public List<ChoicenessTicketDto> getChoicenessTicketList() {
		return ticketManageDao.getChoicenessTicketList();
	}

	@Override
	public List<HotTicketDto> getHotTicketList(String city,double longitude,double latitude,int pageSize) {
		return ticketManageDao.getHotTicketList(city, longitude, latitude,pageSize);
	}

	@Override
	public List<HotTicketDto> getPageTicket(Map<String, String> params) {
		return ticketManageDao.getPageTicket(params);
	}

	@Override
	public TicketHomeDto getTicketHome(Long id) {
		TicketManage ticketManage =ticketManageDao.find(id);
		TicketHomeDto dto=new TicketHomeDto();
		dto.setId(ticketManage.getId());
		dto.setLoginId(ticketManage.getUserId());
		dto.setTicketName(ticketManage.getTicketName());
		dto.setTicketPrice(ticketManage.getTicketPrice());
		dto.setTicketAddress(ticketManage.getTicketAddress());
		dto.setOpenTime(ticketManage.getOpenTime());
		dto.setReserveDate(ticketManage.getReserveDate());
		dto.setBookings(ticketManage.getBookings());
		dto.setSpecialDateDescription(ticketManage.getSpecialDateDescription());
		dto.setTicketIntroduce(ticketManage.getTicketIntroduce());
		dto.setUsageMode(ticketManage.getUsageMode());
		dto.setLongitude(ticketManage.getLongitude());
		dto.setLatitude(ticketManage.getLatitude());
		return dto;
	}

	@Override
	public void updateStatus(String[] ids,int status) {
		ticketManageDao.updateStatus(ids,status);
	}
	
	
	
	
 }
