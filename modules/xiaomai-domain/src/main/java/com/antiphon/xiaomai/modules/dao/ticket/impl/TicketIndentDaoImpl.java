package com.antiphon.xiaomai.modules.dao.ticket.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.ticket.TicketIndentDao;
import com.antiphon.xiaomai.modules.dto.CustomInfoDto;
import com.antiphon.xiaomai.modules.entity.ticket.TicketIndent;
@Repository
public class TicketIndentDaoImpl  extends HibernateDaoImpl<TicketIndent>  implements TicketIndentDao  {

	@Override
	public String getPriceTotal(Long userId) {
		StringBuffer sql=new StringBuffer();
		sql.append("select sum(total_money) from xm_ticket_indent where ");
		sql.append(" date_format(charge_time,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m')");
		sql.append(" and charge_Off='已核销'");
		sql.append(" and user_id="+userId);
		Query query=this.em.createNativeQuery(sql.toString());
		Object data=query.getSingleResult();
		return data==null?"0":data.toString();
	}

	@Override
	public String findPageTicketIndentByUserId(Long userId) {
		
		
		return null;
	}

	@Override
	public PageView<TicketIndent> findPageSqlTicketIndent(Map<String, String> params) {
		int pageNo=Integer.parseInt(params.get("pageNo"));
		int pageSize=Integer.parseInt(params.get("pageSize"));
		String userId=params.get("userId");
		StringBuffer sql=new StringBuffer();
		sql.append("select  from xm_ticket_indent where ");
		sql.append(" date_format(charge_time,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m')");
		sql.append(" and user_id="+userId);
		Query query=this.em.createNativeQuery(sql.toString());
		query.setFirstResult(pageSize*(pageNo-1));
		query.setMaxResults(pageSize);
		List list=query.getResultList();
		for(int i=0;i<list.size();i++){
			Object[] obj=(Object[]) list.get(i);
			
		}
		return null;
	}

	@Override
	public int updateIndentStatus(Long id) {
		StringBuffer sql=new StringBuffer();
		sql.append(" update xm_ticket_indent set STATUS='已取消' where id="+id);
		Query query=this.em.createNamedQuery(sql.toString());
		int data=query.executeUpdate();
		return data;
	}

	
}
