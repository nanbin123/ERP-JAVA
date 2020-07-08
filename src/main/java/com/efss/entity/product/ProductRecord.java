package com.efss.entity.product;

import java.util.*;

import com.efss.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRecord extends BaseEntity<ProductRecord> {


	private String productCategoryId;//产品类型的id

	private String productType; //产品类型

	private String purchaseSupplierId;//供应商

	private String productName;//品名

	private String type;//型号

	private String size;//尺寸

	private String color;//颜色

	private String texture;//材质

	private String retailPrice;//零售价

	private String production;//产地

	private String purchasePrice;//采购价

	private String soldOut;    // 是否在架   0 是正常在架  1 已经下架

	private String conventional; // 常规定制 0是常规产品 1 定制产品

	private String state;//货物状态   '0  整件' ,'1套件' '2 子件'

	private String indexImgUrl;//产品首页图片

	private String isMine;//是否添加至我的购物车

    private List<ProductRecord> recordList= new ArrayList<ProductRecord>();//组件产品返回

	private List<ProductAssembly> productAssembly;//子件

	public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getPurchaseSupplierId() {
		return purchaseSupplierId;
	}

	public void setPurchaseSupplierId(String purchaseSupplierId) {
		this.purchaseSupplierId = purchaseSupplierId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public String getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getSoldOut() {
		return soldOut;
	}

	public void setSoldOut(String soldOut) {
		this.soldOut = soldOut;
	}

	public String getConventional() {
		return conventional;
	}

	public void setConventional(String conventional) {
		this.conventional = conventional;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIndexImgUrl() {
		return indexImgUrl;
	}

	public void setIndexImgUrl(String indexImgUrl) {
		this.indexImgUrl = indexImgUrl;
	}

	public String getIsMine() {
		return isMine;
	}

	public void setIsMine(String isMine) {
		this.isMine = isMine;
	}

	public List<ProductRecord> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<ProductRecord> recordList) {
		this.recordList = recordList;
	}

	public List<ProductAssembly> getProductAssembly() {
		return productAssembly;
	}

	public void setProductAssembly(List<ProductAssembly> productAssembly) {
		this.productAssembly = productAssembly;
	}
}