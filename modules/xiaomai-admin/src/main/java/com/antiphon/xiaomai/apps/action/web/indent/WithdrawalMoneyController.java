package com.antiphon.xiaomai.apps.action.web.indent;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antiphon.xiaomai.modules.entity.indent.WithdrawalMoney;
import com.antiphon.xiaomai.modules.service.indent.WithdrawalMoneyService;
import com.antiphon.xiaomai.modules.service.user.MemberManager;

@Controller
@RequestMapping(value = "/admin/withdrawalMoney")
public class WithdrawalMoneyController {
	private final static String BASE_PATH = "indent/"; 
	
	@Autowired
	private WithdrawalMoneyService withdrawalMoneyService;
	@Autowired
	private MemberManager memberManager;
	
	/**
	 * 可提金额
	 * @param 
	 * @param 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getWithdrawalMoney")
	@ResponseBody
	public WithdrawalMoney getWithdrawalMoney(HttpServletRequest request) {
		try{
			WithdrawalMoney data =withdrawalMoneyService.getWithdrawalMoneyByUserId(memberManager.getUserId());
			request.setAttribute("data", data);
			return data;
		}catch (Exception e) {
			return null;
		}
		
	}
	
	
}
