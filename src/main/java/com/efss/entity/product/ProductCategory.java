package com.efss.entity.product;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
	
	private String id;
	
	private String category;
	
	List<ProductCategoryB> list=new ArrayList<ProductCategoryB>();
	

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

	public List<ProductCategoryB> getList() {
		return list;
	}

	public void setList(List<ProductCategoryB> list) {
		this.list = list;
	}
}
