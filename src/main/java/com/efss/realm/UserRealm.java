package com.efss.realm;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.efss.entity.user.Principal;
import com.efss.entity.user.User;
import com.efss.mapper.UserMapper;
import com.efss.utils.UserUtils;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;


/**
 *登录验证，权限认证ream
 * @author 融恒
 */
public class UserRealm extends AuthorizingRealm{

    @Autowired
	private UserMapper userMapper;
	
   
    
	@Override
	public String getName() {
		return "UserRealm";
	}
	//授权操作
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Principal principal = UserUtils.getPrincipal();
        List<String> permissions = new ArrayList<String>();
        //如果是13811765771 的账户拥有所有权限
        if("13811765771".equals(principal.getPhone())){
            permissions.add("*:*");
            
        }else{
            //permissions =  userMapper.getResource(principal.getId());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        return info; 
		
	}

	//认证操作
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		//通过username 和sessionid 登录
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String phone=(String) token.getUsername();
		User user = userMapper.getUserByUsername(phone);
		if(user == null){
			return null;
		}
		byte[] salt = decodeHex(user.getPassword().substring(0,16));
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(new Principal(user),user.getPassword().substring(16),
				ByteSource.Util.bytes(salt),getName());
		return simpleAuthenticationInfo;
	}
	
	
	
	
	

	
	

	
	/**
	 * 设定密码校验的Hash算法与迭代次数   @PostConstruct 密码加密规则   在项目加载的时候执行
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("SHA-1");
		matcher.setHashIterations(1024);
		setCredentialsMatcher(matcher);
	}
	
	
	/**
	 * Hex解码.
	 * @throws Exception 
	 */
	public static byte[] decodeHex(String input){	
		try {
			return Hex.decodeHex(input.toCharArray());
		} catch (DecoderException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/*清除缓存
	 * 如果用户非正常退出缓存自动清空
	 * 如果修改了用户权限，而用户不退出系统，修改的权限无法立即生效
	 * 当用户权限修改后用户再次登录shiro会自动调用realm从数据库获取权限数据，如果在修改权限后想立即清空缓存
	 * 则可以调用realm的clearCache方法清空缓存
	  */
    public void clearCached() {
        //获取当前等的用户凭证，然后清除
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
