package com.efss.entity.user;

import com.efss.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseEntity<User> {
	private static final long serialVersionUID = 1L;	
	private String userid;//用户id
	private String officeid;//公司id
	private String username;//用户姓名
    private String password;//密码
    private String phone;//账号
    private String gender;//性别
    private String mail;//邮箱
    private String company;//所属公司
    private String identityNumber;//身份证号
    private String householdRegistrationAddress;//户籍所在地
    private String department;//所在部门
    private String position;//所属职位
    private String ruzhiTime;//入职时间
    private String sessionid;
    	
 	public String provincesid;//省市id 	
 	public String departmentid;//部门id	                                      
 	public String regionid; //区域id										  
 	public String storefrontid;//店面id								  
 	public String posioionid;//职位id
 	
    
    
    
    
    private String dataScope;//权限   1 公司  2 省市  3 部门  4 区域  5 店面  6 职位     7 仅本人数据
    
   
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getHouseholdRegistrationAddress() {
		return householdRegistrationAddress;
	}
	public void setHouseholdRegistrationAddress(String householdRegistrationAddress) {
		this.householdRegistrationAddress = householdRegistrationAddress;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getRuzhiTime() {
		return ruzhiTime;
	}
	public void setRuzhiTime(String ruzhiTime) {
		this.ruzhiTime = ruzhiTime;
	}
	public String getDataScope() {
		return dataScope;
	}
	public void setDataScope(String dataScope) {
		this.dataScope = dataScope;
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
