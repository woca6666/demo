package com.example.demo.pojo.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用于树形结构
 * 
 *
 * @author  jiangcuilan
 * @date    2018年9月20日
 * @version 1.0
 *
 */
public class TreeBean {

	public Integer id;
	
	
	public Integer pid;
	
	private String code;
	
	private String name;
	
	private String text;
	
	private List<TreeBean> children= new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TreeBean> getChildren() {
		return children;
	}

	public void setChildren(List<TreeBean> children) {
		this.children = children;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	
	
}
