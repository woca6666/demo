package com.example.demo.pojo.base;

import java.util.List;

public class Menu {
	private  int  id;
	private  int pid;
	private  String text;
	private  String iconCls;
	private  State state;
	private  Integer sort;
	private  String url;
	private  String[] tags;
	private  List<Menu> nodes;
	private  String remark;


	public int getId() {
		return id;
	}

	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}



	public List<Menu> getNodes() {
		return nodes;
	}
	public void setNodes(List<Menu> nodes) {
		this.nodes = nodes;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public class  State{
		private Boolean expanded;
		private Boolean selected;
		
		
		public State(Boolean expanded,Boolean selected) {
			this.expanded = expanded;
			this.selected = selected;
		}


		public Boolean getExpanded() {
			return expanded;
		}


		public void setExpanded(Boolean expanded) {
			this.expanded = expanded;
		}


		public boolean getSelected() {
			return selected;
		}


		public void setSelected(Boolean selected) {
			this.selected = selected;
		}
		
		
	}

	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

