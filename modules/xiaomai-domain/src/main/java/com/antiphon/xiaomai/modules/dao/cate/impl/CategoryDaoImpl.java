package com.antiphon.xiaomai.modules.dao.cate.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.cate.CategoryDao;
import com.antiphon.xiaomai.modules.entity.cate.Category;
@Repository
public class CategoryDaoImpl extends HibernateDaoImpl<Category> implements
		CategoryDao {

}
