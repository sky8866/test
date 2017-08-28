package com.antiphon.xiaomai.modules.dao.cate.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.cate.CateCommentDao;
import com.antiphon.xiaomai.modules.entity.cate.CateComment;
@Repository
public class CateCommentImpl extends HibernateDaoImpl<CateComment> implements
		CateCommentDao {

}
