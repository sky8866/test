package com.antiphon.xiaomai.modules.service.cate.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.MatchType;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult; 
import com.antiphon.xiaomai.modules.dao.cate.CategoryDao;
import com.antiphon.xiaomai.modules.entity.cate.Category; 
import com.antiphon.xiaomai.modules.service.cate.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	  @Autowired private CategoryDao categoryDao;
		@Override
		public Category findCategory(Long id) {
			 
			return this.categoryDao.find(id);
		}

		@Override
		public void saveCategory(Category r) {
			 this.categoryDao.save(r);
			
		}

		@Override
		public void updateCategory(Category r) {
		        this.categoryDao.update(r);
			
		}

		@Override
		public void delCategory(Serializable... entityids) {
			 this.categoryDao.delete(entityids);
			
		}

		@Override
		public Category findCategory(Object p, Object v) {
		 
			return this.categoryDao.findProperty(p, v);
		}

		@Override
		public QueryResult<Category> findPage(PageView<Category> pv, List<PropertyFilter> filters) {
			 
			return this.categoryDao.findPage(pv, filters);
		}

		@Override
		public List<Category> findCategorys() {
			 PageView<Category> pv=new PageView<Category>();
			 List<PropertyFilter> filters = new ArrayList<PropertyFilter>(); 
		      filters.add(new PropertyFilter("parent", MatchType.NULL, null));
              List<Category> gorys=this.findPage(pv, filters).getResultlist();
			return gorys;
		}

}
