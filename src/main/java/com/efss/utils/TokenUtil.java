package com.efss.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class TokenUtil {

	  /**
     * APP登录Token的生成和解析
     * 
     */

    /** token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj */
    public static final String SECRET = "ronghengnanbin";
    /** token 过期时间: 10天 */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 10;
    
    /**
     * JWT生成Token.<br/>
     * 
     * JWT构成: header, payload, signature
     * 
     * @param user_id
     *  登录成功后用户user_id, 参数user_id不可传空
     */
    public static String createToken(String phone){
        try {
			Date iatDate = new Date();
			// expire time
			/*Calendar nowTime = Calendar.getInstance();
			nowTime.add(calendarField, calendarInterval);
			Date expiresDate = nowTime.getTime();*/
			// header Map
			Map<String, Object> map = new HashMap<>();
			map.put("alg", "HS256");
			map.put("typ", "JWT");
			// build token
			// param backups {iss:Service, aud:APP}
			String token = JWT.create().withHeader(map) // header
			        .withClaim("iss", "Service") // payload
			        .withClaim("aud", "APP").withClaim("phone", null == phone ? null : phone)
			        .withIssuedAt(iatDate) // sign time
			        //.withExpiresAt(expiresDate) // expire time
			        .sign(Algorithm.HMAC256(SECRET)); // signature
			return token;
		} catch (Exception e) {			
			e.printStackTrace();
		}
        return null;
    }


    /**
     * 解密Token
     * 
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
             e.printStackTrace();
            // token 校验失败, 抛出Token验证非法异常
        }
        return jwt.getClaims();
    }

    
    
    /**
     * 根据Token获取userid
     * 
     * @param token
     * @return user_id
     */
    public static String getAppUID(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Claim user_id_claim = claims.get("phone");
        if (null == user_id_claim || StringUtils.isEmpty(user_id_claim.asString())) {
            // token 校验失败, 抛出Token验证非法异常
        }
        return String.valueOf(user_id_claim.asString());
    }

    
    
    
  public static void main(String[] args) {
	   String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJwaG9uZSI6IjE1ODMyOTIyMTUzIiwiaXNzIjoiU2VydmljZSIsImlhdCI6MTU1MjU2MjAwOX0.uy7N5JGpc1Ue4QICv3BlG2I1DCAnpgCUGzuyNu0_yq4";
	 String phope="15832922153";
	/*   try {
		String createToken = createToken(phope);
		System.out.println(createToken);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	/* Map<String, Claim> verifyToken = verifyToken(token);
	 for(String key:verifyToken.keySet()){
		System.out.println(key);
		System.out.println(verifyToken.get(key));
	 }*/
	  
    String appUID = getAppUID(token);
    System.out.println(appUID);
   }
}
