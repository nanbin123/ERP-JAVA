package com.efss.entity.finance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.efss.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FinancialAccountingB extends BaseEntity implements Serializable{
   
	private static final long serialVersionUID = 1L;

    private String dataDictionaryId;//类别

	private String dataDictionaryName;//类别名称

    private String name;//名称
	@JSONField(format="yyyy-MM-dd")
	private Date yearMosDay;

    private BigDecimal money;//金额

	private String moneya;

	private  String moneyb;

    private Integer number;//数量

	private BigDecimal totalMoney;//金额

	private String type;
    
    private String remark;//备注

    private String deleteFlag;//是否作废 1 作废 0 正常状态


	public String getDataDictionaryId() {
		return dataDictionaryId;
	}

	public void setDataDictionaryId(String dataDictionaryId) {
		this.dataDictionaryId = dataDictionaryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getYearMosDay() {
		return yearMosDay;
	}

	public void setYearMosDay(Date yearMosDay) {
		this.yearMosDay = yearMosDay;
	}

	public String getMoneya() {
		return moneya;
	}

	public void setMoneya(String moneya) {
		this.moneya = moneya;
	}

	public String getMoneyb() {
		return moneyb;
	}

	public void setMoneyb(String moneyb) {
		this.moneyb = moneyb;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDataDictionaryName() {
		return dataDictionaryName;
	}

	public void setDataDictionaryName(String dataDictionaryName) {
		this.dataDictionaryName = dataDictionaryName;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
}