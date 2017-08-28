package com.antiphon.xiaomai.modules.dao.img.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.img.ImgsDao;
import com.antiphon.xiaomai.modules.entity.img.Imgs;
@Repository
public class ImgsDaoImpl extends HibernateDaoImpl<Imgs> implements ImgsDao {

	@Override
	public List<String> getImgsUrl(String resourceId) {
		Query query=this.em.createNativeQuery("select img_name from xm_imgs where resource_id="+resourceId);
		List<String> list=query.getResultList();
		List<String> data=null;
		if(list!=null &&list.size()>0){
			data=new ArrayList<String>();
			for(String o:list){
				data.add(o);
			}
		}
		return data;
	}

	@Override
	public void delImgsByResourceId(Long resourceId) {
		Query query=this.em.createNativeQuery("delete from xm_imgs where resource_id="+resourceId);
		query.executeUpdate();
	}


}
