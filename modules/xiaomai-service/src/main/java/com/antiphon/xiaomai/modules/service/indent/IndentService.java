package com.antiphon.xiaomai.modules.service.indent;

import java.util.List;

import com.antiphon.xiaomai.modules.dto.IndentDto;
import com.antiphon.xiaomai.modules.entity.indent.Indent;

public interface IndentService {

	 public List<IndentDto> findPageIndent(Long clientId,String status, int pageNo,int PageSize);
	 
	 public void updateIndentStatus(Long id,int type);
	 
	 public void saveIndentAll(Indent indent);
}
