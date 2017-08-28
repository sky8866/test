package com.antiphon.xiaomai.apps.action.web.indent;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalMonthRecord;
import com.antiphon.xiaomai.modules.service.indent.WithdrawalMonthRecordService;

@Controller
@RequestMapping(value = "/admin/withdrawalMonth")
public class WithdrawalMonthRecordController {
	private final static String BASE_PATH = "indent/"; 
	@Autowired
	private WithdrawalMonthRecordService withdrawalMonthRecordService;
	
	/**
	 * 每月结算记录
	 * @param 
	 * @param 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getPageWithdrawalMonthRecord")
	public String getPageWithdrawalMonthRecord(@RequestParam(value = "pageNo", defaultValue = "1") int  pageNo,HttpServletRequest request) {
		request.setAttribute("money_m_active", "active");
		request.setAttribute("money_active", "active");
		String data="操作成功";
		try{
			Map<String,String> params=new HashMap<String, String>();
			params.put("userId", "1");
			int pageSize=10;
			PageView<WithdrawalMonthRecord> pv=withdrawalMonthRecordService.getPageMonthRecord(params, pageNo, pageSize);
			request.setAttribute("pageView", pv);
		}catch (Exception e) {
			data="操作失败";
		}
		return BASE_PATH+"indentChargeOffList";
	}
}
