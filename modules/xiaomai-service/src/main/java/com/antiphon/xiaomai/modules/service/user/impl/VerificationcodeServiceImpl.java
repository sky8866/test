package com.antiphon.xiaomai.modules.service.user.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.dao.user.VerificationcodeDao;
import com.antiphon.xiaomai.modules.entity.user.Verificationcode;
import com.antiphon.xiaomai.modules.service.user.VerificationcodeService;
@Service
public class VerificationcodeServiceImpl implements VerificationcodeService {
    @Autowired private VerificationcodeDao codeDao;
	@Override
	public Verificationcode findVerificationcode(Long id) {
		 
		return this.codeDao.find(id);
	}

	@Override
	public void saveVerificationcode(Verificationcode r) {
		 this.codeDao.save(r);
		
	}

	@Override
	public void updateVerificationcode(Verificationcode r) {
	        this.codeDao.update(r);
		
	}

	@Override
	public void delVerificationcode(Serializable... entityids) {
		 this.codeDao.delete(entityids);
		
	}

	@Override
	public Verificationcode findVerificationcode(Object p, Object v) {
	 
		return this.codeDao.findProperty(p, v);
	}

	@Override
	public QueryResult<Verificationcode> findPage(PageView<Verificationcode> pv, List<PropertyFilter> filters) {
		 
		return this.codeDao.findPage(pv, filters);
	}

	@Override
	public String  findVerificationcodeToMobile(String mobile,String code) {
	      Verificationcode verification=findVerificationcode("mobile", mobile);
	      if(verification!=null){
	    	  String type=verification.getType();
	    	  if("1".equals(type)){
	    		  code=verification.getCode();
	    		  
	    	  }else{
	    		  verification.setCode(code);
	    		  verification.setState("1");
	    		  this.codeDao.update(verification); 
	    	  }
	    	  
	    	  
	      }else{
	    	  verification =new Verificationcode();
	    	  verification.setCode(code);
	    	  verification.setType("0");
	    	  verification.setMobile(mobile);
	    	  verification.setState("1");
	    	  this.codeDao.save(verification);
	    	  
	      }
		return code;
	}

}
