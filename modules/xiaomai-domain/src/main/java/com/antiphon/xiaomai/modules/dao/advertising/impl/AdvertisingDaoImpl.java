package com.antiphon.xiaomai.modules.dao.advertising.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.advertising.AdvertisingDao;
import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.entity.advertising.Advertising;

@Repository
public class AdvertisingDaoImpl extends HibernateDaoImpl<Advertising> implements AdvertisingDao{

}
