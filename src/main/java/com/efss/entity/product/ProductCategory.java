package com.efss.entity.product;

import com.efss.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory extends BaseEntity<ProductCategory> {
	
	private String id;
	
	private String category;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
