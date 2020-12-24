package com.example.demo.utils;

import java.util.HashMap;

public class MessageUtils {
	
	/**
	 * 生成错误信息
	 * @param msg
	 * @return
	 */
	public static String get(Integer code) {
		return ServletUtils.getRequestContext(ServletUtils.getRequest()).getMessage(code.toString());
	}
	/**
	 * 生成错误信息
	 * @param msg
	 * @return
	 */
	public static HashMap<String, Object> error() {
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("errorCode", -1);
		hashMap.put("errorText", get(-1));
		return hashMap;
	}	

	
	/**
	 * 生成错误信息
	 * @param request
	 * @param code
	 * @return
	 */
	public static HashMap<String, Object> error(Integer code){
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("errorCode", code.toString());
		hashMap.put("errorText", ServletUtils.getRequestContext(ServletUtils.getRequest()).getMessage(code.toString()));
		return hashMap;
	}
	/**
	 * 生成错误信息
	 * @param msg
	 * @return
	 */
	public static HashMap<String, Object> error(String message) {
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("errorCode", -1);
		hashMap.put("errorText", message);
		return hashMap;
	}
	/**
	 * 生成错误信息
	 * @param request
	 * @param code
	 * @return
	 */
	public static HashMap<String, Object> error(Integer code,String message){
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("errorCode", code.toString());
		hashMap.put("errorText", message);
		return hashMap;
	}
	/**
	 * 生成成功信息
	 * @param msg
	 * @return
	 */
	public static HashMap<String, Object> success() {
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("errorCode", 0);
		hashMap.put("errorText", get(0));
		return hashMap;
	} 

	/**
	 * 生成成功信息
	 * @param request
	 * @param code
	 * @return
	 */
	public static HashMap<String, Object> success(Integer code){
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("errorCode", 0);
		hashMap.put("errorText", ServletUtils.getRequestContext(ServletUtils.getRequest()).getMessage(code.toString()));
		return hashMap;
	}
	/**
	 * 生成成功信息
	 * @param request
	 * @param code
	 * @return
	 */
	public static HashMap<String, Object> success(String  message){
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("errorCode", 0);
		hashMap.put("errorText", message);
		return hashMap;
	}
	
	
	
	/**
	 * 生成成功信息
	 * @param request
	 * @param code
	 * @return
	 */
	public static HashMap<String, Object> info(Integer code,String message){
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("errorCode", code);
		hashMap.put("errorText", message);
		return hashMap;
		
	}


}
