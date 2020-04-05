package com.efss.realm;



import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.efss.entity.user.User;
import com.efss.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;


public class MyAuthenticationFilter extends FormAuthenticationFilter{
	    @Autowired
		private UserMapper userMapper;
	    
	    @Override
	    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
          System.out.println("未登录，无法访问该地址");           
          return false;
	    }
	    
	    @Override
	    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
	    	String username=(String) token.getPrincipal();	      
	        HttpSession session = ((HttpServletRequest)request).getSession();
	        User user = userMapper.getUserByUsername(username);
	        System.out.println("登录成功");        
	        return true;
	    }
}
