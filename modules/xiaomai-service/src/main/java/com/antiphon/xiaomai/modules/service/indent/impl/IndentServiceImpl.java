package com.antiphon.xiaomai.modules.service.indent.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.common.constant.Constants;
import com.antiphon.xiaomai.modules.dao.custom.CustomIndentDao;
import com.antiphon.xiaomai.modules.dao.indent.IndentDao;
import com.antiphon.xiaomai.modules.dao.ticket.TicketIndentDao;
import com.antiphon.xiaomai.modules.dto.IndentDto;
import com.antiphon.xiaomai.modules.entity.indent.Indent;
import com.antiphon.xiaomai.modules.service.indent.IndentService;
@Service
public class IndentServiceImpl implements IndentService {
	@Autowired IndentDao indentDao;
	
	@Autowired
	private TicketIndentDao ticketIndentDao;
	
	@Autowired
	private CustomIndentDao customIndentDao;
	
	
	
	@Override
	public List<IndentDto> findPageIndent(Long clientId,String status, int pageNo,int pageSize) {
		
		return indentDao.findPageIndent(clientId, status,pageNo,pageSize);
	}
	
	@Override
	public void updateIndentStatus(Long id, int type) {
		String table="";//表名
		if(type==Constants.INDENT_TYPE_CUSTOM){
			table="xm_custom_indent";
			//customIndentDao.updateIndentStatus(id);
		}
		else if(type==Constants.INDENT_TYPE_TICKET){
			table="xm_ticket_indent";
			//ticketIndentDao.updateIndentStatus(id);
		} 
		else if(type==Constants.INDENT_TYPE_CATE){
			table="xm_cate_order";
			//ticketIndentDao.updateIndentStatus(id);
		}
		else if(type==Constants.INDENT_TYPE_HOTEL){
			table="xm_hotel_order";
			//ticketIndentDao.updateIndentStatus(id);
		} 
		indentDao.updateIndentStatus(id, table);
	}

	@Override
	public void saveIndentAll(Indent indent) {
		indentDao.save(indent);
	}

  
}
