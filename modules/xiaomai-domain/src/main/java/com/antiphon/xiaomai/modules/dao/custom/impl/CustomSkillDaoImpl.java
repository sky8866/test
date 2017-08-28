package com.antiphon.xiaomai.modules.dao.custom.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.custom.CustomSkillDao;
import com.antiphon.xiaomai.modules.entity.custom.CustomSkill;
@Repository
public class CustomSkillDaoImpl extends HibernateDaoImpl<CustomSkill> implements CustomSkillDao{

}
