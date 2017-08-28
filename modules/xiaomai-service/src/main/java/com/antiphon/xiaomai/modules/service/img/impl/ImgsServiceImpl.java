package com.antiphon.xiaomai.modules.service.img.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.antiphon.xiaomai.common.utils.UploadUtils;
import com.antiphon.xiaomai.modules.dao.img.ImgsDao;
import com.antiphon.xiaomai.modules.entity.img.Imgs;
import com.antiphon.xiaomai.modules.service.img.ImgsService;
@Service
public class ImgsServiceImpl implements ImgsService {
	@Autowired private ImgsDao imgsDao;
	@Override
	public Imgs findImgs(Long id) {
		 
		return this.imgsDao.find(id);
	}

	@Override
	public void saveImgs(Imgs r) {
		 this.imgsDao.save(r);
		
	}

	@Override
	public void updateImgs(Imgs r) {
	        this.imgsDao.update(r);
		
	}

	@Override
	public void delImgs(Serializable... entityids) {
		 this.imgsDao.delete(entityids);
		
	}

	@Override
	public Imgs findImgs(Object p, Object v) {
	 
		return this.imgsDao.findProperty(p, v);
	}

	@Override
	public List<Imgs> findImgsList(String imgsId) {
		 
		 String[] simg=imgsId.split(",");
		 List<Imgs> imgs=new ArrayList<Imgs>();
		 for(String s:simg){
			 Imgs img=this.imgsDao.find(Long.parseLong(s));
			 if(img!=null){
				 imgs.add(img);
			 }
		 }
		 
		return imgs;
	}

	@Override
	public List<Imgs> findImgsList(Object p, Object v) {
		return imgsDao.findPropertyList(p, v);
	}

	@Override
	public void delImgsByResourceId(long id) {
		List<Imgs> imgs=imgsDao.findPropertyList("resourceId", id);
		for(Imgs img:imgs){//删除文件
			UploadUtils.deletefile(img.getModule(), img.getUserId(), img.getImgName());
		}
		//删除库表数据
		if(imgs!=null && imgs.size()>0){
			imgsDao.delImgsByResourceId(id);
		}
	}

}
