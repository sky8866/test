package com.antiphon.xiaomai.apps.action.web.indent;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.entity.indent.WithdrawalRecord;
import com.antiphon.xiaomai.modules.service.indent.WithdrawalMoneyService;
import com.antiphon.xiaomai.modules.service.indent.WithdrawalRecordService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;

@Controller
@RequestMapping(value = "/admin/indent")
public class WithdrawalRecordController {
	
	private final static String BASE_PATH = "indent/"; 
	@Autowired
	private WithdrawalRecordService withdrawalRecordService;
	@Autowired
	private  WithdrawalMoneyService withdrawalMoneyService;
	@Autowired
	MemberManager memberManager;
	/**
	 * 
	 * @param 
	 * @param 申请提现
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "withdrawalRecordList")
	@ResponseBody
	public Map<String,String> withdrawalRecordList(double money,double totalMoney,HttpServletRequest request) {
		Long userId=memberManager.getUserId();
		//boolean  flag=withdrawalRecordService.getSubmitted(userId);
		String message="申请成功！请耐心等待";
		try{
			WithdrawalRecord withdrawalRecord=new WithdrawalRecord();
			withdrawalRecord.setMoney(money);
			withdrawalRecord.setTotalMoney(totalMoney);
			withdrawalRecord.setUserId(userId);
			withdrawalRecord.setWithdrawalTime(new Date());
			withdrawalRecord.setStatus(1);
			withdrawalRecordService.SaveWithdrawalRecord(withdrawalRecord);
			//修改可提现金额
			withdrawalMoneyService.updateMoneyByUserId(userId, money);
			
		}catch (Exception e) {
			System.out.println("提现失败！");
			message="申请失败！请重新申请，或稍后重试";
		}
		Map<String,String> data=new HashMap<String, String>();
		data.put("message", message);
		return data;
	}
	
	
	/**
	 * 提现记录
	 * @param 
	 * @param 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getPageWithdrawalRecord")
	public String getPageWithdrawalRecord(@RequestParam(value = "pageNo", defaultValue = "1") int  pageNo,HttpServletRequest request) {
		String data="操作成功";
		request.setAttribute("money_r_active", "active");
		request.setAttribute("money_active", "active");
		Long userId=memberManager.getUserId();
		PageView<WithdrawalRecord> pv=null;
		try{
			Map<String,String> params=new HashMap<String, String>();
			params.put("pageNo", pageNo+"");
			params.put("userId", userId+"");
			pv=withdrawalRecordService.findPageWithdrawalRecord(params);
		}catch (Exception e) {
			data="操作失败";
		}
		request.setAttribute("pageView", pv);
		return BASE_PATH+"indent_withdrawal_record";
	}

	
	
	/**
	 * 修改提现状态
	 * @param 
	 * @param 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "updateWithdrawalRecordStatus")
	@ResponseBody
	public Map<String, String> updateWithdrawalRecordStatus(String ids,
			int status, HttpServletRequest request) {
		String msg = "审批成功！";
		try {
			withdrawalRecordService.updateWithdrawalRecordStatus(ids, status);
		} catch (Exception e) {
			System.out.println("提现审核失败！");
			msg = "提现审核失败！";
		}
		Map<String, String> data = new HashMap<String, String>();
		data.put("msg", msg);
		return data;
	}
	
	
	/**
	 * 申请记录--关联订单
	 * @param 
	 * @param 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getPageIndentById")
	public String getPageIndentById(Long id,@RequestParam(value = "pageNo", defaultValue = "1") int  pageNo,HttpServletRequest request) {
		String data="操作成功";
		Long userId=memberManager.getUserId();
		PageView<WithdrawalRecord> pv=null;
		try{
			Map<String,String> params=new HashMap<String, String>();
			params.put("pageNo", "1");
			params.put("pageSize", "10");
			pv=withdrawalRecordService.getPageIndentRecord(params);
		}catch (Exception e) {
			data="操作失败";
		}
		request.setAttribute("pageView", pv);
		return BASE_PATH+"indent_withdrawal_record";
	}
	
}
