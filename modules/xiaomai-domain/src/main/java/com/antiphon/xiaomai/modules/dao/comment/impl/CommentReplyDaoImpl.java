package com.antiphon.xiaomai.modules.dao.comment.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.comment.CommentReplyDao;
import com.antiphon.xiaomai.modules.entity.comment.CommentReply;
@Repository
public class CommentReplyDaoImpl extends HibernateDaoImpl<CommentReply> implements CommentReplyDao {

}
