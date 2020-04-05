package com.efss.entity.product;

import java.util.Date;

/**
 * 产品分析
 * @author 融恒
 *
 */
public class ProductAnalysis extends ProductRecord{
	
	private String salesMoney;//销售额
	
	private String attentionDegree;//关注度
	
	private String salesNumber;//销售量 
	
	private String strDate;//起始时间
	
	private String endDate;//结束时间
	
	private String productCategoryBId;//产品类别id
	
	private String dsf;

	public String getSalesMoney() {
		return salesMoney;
	}

	public void setSalesMoney(String salesMoney) {
		this.salesMoney = salesMoney;
	}

	public String getAttentionDegree() {
		return attentionDegree;
	}

	public void setAttentionDegree(String attentionDegree) {
		this.attentionDegree = attentionDegree;
	}

	public String getSalesNumber() {
		return salesNumber;
	}

	public void setSalesNumber(String salesNumber) {
		this.salesNumber = salesNumber;
	}
	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getProductCategoryBId() {
		return productCategoryBId;
	}

	public void setProductCategoryBId(String productCategoryBId) {
		this.productCategoryBId = productCategoryBId;
	}

	public String getDsf() {
		return dsf;
	}

	public void setDsf(String dsf) {
		this.dsf = dsf;
	}
}
