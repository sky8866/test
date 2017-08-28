package com.antiphon.xiaomai.common.utils;


public class StringUtils {
	public static boolean isNotEmpty(String str) {
		if (str!= null && str.length()>0) {
			return true;
		} else {
			return false;
		}
	}

}
