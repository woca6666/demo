package com.example.demo.pojo.user;


import com.example.demo.pojo.BaseBean;

public class Role extends BaseBean {

//	private String name;

	private String roleCode;

	private String description;

	private Short sort;

	private String delFlag;

	private String roleName;

	// 角色备注
	private String roleRemark;

	// 角色最大用户数
	private Integer roleMaxUser;

	// 默认角色，0表示默认角色，1-自定义角色
	private String defaultRole;

	private String roleType;

	private String menuList;

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name == null ? null : name.trim();
//	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode == null ? null : roleCode.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Short getSort() {
		return sort;
	}

	public void setSort(Short sort) {
		this.sort = sort;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag == null ? null : delFlag.trim();
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}

	public String getRoleRemark() {
		return roleRemark;
	}

	public void setRoleMaxUser(Integer roleMaxUser) {
		this.roleMaxUser = roleMaxUser;
	}

	public Integer getRoleMaxUser() {
		return roleMaxUser;
	}

	public void setDefaultRole(String defaultRole) {
		this.defaultRole = defaultRole;
	}

	public String getDefaultRole() {
		return defaultRole;
	}

	public String getMenuList() {
		return menuList;
	}

	public void setMenuList(String menuList) {
		this.menuList = menuList;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

}