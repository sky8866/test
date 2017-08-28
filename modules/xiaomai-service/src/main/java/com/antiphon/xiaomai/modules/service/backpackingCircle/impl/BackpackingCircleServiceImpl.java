package com.antiphon.xiaomai.modules.service.backpackingCircle.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.dao.backpackingCircle.BackpackingCircleDao;
import com.antiphon.xiaomai.modules.entity.backpackingCircle.BackpackingCircle;
import com.antiphon.xiaomai.modules.service.backpackingCircle.BackpackingCircleService;
@Service
public class BackpackingCircleServiceImpl implements BackpackingCircleService {

	@Autowired
	private BackpackingCircleDao backpackingCircleDao;
	@Override
	public void saveBackpackingCircle(BackpackingCircle backpackingCircle) {
		backpackingCircleDao.save(backpackingCircle);
	}

}
