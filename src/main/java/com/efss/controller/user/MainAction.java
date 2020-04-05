package com.efss.controller.user;
import com.efss.entity.ResponseState;
import com.efss.entity.user.Principal;
import com.efss.realm.UsernamePasswordToken;
import com.efss.utils.StringUtils;
import com.efss.utils.TokenUtil;
import com.efss.utils.UserUtils;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.Validate;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@CrossOrigin
@Controller
@RequestMapping("main")
public class MainAction {
	

	
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public ResponseState login(String username, String password, String rememberMe,
							   HttpSession session, HttpServletRequest request, HttpServletResponse response){
		Subject subject = SecurityUtils.getSubject();
		if (password==null){
			password = "";
		}
		String host = StringUtils.getRemoteAddr((HttpServletRequest)request);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray(), false, host, null, false);	  
		ResponseState responseState = new ResponseState();
	     //执行ream 执行登录验证
	    try {
			subject.login(token);
		} catch (AuthenticationException  e) {
			responseState.setMsg("用户名或者密码错误");
			return responseState;
		}
	     if(subject.isAuthenticated()){//验证身份通过	    	
            session.setAttribute("user",subject.getPrincipal());
    		responseState.setSessionid(subject.getSession().getId().toString()); //sessionid  
    		Principal principal = (Principal) UserUtils.getPrincipal();
    		responseState.setUserid(principal.getId());//userid
    		responseState.setOfficeid(principal.getOfficeid());
    		responseState.setUsername(principal.getUsername());//姓名
    		responseState.setPhone(principal.getPhone());//手机号
    		responseState.setToken(TokenUtil.createToken(principal.getPhone()));//token
    		responseState.setState("200");
     		responseState.setMsg("登录成功");    	
            return responseState;
        }else{
        	responseState.setMsg("登录失败");
            return responseState;
        }
	}
	
	
	
	
	
	@RequestMapping(value="loginByToken",method=RequestMethod.POST)
	@ResponseBody
	public ResponseState loginByToken(String username,String password,String rememberMe,
			HttpSession session,HttpServletRequest request, HttpServletResponse response){
		Subject subject = SecurityUtils.getSubject();
		if (password==null){
			password = "";
		}
		String host = StringUtils.getRemoteAddr((HttpServletRequest)request);
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray(), false, host, null, false);
		ResponseState responseState = new ResponseState();
	     //执行ream 执行登录验证
	    try {
			subject.login(token);
		} catch (AuthenticationException  e) {
			responseState.setMsg("用户名或者密码错误");
			return responseState;
		}
	     if(subject.isAuthenticated()){//验证身份通过	    	
            session.setAttribute("user",subject.getPrincipal());
            responseState.setState("200");
    		responseState.setMsg("登录成功");  
    		String sessionid=subject.getSession().getId().toString();
    		responseState.setSessionid(sessionid);   
    		Principal principal = (Principal) UserUtils.getPrincipal();
    		String userid =principal.getId();
    		responseState.setUserid(userid);
    		String officeid = principal.getOfficeid();
    		responseState.setOfficeid(officeid);
    		String appToken= TokenUtil.createToken(principal.getPhone());
    		responseState.setToken(appToken);
    		//因为对密码加了一次密。。当shiro 再次解密的时候要求要加密的。。所以这边也对sessionid 加了一次密
    		 //String entryptSessionid = entryptPassword(sessionid);
    		//sysuserService.updatedateSessionId(userid, entryptSessionid);
            return responseState;
        }else{
        	responseState.setMsg("登录失败");
            return responseState;
        }
	}
	
	
	
	
	
	
	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public String entryptPassword(String plainPassword) {
		String plain = unescapeHtml(plainPassword);
		byte[] salt = generateSalt(8);
		byte[] hashPassword = sha1(plain.getBytes(), salt, 1024);
		return encodeHex(salt)+encodeHex(hashPassword);
	}
	/**
	 * Hex编码.
	 */
	public static String encodeHex(byte[] input) {
		return new String(Hex.encodeHex(input));
	}
	
	/**
	 * Html 解码.
	 */
	public String unescapeHtml(String htmlEscaped) {
		return StringEscapeUtils.unescapeHtml4(htmlEscaped);
	}
	/**
	 * 生成随机的Byte[]作为salt.
	 * 
	 * @param numBytes byte数组的大小
	 */
	public byte[] generateSalt(int numBytes) {
		SecureRandom random = new SecureRandom();
		Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);
		byte[] bytes = new byte[numBytes];
		random.nextBytes(bytes);
		return bytes;
	}
	
	
	public byte[] sha1(byte[] input, byte[] salt, int iterations) {
		return digest(input,"SHA-1", salt, iterations);
	}
	
	/**
	 * 对字符串进行散列, 支持md5与sha1算法.
	 */
	private byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);

			if (salt != null) {
				digest.update(salt);
			}

			byte[] result = digest.digest(input);

			for (int i = 1; i < iterations; i++) {
				digest.reset();
				result = digest.digest(result);
			}
			return result;
		} catch (GeneralSecurityException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
	
	

}
