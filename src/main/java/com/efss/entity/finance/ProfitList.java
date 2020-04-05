package com.efss.entity.finance;

import java.io.Serializable;
/**
 * 盈亏表
 * @author 融恒
 */
public class ProfitList implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String rent="0";//租金
	
	private String staffCosts="0";//人月费用
	
	private String logisticsFees="0";//物流费用
	
	private String normalcyIncidentals="0";//常态杂费
	
	private String claimExpense="0";//报销费用
	
	private String incidentals="0";//杂费
	
	private String  otherExpenses="0";//其他费用
	
	private String sale="0";//销售额
	
	private String  productCosts="0";//产品成本
	
	private String unreceivable="0" ;//未收款
	
	private String receivables="0";//已收款
	
	private String massProfit="0";//利润额度
	
	private String returnGoods="0";//退货额度
	
	public String getUnreceivable() {
		return unreceivable;
	}

	public void setUnreceivable(String unreceivable) {
		this.unreceivable = unreceivable;
	}

	public String getReceivables() {
		return receivables;
	}

	public void setReceivables(String receivables) {
		this.receivables = receivables;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getStaffCosts() {
		return staffCosts;
	}

	public void setStaffCosts(String staffCosts) {
		this.staffCosts = staffCosts;
	}

	public String getLogisticsFees() {
		return logisticsFees;
	}

	public void setLogisticsFees(String logisticsFees) {
		this.logisticsFees = logisticsFees;
	}

	public String getNormalcyIncidentals() {
		return normalcyIncidentals;
	}

	public void setNormalcyIncidentals(String normalcyIncidentals) {
		this.normalcyIncidentals = normalcyIncidentals;
	}

	public String getClaimExpense() {
		return claimExpense;
	}

	public void setClaimExpense(String claimExpense) {
		this.claimExpense = claimExpense;
	}

	public String getIncidentals() {
		return incidentals;
	}

	public void setIncidentals(String incidentals) {
		this.incidentals = incidentals;
	}

	public String getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(String otherExpenses) {
		this.otherExpenses = otherExpenses;
	}

	public String getProductCosts() {
		return productCosts;
	}

	public void setProductCosts(String productCosts) {
		this.productCosts = productCosts;
	}

	public String getMassProfit() {
		return massProfit;
	}

	public void setMassProfit(String massProfit) {
		this.massProfit = massProfit;
	}

	public String getReturnGoods() {
		return returnGoods;
	}

	public void setReturnGoods(String returnGoods) {
		this.returnGoods = returnGoods;
	}
	
	
	
	
}
