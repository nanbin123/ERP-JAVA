package com.efss.entity.product;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductImage{
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String userid;

   private String productRecordId;

   private String imageUrl;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getProductRecordId() {
		return productRecordId;
	}

	public void setProductRecordId(String productRecordId) {
		this.productRecordId = productRecordId;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
   
   
   
}
