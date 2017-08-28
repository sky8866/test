package com.antiphon.xiaomai.modules.dao.custom.impl;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.custom.CustomPhotoDao;
import com.antiphon.xiaomai.modules.entity.custom.CustomPhoto;
@Repository
public class CustomPhotoDaoImpl extends HibernateDaoImpl<CustomPhoto> implements CustomPhotoDao{

}
