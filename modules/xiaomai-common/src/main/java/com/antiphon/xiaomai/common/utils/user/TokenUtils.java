package com.antiphon.xiaomai.common.utils.user;

import java.util.Date;

import com.antiphon.xiaomai.common.utils.Aes;
import com.antiphon.xiaomai.common.utils.UtilDate;

public class TokenUtils {
	/**
	 * token格式
	 * @param userId
	 * @param mobile
	 * @param date
	 * @return
	 */
	public static String getToken(Long userId,String mobile,Date date){
		return Aes.enparameter(userId+"_"+mobile+"_"+UtilDate.getDateFormatter(date,"yyyy-MM-dd"));
	}
	/**
	 * 解密token格式
	 * @param token
	 * @return
	 */
	public static TokenInfo tokenInfo(String token){
		  String tokendeparameter=Aes.deparameter(token);
		  String[] info=tokendeparameter.split("_");
		  TokenInfo tokenInfo=new TokenInfo();
		  tokenInfo.setUserId(Long.parseLong(info[0]));
		  tokenInfo.setMobile(info[1]);
		  tokenInfo.setData(info[2]);
		 
		return tokenInfo;
	}
	

}
