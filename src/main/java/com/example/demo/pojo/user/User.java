package com.example.demo.pojo.user;

import com.example.demo.pojo.BaseBean;
import com.example.demo.utils.DateFormatUtil;

import java.io.Serializable;

public class User extends BaseBean implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	// 职位
	private String rolesId;

	// 职位
	private String rolesName;

	private String roleName;

	private String loginLockIp;

	// 用户所属角色
	private Integer roleId;

	// 用户名
	private String userName;

	// 显示名
	private String showName;

	// 密码（加密存储）
	private String password;

	// 默认用户标志0-否，1-是
	private String defaultUser;

	// 电话
	private String mobile;

	// 电子邮箱
	private String email;

	// 允许登录的ip地址范围
	private String allowAccessIp;

	// 允许扫描的ip地址范围
	private String allowScanIp;

	// 用户描述
	private String userRemark;

	// 用户在线状态
	private String onlineState;

	// 用户锁定状态
	private String lockState;

	// 密码修改时间
	private Integer pwdChangeTime;

	// 账户锁定时间
	private Long lockTime;

	// 账户解锁时间
	private Long unlockTime;

	// 锁定原因
	private String lockReason;

	// 最后一次登录时间
	private Integer lastLoginTime;

	private String icon;

	private String description;

	private Integer loginCount;

	private Integer previousVisit;

	private Integer isLock;

	private String loginIps;

	private String scanIps;

	private Integer countRole;

	public String getPreviousVisitString() {
		if (previousVisit == null)
			return "";
		return DateFormatUtil.transToString(previousVisit, "yyyy-MM-dd HH:mm:ss");
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName == null ? null : showName.trim();
	}

	public String getDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(String defaultUser) {
		this.defaultUser = defaultUser;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getAllowAccessIp() {
		return allowAccessIp;
	}

	public void setAllowAccessIp(String allowAccessIp) {
		this.allowAccessIp = allowAccessIp;
	}

	public String getAllowScanIp() {
		return allowScanIp;
	}

	public void setAllowScanIp(String allowScanIp) {
		this.allowScanIp = allowScanIp;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark == null ? null : userRemark.trim();
	}

	public String getOnlineState() {
		return onlineState;
	}

	public void setOnlineState(String onlineState) {
		this.onlineState = onlineState;
	}

	public String getLockState() {
		return lockState;
	}

	public void setLockState(String lockState) {
		this.lockState = lockState;
	}

	public Long getLockTime() {
		return lockTime;
	}

	public void setLockTime(Long lockTime) {
		this.lockTime = lockTime;
	}

	public Long getUnlockTime() {
		return unlockTime;
	}

	public void setUnlockTime(Long unlockTime) {
		this.unlockTime = unlockTime;
	}

	public String getLockReason() {
		return lockReason;
	}

	public void setLockReason(String lockReason) {
		this.lockReason = lockReason;
	}

	public Integer getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Integer lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Integer getPreviousVisit() {
		return previousVisit;
	}

	public void setPreviousVisit(Integer previousVisit) {
		this.previousVisit = previousVisit;
	}

	public String getRolesId() {
		return rolesId;
	}

	public void setRolesId(String rolesId) {
		this.rolesId = rolesId;
	}

	public String getRolesName() {
		return rolesName;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public String getLoginIps() {
		return loginIps;
	}

	public void setLoginIps(String loginIps) {
		this.loginIps = loginIps;
	}

	public String getScanIps() {
		return scanIps;
	}

	public void setScanIps(String scanIps) {
		this.scanIps = scanIps;
	}

	public Integer getPwdChangeTime() {
		return pwdChangeTime;
	}

	public void setPwdChangeTime(Integer pwdChangeTime) {
		this.pwdChangeTime = pwdChangeTime;
	}

	public String getLoginLockIp() {
		return loginLockIp;
	}

	public void setLoginLockIp(String loginLockIp) {
		this.loginLockIp = loginLockIp;
	}

	public Integer getCountRole() {
		return countRole;
	}

	public void setCountRole(Integer countRole) {
		this.countRole = countRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}