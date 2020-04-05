package com.efss.entity.user;

import java.io.Serializable;

public class Principal implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id; // 用户id
	private String username;
	private String phone;
	private String officeid;//公司id
	private String dateScope;//数据范围
	
	public String provincesid;//省市id 	
 	public String departmentid;//部门id	                                      
 	public String regionid; //区域id										  
 	public String storefrontid;//店面id								  
 	public String posioionid;//职位id
 	
 	
 	// 数据范围（1所在公司及以下数据；2：所在省市及以下数据；3：所在部门及以下数据；4：所在区域及以下数据；5：所在店面及以下数据；6：仅本职位数据；7：仅本人数据）
 	public static final String DATA_SCOPE_OFFICE = "1"; 	
 	public static final String DATA_SCOPE_PROVINCES = "2"; 	
 	public static final String DATA_SCOPE_DEPARTMENT = "3"; 	                                      
 	public static final String DATA_SCOPE_REGION = "4"; 										  
 	public static final String DATA_SCOPE_STOREFRONT = "5"; 										  
 	public static final String DATA_SCOPE_POSITION = "6"; 	
 	public static final String DATA_SCOPE_ONESELF = "7";
 	
	
	public Principal() {
		super();
	}
	public Principal(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.phone = user.getPhone();
		this.officeid=user.getOfficeid();
		this.dateScope=user.getDataScope();
		this.provincesid=user.getProvincesid();
		this.departmentid=user.getDepartmentid();
		this.regionid=user.getRegionid();
		this.storefrontid=user.getStorefrontid();
		this.posioionid=user.getPosioionid();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOfficeid() {
		return officeid;
	}
	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}
	public String getDateScope() {
		return dateScope;
	}
	public void setDateScope(String dateScope) {
		this.dateScope = dateScope;
	}
	public String getProvincesid() {
		return provincesid;
	}
	public void setProvincesid(String provincesid) {
		this.provincesid = provincesid;
	}
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	public String getRegionid() {
		return regionid;
	}
	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}
	public String getStorefrontid() {
		return storefrontid;
	}
	public void setStorefrontid(String storefrontid) {
		this.storefrontid = storefrontid;
	}
	public String getPosioionid() {
		return posioionid;
	}
	public void setPosioionid(String posioionid) {
		this.posioionid = posioionid;
	} 
}
