package com.efss.entity.product;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductAssembly implements Serializable{	
	
	private static final long serialVersionUID = 1L;	
	
	private String id;
	
	private String productQuoteId;
	
	private String productid;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getProductQuoteId() {
		return productQuoteId;
	}
	public void setProductQuoteId(String productQuoteId) {
		this.productQuoteId = productQuoteId;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	
	

}
