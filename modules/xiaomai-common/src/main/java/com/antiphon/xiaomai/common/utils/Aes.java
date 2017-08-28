package com.antiphon.xiaomai.common.utils;


import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;



public class Aes {		
	private static final String DEFAULT_KEY = "EESEDWS_2017";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	   System.out.println(deparameter("FFA41EBF84C68605CD923EE608254417"));
		
		
	}
	/**
	 * 加密
	 * @return
	 */
	public static String enparameter(String parameter){
		byte[] byteRe;
		try {
			byteRe = enCrypt(parameter,Aes.DEFAULT_KEY);
			return parseByte2HexStr(byteRe);
		} catch (Exception e) {
		 
			return null; 
		}		
		
		
	}
	
	/**
	 * 解密
	 * @return
	 */
	public static String deparameter(String parameter){
	 
		byte[] encrytByte=parseHexStr2Byte(parameter);
		
		 try {
			return  deCrypt(encrytByte,Aes.DEFAULT_KEY);
		} catch (Exception e) {
			return null; 
		}
		 
		 	
		
		
	}
	
	public static byte[] enCrypt(String content,String strKey) throws Exception{
		KeyGenerator keygen;		
		SecretKey desKey;
		Cipher c;		
		byte[] cByte;
		String str = content;
		
		keygen = KeyGenerator.getInstance("AES");
		keygen.init(128, new SecureRandom(strKey.getBytes()));
		
		desKey = keygen.generateKey();		
		c = Cipher.getInstance("AES");
		
		c.init(Cipher.ENCRYPT_MODE, desKey);
		
		cByte = c.doFinal(str.getBytes("UTF-8"));		
		
		return cByte;
	}
	
	public static String deCrypt (byte[] src,String strKey) throws Exception{
		KeyGenerator keygen;		
		SecretKey desKey;
		Cipher c;		
		byte[] cByte;	
		
		keygen = KeyGenerator.getInstance("AES");
		keygen.init(128, new SecureRandom(strKey.getBytes()));
		
		desKey = keygen.generateKey();
		c = Cipher.getInstance("AES");
		
		c.init(Cipher.DECRYPT_MODE, desKey);
		
		
		cByte = c.doFinal(src);	
		
		return new String(cByte,"UTF-8");
	}
	
	
	/**2进制转化成16进制
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
				}
			sb.append(hex.toUpperCase());
			}
		return sb.toString();
		}
	
	
	/**将16进制转换为二进制
	 * @param hexStr
	 * @return
	 */ 	
	public static byte[] parseHexStr2Byte(String hexStr) { 
	        if (hexStr.length() < 1) 
	                return null; 
	        byte[] result = new byte[hexStr.length()/2]; 
	        for (int i = 0;i< hexStr.length()/2; i++) { 
	                int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16); 
	                int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16); 
	                result[i] = (byte) (high * 16 + low); 
	        } 
	        return result; 
	} 



}
