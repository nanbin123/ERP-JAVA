package com.efss.mapper;

import java.util.List;

import com.efss.entity.product.*;
import org.apache.ibatis.annotations.Param;


public interface ProductMapper {


	List<ProductRecord> selectListProduct(QueryProduct queryProduct);

	List<ProductRecord> selectProductAssembly(@Param("productid")String productid);

	int insertProduct(ProductRecord productRecord);

	int insertAssembly(ProductAssembly productAssembly);

	List<ProductCategory> selectCategory();

	int insertProductCategory(ProductCategory productCategory);

	int updateProductCategory(ProductCategory productCategory);


	/*List<ProductRecord> selectProduct(@Param("nameOrtype") String nameOrtype, @Param("dsf") String dsf);




	
	void savecategory(@Param("id") String id, @Param("userid") String userid, @Param("category") String category);



	void updateCategory(@Param("id") String id, @Param("category") String category);
	     
	void deleteCategory(@Param("id") String id);

	List<ProductCategoryB> selectCategoryB(@Param("productCategoryId") String productCategoryId);

	void insertCategoryB(@Param("id") String id, @Param("productCategoryId") String productCategoryId,
                         @Param("category") String category, @Param("img") String img);

	void updateCategoryB(@Param("id") String id, @Param("category") String category);

	void deleteCategoryB(@Param("id") String id);



	void updateProduct(ProductRecord productRecord);
	
	List<ProductAnalysis> selectProductAnalysis(ProductAnalysis productAnalysis);

	List<ProductRecord> selectProductQuotation(@Param("dsf") String dsf, @Param("userid") String userid,
                                               @Param("productCategoryBId") String productCategoryBId, @Param("type") String type);

	List<ProductRecord> selectProductMine(@Param("userid") String userid);
	
	int insertproductQuotationB(ProductImage productQuotationB);

	List<ProductImage> selectProductQuotationB(@Param("id") String id, @Param("userid") String userid);

	void deleteProductQuotationB(@Param("id") String id);

	ProductImage selectProductQuotationBbyId(@Param("id") String id);

	ProductRecord selectProductGetImgById(@Param("id") String id);

	void insertProductMine(@Param("userid") String userid, @Param("productid") String productid);

	void deleteProductMine(@Param("userid") String userid, @Param("productid") String productid);


	
	List<ProductRecord> selectAssembly(@Param("id") String id);*/

	
}
