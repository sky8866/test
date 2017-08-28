package com.antiphon.xiaomai.common.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
	private static Properties pro;
	static{
		pro=new Properties();
		try {
			pro.load(ConfigUtil.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key){
		return pro.getProperty(key);
	}
}
