package com.antiphon.xiaomai.modules.service.custom.impl;

import java.util.ArrayList;
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
import com.antiphon.xiaomai.modules.dao.custom.CustomIndentDao;
import com.antiphon.xiaomai.modules.dao.indent.IndentDao;
import com.antiphon.xiaomai.modules.entity.custom.CustomIndent;
import com.antiphon.xiaomai.modules.entity.indent.Indent;
import com.antiphon.xiaomai.modules.service.custom.CustomIndentService;
@Service
public class CustomIndentServiceImpl implements CustomIndentService {
	@Autowired 
	private CustomIndentDao customIndentDao;
	@Autowired 
	private IndentDao indentDao;
	@Override
	public PageView<CustomIndent> findPageCustomIndent(int pageNumber,
			Map<String, String> params) {
		PageView<CustomIndent> pageView = new PageView<CustomIndent>(10,pageNumber);
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		Long userId=Long.parseLong(params.get("userId"));
		if(userId!=null){
			filters.add(new PropertyFilter("userId", MatchType.EQ, userId));
		}
		String status=params.get("status");
		if(StringUtils.isNotEmpty(status)){
		Integer istatus=Integer.parseInt(status);
			filters.add(new PropertyFilter("status", MatchType.EQ, istatus));
		}
		pageView.setQueryResult(this.customIndentDao.findPage(pageView, filters));
		return pageView;
	}
	@Override
	public CustomIndent findCustomIndentById(Long id) {
		return customIndentDao.find(id);
	}
	@Override
	public void SaveOrupdateCustomIndent(CustomIndent customIndent) {
		if(customIndent.getId()==null){
			customIndentDao.save(customIndent);
			Indent indent=new Indent();//总订单记录
			indent.setIndentId(customIndent.getId());
			indent.setStatus(1);
			indent.setUserId(customIndent.getUserId());
			indent.setType(Constants.INDENT_TYPE_CUSTOM);
			indentDao.save(indent);
		}else{
			customIndentDao.update(customIndent);
		}
	}
	@Override
	public PageView<CustomIndent> findPageHqlCustomIndent(
			Map<String, String> params) {
		int pageNo=Integer.parseInt(params.get("pageNo"));
		int pageSize=Integer.parseInt(params.get("pageSize"));
		Long userId=Long.parseLong(params.get("userId"));
		
		PageView<CustomIndent> pv=new PageView<CustomIndent>(pageSize,pageNo);
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("chargeTime", MatchType.GE, UtilDate.getMaxMonthOneDate()));
		filters.add(new PropertyFilter("chargeTime", MatchType.LT, UtilDate.getMonthOneDate()));
		filters.add(new PropertyFilter("userId",MatchType.EQ,userId));
		pv.setQueryResult(customIndentDao.findPage(pv, filters));
		return pv;
	}
	@Override
	public String getPriceTotal(Long userId) {
		return customIndentDao.getPriceTotal(userId);
	}
	@Override
	public List<String> getCustomIndent(Long userId) {
		return null;
	}
	


}
