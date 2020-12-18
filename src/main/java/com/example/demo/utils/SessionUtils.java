//package com.example.demo.utils;
//
//import com.example.demo.pojo.user.User;
//import com.example.demo.pojo.user.UserToken;
//
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpSession;
//
//public class SessionUtils {
//
//	/**
//	 * 获取当前用户httpsession
//	 *
//	 * @return httpsession
//	 */
//	public static HttpSession getHttpSession() {
//		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//		HttpSession session = attr.getRequest().getSession(true);
//		return session;
//	}
//
//	/**
//	 * 获取当前用户对象
//	 *
//	 * @return user
//	 */
//	public static User getUser() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication != null) {
//			if (authentication instanceof AnonymousAuthenticationToken) {
//				return null;
//			}
//			if (authentication instanceof UsernamePasswordAuthenticationToken) {
//				return (UserToken) authentication.getPrincipal();
//			}
//		}
//
//		return null;
//	}
//
//	/**
//	 * 设置用户
//	 *
//	 * @param user
//	 */
//	public static void setUser(User user) {
//		HttpSession session = SessionUtils.getHttpSession();
//		if (null != session) {
//			session.setAttribute("user", user);
//			session.setAttribute("username", user.getUserName());
//		}
//	}
//
//	/**
//	 * 设置用户
//	 *
//	 * @param
//	 */
//	public static void clearSession() {
//		HttpSession session = SessionUtils.getHttpSession();
//		session.removeAttribute("user");
//		session.removeAttribute("logId");
//
//	}
//
//}
