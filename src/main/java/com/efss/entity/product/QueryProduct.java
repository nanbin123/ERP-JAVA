package com.efss.entity.product;

public class QueryProduct {

	 private String id;
	
	 private String assembly;//是否是组件   no是整件 yes是组件    combination组合
	 
	 private String lowerShelf;//下架
	    
	 private String noLowerShelf;//在架
	    
	 private String routine;//常规
	    
	 private String customized;//定制
	    
	 private String productNameOrType;//品名或者型号
	 
	 private String dsf;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssembly() {
		return assembly;
	}

	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}

	public String getLowerShelf() {
		return lowerShelf;
	}

	public void setLowerShelf(String lowerShelf) {
		this.lowerShelf = lowerShelf;
	}

	public String getNoLowerShelf() {
		return noLowerShelf;
	}

	public void setNoLowerShelf(String noLowerShelf) {
		this.noLowerShelf = noLowerShelf;
	}

	public String getRoutine() {
		return routine;
	}

	public void setRoutine(String routine) {
		this.routine = routine;
	}

	public String getCustomized() {
		return customized;
	}

	public void setCustomized(String customized) {
		this.customized = customized;
	}

	public String getProductNameOrType() {
		return productNameOrType;
	}

	public void setProductNameOrType(String productNameOrType) {
		this.productNameOrType = productNameOrType;
	}

	public String getDsf() {
		return dsf;
	}

	public void setDsf(String dsf) {
		this.dsf = dsf;
	}
	 
	 
}
