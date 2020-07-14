package com.efss.service;

import java.util.List;

import com.efss.entity.product.*;
import com.efss.entity.user.Principal;
import com.efss.mapper.ProductMapper;
import com.efss.utils.IdGen;
import com.efss.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductService extends BaseService{

	@Autowired
	private ProductMapper productMapper;


	public List<ProductRecord> selectListProduct(QueryProduct queryProduct) {
        List<ProductRecord> listProduct=productMapper.selectListProduct(queryProduct);
        if(queryProduct.getState() !=null&& "1".equals(StringUtils.join(queryProduct.getState()))){
            for (int i = 0; i < listProduct.size(); i++) {
                List<ProductRecord> recordList=productMapper.selectProductAssembly(listProduct.get(i).getId());
                listProduct.get(i).setRecordList(recordList);
            }
        }
		return listProduct;
	}
	public int insertProduct(ProductRecord productRecord) {
		return productMapper.insertProduct(productRecord);
	}




	public int insertAssembly(ProductRecord productRecord) {
		List<ProductAssembly> productAssembly= productRecord.getProductAssembly();
		int i=0;
		for(ProductAssembly p : productAssembly){
			p.setId(IdGen.uuid());
			p.setProductid(productRecord.getId());
			i+= productMapper.insertAssembly(p);
		}
		return i;
	}


	public List<ProductCategory> selectCategory() {
		List<ProductCategory> selectCategory = productMapper.selectCategory();
		return selectCategory;
	}


	public int insertProductCategory(ProductCategory productCategory){
		return productMapper.insertProductCategory(productCategory);
	}

	public int updateProductCategory(ProductCategory productCategory){
		return productMapper.updateProductCategory(productCategory);
	}

	/**/



	/*public List<ProductRecord> selectProduct(String nameOrtype) {
		 String dsf = dataScopeFilter(UserUtils.getPrincipal(),"sa","su");
		 List<ProductRecord> selectProduct = productMapper.selectProduct(nameOrtype,dsf);
		return selectProduct;
	}




	public void savecategory(String category) {
		productMapper.savecategory(IdGen.uuid(),UserUtils.getPrincipal().getId(),category);
	}

	public void updateCategory(String id, String category) {
		productMapper.updateCategory(id,category);
	}

	public void deleteCategory(String id) {
		productMapper.deleteCategory(id);
	}

	public List<ProductCategoryB> selectCategoryB(String productCategoryId) {
		return productMapper.selectCategoryB(productCategoryId);
	}

	public void insertCategoryB(String productCategoryId, String category, String img) {
		productMapper.insertCategoryB(IdGen.uuid(),productCategoryId,category,img);
	}

	public void updateCategoryB(String id, String category) {
		productMapper.updateCategoryB(id,category);
	}

	public void deleteCategoryB(String id) {
		productMapper.deleteCategoryB(id);	
	}



	public void updateProduct(ProductRecord productRecord,String address,String dir) {
		ProductRecord product = productMapper.selectProductGetImgById(productRecord.getId());
		*//*if(product!=null && StringUtils.isNotBlank(product.getIndexImgUrl())){
			String imageUrl = dir.replace("\\", "/")+product.getIndexImgUrl();
			boolean deleteFile = FileUpLoad.deleteFile(imageUrl);
			if(deleteFile){
				productRecord.setIndexImgUrl(address);
			}
		}*//*
		productMapper.updateProduct(productRecord);
	}

	


	public List<ProductAnalysis> selectProductAnalysis(ProductAnalysis productAnalysis) {
		// 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
		String dsf = dataScopeFilter(UserUtils.getPrincipal(),"sa","su");
		productAnalysis.setDsf(dsf);
		List<ProductAnalysis> list=productMapper.selectProductAnalysis(productAnalysis);
		return list;
	}

	public List<ProductRecord> selectProductQuotation(String productCategoryBId,
			 String type) {
		String userid = UserUtils.getPrincipal().getId();
		// 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
		String dsf = dataScopeFilter(UserUtils.getPrincipal(),"sa","su");
		List<ProductRecord> selectProductQuotation = productMapper.selectProductQuotation(dsf,userid,productCategoryBId,type);
		return selectProductQuotation;
	}

	public List<ProductRecord> selectProductMine(String userid) {
		return productMapper.selectProductMine(userid);
	}
	
	public int insertproductQuotationB(ProductImage productQuotationB) {		
		return productMapper.insertproductQuotationB(productQuotationB);
	}

	public List<ProductImage> selectProductQuotationB(String id) {
		return productMapper.selectProductQuotationB(id,UserUtils.getPrincipal().getId());
	}

	public void deleteProductQuotationB(String id,String dir) {
		ProductImage productQuotationB = productMapper.selectProductQuotationBbyId(id);
		String imageUrl = dir+productQuotationB.getImageUrl().replace("\\", "/");		
		*//*boolean deleteFile = FileUpLoad.deleteFile(imageUrl);
		if(deleteFile){
			productMapper.deleteProductQuotationB(id);
		}*//*
	}

	public void updateProductQuotation(String id, String address, String dir) {
		ProductRecord productRecord = productMapper.selectProductGetImgById(id);
		productRecord.setId(id);
		if(StringUtils.isNotBlank(productRecord.getIndexImgUrl())){
			//String imageUrl = dir+productRecord.getIndexImgUrl().replace("/", "\\");
			String imageUrl = dir.replace("\\", "/")+productRecord.getIndexImgUrl();
		*//*	boolean deleteFile = FileUpLoad.deleteFile(imageUrl);
			if(deleteFile){
				productRecord.setIndexImgUrl(address);
				productMapper.updateProduct(productRecord);
			}*//*
			return;
		}
		productRecord.setIndexImgUrl(address);
		productMapper.updateProduct(productRecord);
	}

	public void insertProductMine(String productid) {
		Principal principal = (Principal) UserUtils.getPrincipal();
		String userid =principal.getId();
		productMapper.insertProductMine(userid,productid);
	}

	public void deleteProductMine(String userid, String productid) {
		productMapper.deleteProductMine(userid,productid);
	}
	
	public List<ProductRecord> selectAssembly(String id){
		return productMapper.selectAssembly(id);
	}*/

	

	


	
	
}
