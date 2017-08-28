package com.antiphon.xiaomai.modules.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.user.VerificationcodeDao;
import com.antiphon.xiaomai.modules.entity.user.Verificationcode;
@Repository
public class VerificationcodeDaoImpl extends HibernateDaoImpl<Verificationcode>
		implements VerificationcodeDao {

}
