package com.antiphon.xiaomai.modules.dao.indent.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antiphon.xiaomai.modules.dao.base.impl.HibernateDaoImpl;
import com.antiphon.xiaomai.modules.dao.indent.WithdrawalRecordDao;
import com.antiphon.xiaomai.modules.dto.IndentRecordDto;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalRecord;
@Repository
public class WithdrawalRecordDaoImpl extends HibernateDaoImpl<WithdrawalRecord> implements WithdrawalRecordDao {

	@Override
	public List<IndentRecordDto> getPageIndentRecord(Map<String, String> params) {
		int pageNo=Integer.parseInt(params.get("pageNo"));
		int pageSize=Integer.parseInt(params.get("pageSize"));
		StringBuffer sql=new StringBuffer();
		sql.append("select b.departure_time departureTime,number_of_people numberOfPeople,total_prices totalPrices,client_name clientName from xm_withdrawal_record_indent a ");
		sql.append(" left join  xm_custom_indent b on a.indent_id=b.id where a.record_id=35");
		Query query=this.em.createNativeQuery(sql.toString());
		query.setFirstResult(pageSize*(pageNo-1));
		query.setMaxResults(pageSize);
		System.out.println(query.getResultList()==null);
		List<Object> list=query.getResultList();
		List<IndentRecordDto> rs=new ArrayList<IndentRecordDto>();
		IndentRecordDto dto=null;
		for(Object obj:list){
			Object[] data=(Object[]) obj;
			dto.setDepartureTime(data[0].toString());
			dto.setNumberOfPeople(data[1].toString());
			dto.setTotalPrices(data[2].toString());
			dto.setClientName(data[3].toString());
			rs.add(dto);
		}
		return rs;
	}

	@Override
	public void updateWithdrawalRecordStatus(String ids, int status) {
		StringBuffer sql=new StringBuffer();
		sql.append("update xm_withdrawal_record set status=").append(status).append(" where id in(").append(ids).append(")");
		Query query=this.em.createNativeQuery(sql.toString());
		query.executeUpdate();
	}

	
}
