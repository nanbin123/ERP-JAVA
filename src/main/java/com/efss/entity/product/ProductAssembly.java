package com.efss.entity.product;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductAssembly implements Serializable{
	
	private String id;

	private String productid;

	private String productAssemblyId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductAssemblyId() {
		return productAssemblyId;
	}

	public void setProductAssemblyId(String productAssemblyId) {
		this.productAssemblyId = productAssemblyId;
	}
}
