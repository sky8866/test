package com.antiphon.xiaomai.modules.dao.custom.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.custom.CustomLabelDao;
import com.antiphon.xiaomai.modules.entity.custom.CustomLabel;

@Repository
public class CustomLabelDaoImpl extends HibernateDaoImpl<CustomLabel> implements CustomLabelDao{

	@Override
	public void delPkid(Long pkId) {
		Query query=this.em.createQuery("delete CustomLabel c where c.customId="+pkId);
		query.executeUpdate();
	}

	@Override
	public List<String> getLabel(Long customId) {
		Query query=this.em.createNativeQuery("select name from xm_custom_label where custom_id="+customId);
		List<String> list=query.getResultList();
		List<String> rs=null;
		if(list!=null && list.size()>0){
			rs=new ArrayList<String>();
			for(String data:list){
				rs.add(data);
			}
		}
		return rs;
	}



}
