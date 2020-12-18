//package com.example.demo.pojo.user;
//
//import com.example.demo.utils.StringUtils;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
///**
// * 登录账户
// *
// * @author jiangcuilan
// * @date 2019年4月3日
// * @version 1.0
// */
//public class UserToken extends User implements UserDetails {
//
//	private String name;
//
//	private String password;
//
//	// 多对多映射，用户角色
//	private List<Role> roles;
//
//	// 多对多映射，用户角色
//	private List<Permission> permissions;
//
//	private String token;
//
//	/** 登陆时间戳（毫秒） */
//	private Integer loginTime;
//
//	/** 过期时间戳 */
//	private Integer expireTime;
//
//	private String roleName;
//
//	public UserToken(Integer id, String userName, String password, String showName, Integer roleId, String roleName) {
//		super.setId(id);
//		this.name = userName;
//		this.password = password;
//		this.roleName = roleName;
//		super.setUserName(name);
//		super.setShowName(showName);
//		super.setRoleId(roleId);
//	}
//
//	public UserToken() {
//	}
//
//	public String getRolesName() {
//		if (roles != null && roles.size() > 0) {
//			return roles.stream().map(m -> m.getRoleCode()).collect(Collectors.joining(","));
//		} else {
//			return null;
//		}
//
//	}
//
//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(String token) {
//		this.token = token;
//	}
//
//	public Integer getLoginTime() {
//		return loginTime;
//	}
//
//	public void setLoginTime(Integer loginTime) {
//		this.loginTime = loginTime;
//	}
//
//	public Integer getExpireTime() {
//		return expireTime;
//	}
//
//	public void setExpireTime(Integer expireTime) {
//		this.expireTime = expireTime;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}
//
//	public List<Permission> getPermissions() {
//		return permissions;
//	}
//
//	public void setPermissions(List<Permission> permissions) {
//		this.permissions = permissions;
//	}
//
//	// 获取当前用户实例的password
//	@Override
//	public String getPassword() {
//		return this.password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	// 根据自定义逻辑来返回用户权限，如果用户权限返回空或者和拦截路径对应权限不同，验证不通过
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		List<Permission> permissions = this.getPermissions();
//		for (Permission permission : permissions) {
//			if (StringUtils.isNotBlack(permission.getPermCode())) {
//				String[] ps = permission.getPermCode().split(",");
//				for (String p : ps) {
//					authorities.add(new SimpleGrantedAuthority(p));
//				}
//
//			}
//		}
//		return authorities;
//	}
//
//	// 获取当前用户实例的name
//	@Override
//	public String getUsername() {
//		return this.name;
//	}
//
//	// 帐号是否不过期，false则验证不通过
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	// 帐号是否不锁定，false则验证不通过
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	// 凭证是否不过期，false则验证不通过
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	// 该帐号是否启用，false则验证不通过
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return this.name;
//	}
//
//	@Override
//	public int hashCode() {
//		return name.hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		return this.toString().equals(obj.toString());
//	}
//
//	public String getRoleName() {
//		return roleName;
//	}
//
//	public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	}
//
//}
