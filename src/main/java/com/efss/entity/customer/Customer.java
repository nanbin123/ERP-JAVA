package com.efss.entity.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.efss.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String customerName;//客户姓名

    private String customerPhone;//客户电话
    
    private String customerAddress;//客户地址
    
    private String sex;//性别
    
    private Date predictTime;//预约时间
    
    private Date reminderTime;//提醒时间
    
    private String grade;//意向程度
    
 	private List<CustomerProduct> customerProducts=new ArrayList<CustomerProduct>();//预购产品
	
	private List<CustomerTailafter> tailafterInformations=new ArrayList<CustomerTailafter>();//跟踪记录
	
	private List<CustomerArrival> arrivalInformations=new ArrayList<CustomerArrival>();//到店记录
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getPredictTime() {
		return predictTime;
	}

	public void setPredictTime(Date predictTime) {
		this.predictTime = predictTime;
	}

	public Date getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(Date reminderTime) {
		this.reminderTime = reminderTime;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<CustomerProduct> getCustomerProducts() {
		return customerProducts;
	}

	public void setCustomerProducts(List<CustomerProduct> customerProducts) {
		this.customerProducts = customerProducts;
	}

	public List<CustomerTailafter> getTailafterInformations() {
		return tailafterInformations;
	}

	public void setTailafterInformations(List<CustomerTailafter> tailafterInformations) {
		this.tailafterInformations = tailafterInformations;
	}

	public List<CustomerArrival> getArrivalInformations() {
		return arrivalInformations;
	}

	public void setArrivalInformations(List<CustomerArrival> arrivalInformations) {
		this.arrivalInformations = arrivalInformations;
	}



	
    
}
