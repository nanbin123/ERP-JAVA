package com.efss.utils;
import com.efss.entity.user.Principal;
import com.efss.entity.user.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;






public class UserUtils {
	
	//private static SysUserMapper sysUserMapper = SpringContextHolder.getBean(SysUserMapper.class);
	
	/*public void test(){
		User user = sysUserMapper.get("2c9123945fc43995015fc7cae4370041");
		System.out.println(user.getId());
	}
	*/
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	/*public static User get(String id){
		User user = sysUserMapper.get(id);
		if (user == null){
			return null;
		}
		return user;
	}*/
	
	
	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	/*public static User getUser(){
		Principal principal = getPrincipal();
		if (principal!=null){
			User user = get(principal.getId());
			if (user != null){
				return user;
			}
			return new User();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new User();
	}*/
	
	
	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal)subject.getPrincipal();
			if (principal != null){
				return principal;
			}
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	
	public static Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
//			subject.logout();
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
}
