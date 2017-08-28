package com.antiphon.xiaomai.modules.dao.cate.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.cate.DishDao;
import com.antiphon.xiaomai.modules.entity.cate.Dish;
@Repository
public class DishDaoImpl extends HibernateDaoImpl<Dish> implements DishDao {

}
