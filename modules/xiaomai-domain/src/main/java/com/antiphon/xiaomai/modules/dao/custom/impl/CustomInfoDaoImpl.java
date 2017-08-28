package com.antiphon.xiaomai.modules.dao.custom.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.ptg.IntPtg;
import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.custom.CustomInfoDao;
import com.antiphon.xiaomai.modules.dto.CustomInfoDto;
import com.antiphon.xiaomai.modules.entity.custom.CustomInfo;

@Repository
public class CustomInfoDaoImpl extends HibernateDaoImpl<CustomInfo> implements CustomInfoDao {
	protected static final Logger log = Logger.getLogger(CustomInfoDaoImpl.class);
	
	@Override
	public List<CustomInfo> findCustomInfo(Map<String, String> params) {
		return null;
	}

	@Override
	public List<CustomInfoDto> getCustomInfoHomeByParams(Map<String, String> params) {
		StringBuffer hql=new StringBuffer("select a.user_id,b.id customId,b.nickname,a.play_city,b.picture_link,b.serve_best,b.indent_total,introduce_myself from"); //,d.name
		hql.append(" (select user_id,play_city from xm_custom_play_info WHERE 1=1  "); 
		String playType=params.get("playType");
		String playCity=params.get("playCity");
		String synthesize=params.get("synthesize");
		String sex=params.get("sex");
		int pageNo=Integer.parseInt(params.get("pageNo"));
		int pageSize=Integer.parseInt(params.get("pageSize"));
		if(StringUtils.isNotEmpty(playType)){//玩法
			hql.append(" and play_type='"+playType+"'");
		}
		if(StringUtils.isNotEmpty(playCity)){//城市
			hql.append(" and play_city='"+playCity+"'");
		}
		hql.append(" group by user_id");
		if(StringUtils.isNotEmpty(synthesize)){
		if(synthesize.equals("3")){
			hql.append(" order by play_price desc");	
		}else if(synthesize.equals("4")){
			hql.append(" order by play_price");	
		}
		}
		hql.append(" ) a ");
		hql.append(" LEFT JOIN xm_custom_info b on a.user_id=b.user_id"); 
		if(StringUtils.isNotEmpty(sex)){
			hql.append(" where b.sex='"+sex+"'"); 
		}
		if(StringUtils.isNotEmpty(synthesize)){
			if(synthesize.equals("1")){//评价
				hql.append(" ORDER BY serve_best desc");
			}else if(synthesize.equals("2")){//销量
				hql.append(" ORDER BY indent_total desc");
			}
		}
		Query  query=this.em.createNativeQuery(hql.toString());
		query.setFirstResult(pageSize*(pageNo-1));
		query.setMaxResults(pageSize);
		List list=query.getResultList();
		List<CustomInfoDto> dtoList=new ArrayList<CustomInfoDto>();
		CustomInfoDto dto=null;
		for(int i=0;i<list.size();i++){
			Object[] obj=(Object[]) list.get(i);
				dto=new CustomInfoDto();
			//	dto.setUserId(Long.parseLong(obj[0].toString()));
				dto.setCustomId(Long.parseLong(obj[1].toString()));
				dto.setName(obj[2].toString());
				dto.setInhabitCity(obj[3]!=null?obj[3].toString():"");
				dto.setCustomPhoto(obj[4]!=null?obj[4].toString():"");
				dto.setGrade(obj[5]!=null?Double.parseDouble(obj[5].toString()):0);//评分
				dto.setVOL(obj[6]!=null?obj[6].toString():"");
				dto.setIntroduceMyself(obj[7]!=null?obj[7].toString():"");
				dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public void updateCustomInfo() {
		StringBuffer sql=new StringBuffer();
		sql.append("update xm_custom_info a ,");
		sql.append(" (select count(*) as count,b.user_id from xm_custom_indent b group by b.user_id) b,");
		sql.append(" (select avg(c.score) as avgscore,count(*) as total,c.user_id from xm_comment c group by c.user_id) c");
		sql.append(" set a.indent_total=b.count,a.serve_best=c.avgscore,a.comment_total=c.total where a.user_id=b.user_id and a.user_id=c.user_id");
		try{
		Query query=this.em.createNativeQuery(sql.toString());
		int count=query.executeUpdate();
		System.out.println("定制师数据统计执行成功！条数："+count);
		}catch (Exception e) {
			System.out.println("定制师数据统计执行失败！");
		}
	}

	@Override
	public void saveOrUpdateCustomInfoAppoint(CustomInfo customInfo) {
		StringBuffer sql=new StringBuffer();
		sql.append("update xm_custom_info set name="+customInfo.getName());
		sql.append(",sex="+customInfo.getSex());
		sql.append(",birthday="+customInfo.getBirthday());
		sql.append(",email="+customInfo.getEmail());
		sql.append(",weixin="+customInfo.getWeixin());
		sql.append(",city="+customInfo.getCity());
		sql.append(",inhabit_time="+customInfo.getInhabitTime());
		sql.append(",wizard_type="+customInfo.getWizardType());
		sql.append(",introduce_myself="+customInfo.getIntroduceMyself());
		sql.append(" where id="+customInfo.getId());
		Query query=this.em.createNativeQuery(sql.toString());
		query.executeUpdate();
	}

}
