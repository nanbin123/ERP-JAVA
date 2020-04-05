package com.efss.session;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *  自定义WEB会话管理类
 * @author 融恒
 *
 */
public class SessionManager  extends DefaultWebSessionManager {

	public SessionManager() {
		super();
	}
	
/*	@Override
    public Serializable getSessionId(SessionKey key) {
        Serializable sessionId = key.getSessionId();
        if(sessionId == null){
            HttpServletRequest request = WebUtils.getHttpRequest(key);
            HttpServletResponse response = WebUtils.getHttpResponse(key);
            sessionId = this.getSessionId(request,response);
        }
        HttpServletRequest request = WebUtils.getHttpRequest(key);
        request.setAttribute("sessionid",sessionId ==null?"":sessionId.toString());
        return sessionId;
    }*/
	
	
	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {		
		String sid = request.getParameter("sessionid");
	/*	ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest requesth = attributes.getRequest();
		String sid=requesth.getHeader("sessionid");*/
		if (StringUtils.isNotBlank(sid)) {
			// 设置当前session状态
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,
            ShiroHttpServletRequest.URL_SESSION_ID_SOURCE); // session来源与url
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sid);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
        	return sid;
		}else{
			Serializable sessionId = super.getSessionId(request, response);			
			return sessionId;
		}
	}
	
	

	@Override
	protected Session retrieveSession(SessionKey sessionKey) {
		try{
			return super.retrieveSession(sessionKey);
		}catch (UnknownSessionException e) {
    		// 获取不到SESSION不抛出异常
			return null;
		}
	}
	
	

}
