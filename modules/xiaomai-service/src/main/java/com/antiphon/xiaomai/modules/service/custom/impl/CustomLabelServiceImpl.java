package com.antiphon.xiaomai.modules.service.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.dao.custom.CustomLabelDao;
import com.antiphon.xiaomai.modules.entity.custom.CustomLabel;
import com.antiphon.xiaomai.modules.service.custom.CustomLabelService;

@Service
public class CustomLabelServiceImpl implements  CustomLabelService{

	 @Autowired 
	 private CustomLabelDao customLabelDao;

	@Override
	public List<CustomLabel> getCustomLabelList(Long id) {
		return customLabelDao.findPropertyList("userId", id);
	}

	@Override
	public void saveOrUpdateCustomLabel(Long id, String[] label) {
		customLabelDao.delPkid(id);
		CustomLabel customLabel=null;
		for(String data:label){
			customLabel=new CustomLabel();
			customLabel.setCustomId(id);
			customLabel.setName(data);
			customLabel.setUserId(id);
			customLabelDao.save(customLabel);
		}
	}

}
