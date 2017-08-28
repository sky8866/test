package com.antiphon.xiaomai.modules.dao.cate.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.cate.CateOrderDao;
import com.antiphon.xiaomai.modules.entity.cate.CateOrder;
@Repository
public class CateOrderDaoImpl extends HibernateDaoImpl<CateOrder> implements
		CateOrderDao {

}
