package com.antiphon.xiaomai.modules.dao.indent;

import java.util.List;

import com.antiphon.xiaomai.modules.dao.base.HibernateDao;
import com.antiphon.xiaomai.modules.dto.IndentDto;
import com.antiphon.xiaomai.modules.entity.indent.Indent;

public interface IndentDao extends HibernateDao<Indent> {

	public List<IndentDto> findPageIndent(Long clientId,String status,int pageNo,int pageSize);
	
	public int updateIndentStatus(Long id,String table);
	
}
