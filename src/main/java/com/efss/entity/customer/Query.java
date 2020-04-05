package com.efss.entity.customer;

import java.io.Serializable;

public class Query implements Serializable{
	private static final long serialVersionUID = 1L;
	private int total;
	private String customerName;//客户姓名
	private String phone;//客户电话
	private String address;//客户地址
	private String firstDate;//记录开始时间	
	private String endDate;//记录结束时间
	private String nameOrPhone;
	private String grade;//意向星星
	private String page;
	private String limit;
	private String gradeMeUserid;//授权给我的userid
	private String dsf;
	

	
	public Query() {
		super();		
	}
	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getFirstDate() {
		return firstDate;
	}


	public void setFirstDate(String firstDate) {
		this.firstDate = firstDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getNameOrPhone() {
		return nameOrPhone;
	}


	public void setNameOrPhone(String nameOrPhone) {
		this.nameOrPhone = nameOrPhone;
	}


	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getGradeMeUserid() {
		return gradeMeUserid;
	}
	public void setGradeMeUserid(String gradeMeUserid) {
		this.gradeMeUserid = gradeMeUserid;
	}
	public String getDsf() {
		return dsf;
	}
	public void setDsf(String dsf) {
		this.dsf = dsf;
	}
	
	
}
