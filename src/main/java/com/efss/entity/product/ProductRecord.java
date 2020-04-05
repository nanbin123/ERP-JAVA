package com.efss.entity.product;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRecord{	
   
	private static final long serialVersionUID = 1L;

	private String id;

    private String userid;
    
    private String productCategoryBid;//产品类型的id

    private String productName;//品名

    private String type;//型号

    private String size;//尺寸

    private String color;//颜色

    private String texture;//材质

    private String price;//零售价

    private String production;//产地

    private String purchaseprice;//采购售价
    
    private String soldOut;		// 是否在架   0 是正常在架  1 已经下架
    
    private String conventional; // 常规定制 0是常规产品 1 定制产品
    
    private String productType; //产品类型
    
    private String indexImgUrl;//产品首页图片
    
    private String isMine;//是否添加至我的购物车
    
    private String assembly;//是否是组件   no是整件 yes是组件    combination组合
    
    private String areaName;
    
    private String areaid;
    
    private Date createDate;   
    
    private List<ProductAssembly> assList =new ArrayList<ProductAssembly>();;//组件产品上传
    
    private List<ProductRecord> recordList= new ArrayList<ProductRecord>();//组件产品返回
    
   
	
 
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
	
	public String getProductCategoryBid() {
		return productCategoryBid;
	}

	public void setProductCategoryBid(String productCategoryBid) {
		this.productCategoryBid = productCategoryBid;
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

	public List<ProductRecord> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<ProductRecord> recordList) {
		this.recordList = recordList;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(String purchaseprice) {
		this.purchaseprice = purchaseprice;
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

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
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
   

	public List<ProductAssembly> getAssList() {
		return assList;
	}

	public void setAssList(List<ProductAssembly> assList) {
		this.assList = assList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAssembly() {
		return assembly;
	}

	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
}