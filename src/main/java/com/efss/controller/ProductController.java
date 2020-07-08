package com.efss.controller;

import java.util.*;


import com.alibaba.fastjson.JSON;
import com.efss.controller.base.BaseController;

import com.efss.entity.product.*;

import com.efss.service.ProductService;
import com.efss.utils.IdGen;
import com.efss.utils.UserUtils;
import com.github.pagehelper.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageHelper;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/*产品增减*/
@CrossOrigin
@RestController
@RequestMapping("product")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;


	/**
	 * 产品查询
	 * @return
	 */
	@RequiresPermissions("product:all")
	@PostMapping(value="selectListProduct")
	public Object selectListProduct(QueryProduct queryProduct, String page, String limit){
		    PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(limit));
			List<ProductRecord> selectProduct = productService.selectListProduct(queryProduct);
/*		ProductRecord productRecord=new ProductRecord();
		productRecord.setProductName("测试啊");
		List<ProductRecord> recordList= new ArrayList<ProductRecord>();
		recordList.add(productRecord);
		selectProduct.get(0).setRecordList(recordList);*/
			return  buildPageSuccess((Page<ProductRecord>) selectProduct);
	}

	/**
	 * 产品增减保存
	 * @return
	 */
	@RequiresPermissions("product:all")
	@RequestMapping(value="insertProduct",method=RequestMethod.POST)
	public Object insertProduct(String json,@RequestParam("pictureFile") MultipartFile[] pictureFile,
								HttpServletRequest request){
		ProductRecord productRecord = JSON.parseObject(json, ProductRecord.class);
		productRecord.setId(IdGen.uuid());
        productRecord.setCreateDate(new Date());
		productRecord.setUserid(UserUtils.getPrincipal().getId());
		productService.insertProduct(productRecord);
		return  buildInsterSuccess();
	}
	//添加子件
	@RequiresPermissions("product:all")
	@RequestMapping(value="insertAssembly",method=RequestMethod.POST)
	public Object insertAssembly(String json){
		ProductRecord productRecord = JSON.parseObject(json, ProductRecord.class);
		int i=productService.insertAssembly(productRecord);
		if(i>0){
			return buildInsterSuccess();
		}
		return buildJsonWrapErr();
	}

	//产品类型查询
	@RequiresPermissions("product:all")
	@PostMapping(value = "selectCategory")
	public Object selectCategory() {
		List<ProductCategory> category = productService.selectCategory();
		return buildJsonSuccess(category);
	}
	//产品类型新增
	@RequiresPermissions("product:all")
	@PostMapping("insertProductCategory")
	public Object insertProductCategory(ProductCategory productCategory){
		productCategory.setId(IdGen.uuid());
		String userid = UserUtils.getPrincipal().getId();
		productCategory.setUserid(userid);
		int result=productService.insertProductCategory(productCategory);
		if(result>0){
			return buildInsterSuccess();
		}
		return buildJsonWrapErr();
	}
	//产品类型修改
	@RequiresPermissions("product:all")
	@PostMapping("updateProductCategory")
	public Object updateProductCategory(ProductCategory productCategory){
		int result=productService.updateProductCategory(productCategory);
		if(result>0){
			return buildInsterSuccess();
		}
		return buildJsonWrapErr();
	}













	/**	
	 * 产品查询导入产品
	 */
	/*@RequestMapping(value="queryProduct",method=RequestMethod.POST)
	public Object selectProduct(String nameOrtype,String pageNo,String pageSize){
		PageHelper.startPage(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		List<ProductRecord> selectProduct = productService.selectProduct(nameOrtype);
		PageBean<ProductRecord> pageBean = new PageBean<ProductRecord>(selectProduct);
		return pageBean;	
	}*/

	
	
	
	

	/**
	 * 产品增减修改
	 * @return
	 */
/*	@RequiresPermissions("product:all")
	@RequestMapping(value="updateProduct",method=RequestMethod.POST)
	public String updateProduct(ProductRecord productRecord,@RequestParam("pictureFile")MultipartFile[] pictureFile,
			HttpServletRequest request){
		String address = FileUpLoad.uploading(pictureFile,IdGen.uuid(), request);
		String dir = request.getSession().getServletContext().getRealPath("/");
		productService.updateProduct(productRecord,address,dir);
		return  "{\"mes\":\"ok\"}";
	}*/
	
	//产品增减类型保存
/*	@RequiresPermissions("product:all")
	@RequestMapping(value = "createcategory",method=RequestMethod.POST)
	public String createcategory(String  category) {
		productService.savecategory(category);	
		return "{\"mes\":\"ok\"}";
	}*/





	
/*	//产品增减类型修改（主类）
	@RequiresPermissions("product:all")
	@RequestMapping(value = "updateCategory",method=RequestMethod.POST)	
	public String updateCategory(String id,String category){		
		productService.updateCategory(id,category);
		return "{\"mes\":\"ok\"}";		
	}
	//产品增减类型删除（主类）
	@RequiresPermissions("product:all")
	@RequestMapping(value = "deleteCategory",method=RequestMethod.POST)	
	public String deleteCategory(String id){		
		productService.deleteCategory(id);
		return "{\"mes\":\"ok\"}";		
	}
	//产品增减类型查询（子类）
	@RequiresPermissions("product:all")
	@RequestMapping(value = "selectCategoryB",method=RequestMethod.POST)
	public List<ProductCategoryB> selectCategoryB(String productCategoryId){
		return productService.selectCategoryB(productCategoryId);	
	}
	*/
	/*//产品增减类型保存（子类）
	@RequiresPermissions("product:all")
	@RequestMapping(value = "insertCategoryB",method=RequestMethod.POST)	
	public String insertCategoryB(String productCategoryId,String  category,String img) {
		productService.insertCategoryB(productCategoryId,category,img);		
		return "{\"mes\":\"ok\"}";
	}
	//产品增减类型修改（子类）
	@RequiresPermissions("product:all")
	@RequestMapping(value = "updateCategoryB",method=RequestMethod.POST)
	public String updateCategoryB(String id,String category){		
		productService.updateCategoryB(id,category);
		return "{\"mes\":\"ok\"}";		
	}
	@RequiresPermissions("product:all")
	@RequestMapping(value = "deleteCategoryB",method=RequestMethod.POST)	
	public String deleteCategoryB(String id){		
		productService.deleteCategoryB(id);
		return "{\"mes\":\"ok\"}";		
	}
	
	//如果是组合的产品走这个接口
	@RequiresPermissions("product:all")
	@RequestMapping(value = "/selectAssemblyById",method=RequestMethod.POST)
	@ResponseBody
	public ProductRecord selectAssemblyById(String id){
		QueryProduct queryProduct = new QueryProduct();
		queryProduct.setId(id);
		List<ProductRecord> selectProduct = productService.selectListProduct(queryProduct);
		ProductRecord record = selectProduct.get(0);
		List<ProductRecord> list=productService.selectAssembly(id);
		record.setRecordList(list);
		return record;
	}
	*/
	
	//产品分析查询
/*	@RequestMapping(value = "/selectProductAnalysis",method=RequestMethod.POST)
	@ResponseBody
	public Object selectProductAnalysis(String pageNo, String pageSize, ProductAnalysis productAnalysis) throws IOException{
		PageHelper.startPage(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		List<ProductAnalysis> list=productService.selectProductAnalysis(productAnalysis);
		PageBean<ProductAnalysis> pageBean = new PageBean<ProductAnalysis>(list);
		return pageBean;
	}*/
	
	
	//价格单查询
	/*@RequestMapping(value = "/selectProductQuotation",method=RequestMethod.POST)
	@ResponseBody
	public Object selectProductQuotation(String productCategoryBId,String type,
			String pageNo,String pageSize,HttpServletRequest request) throws IOException{	
		PageHelper.startPage(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		List<ProductRecord> list=productService.selectProductQuotation(productCategoryBId,type);
		PageBean<ProductRecord> pageBean = new PageBean<ProductRecord>(list);
		return pageBean;
	}*/
	
	//app查询我的购物车
/*	@RequestMapping(value = "/selectProductMine",method=RequestMethod.POST)
	@ResponseBody
	public List<ProductRecord> selectProductMine(){
		String userid = UserUtils.getPrincipal().getId();
		List<ProductRecord> list=productService.selectProductMine(userid);
		return list;
	}*/
	
	
	//价格单单列表替换图片    
	/*	@RequestMapping(value = "/updateProductQuotation",method=RequestMethod.POST)
	@ResponseBody
	public String updateProductQuotation(@RequestParam("pictureFile")MultipartFile[] pictureFile,String id,HttpServletRequest request) throws IOException{
		ProductRecord productRecord =new ProductRecord();
		String address = FileUpLoad.uploading(pictureFile,IdGen.uuid(), request);
		String dir = request.getSession().getServletContext().getRealPath("/");
		productRecord.setId(id);
		productRecord.setIndexImgUrl(address);
		productService.updateProductQuotation(id,address,dir);
		return "{\"mes\":\"ok\"}";
	}*/
	//价格单单添加明细图片
/*	@RequestMapping(value="/insertProductQuotationB",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Integer> insertProductQuotationB(@RequestParam("pictureFile")MultipartFile[] pictureFile
			,String id,HttpServletRequest request){
		String uuid = IdGen.uuid();
		String productImgUrl = FileUpLoad.uploading(pictureFile,uuid, request);	
		ProductImage productImage = new ProductImage();
		productImage.setId(uuid);
		productImage.setUserid(UserUtils.getPrincipal().getId());
		productImage.setProductRecordId(id);
		productImage.setImageUrl(productImgUrl);
		int insertproductQuotationB = productService.insertproductQuotationB(productImage);
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("mes", insertproductQuotationB);
		return map;
	}*/
	
/*	//价格单单查询明细图片
	@RequestMapping(value="/selectProductQuotationB",method=RequestMethod.POST)
	@ResponseBody
	public List<ProductImage> selectProductQuotationB(String id){		
		List<ProductImage> list = productService.selectProductQuotationB(id);
		return list;
	}*/
	
	//价格单查删除明细图片
/*	@RequestMapping(value="/deleteProductQuotationB",method=RequestMethod.POST)
	@ResponseBody
	public String deleteProductQuotationB(String id,HttpServletRequest request){
		String dir = request.getSession().getServletContext().getRealPath("/");
		productService.deleteProductQuotationB(id,dir);
		return  "{\"mes\":\"ok\"}";
	}*/
	
	//app价格单加入我的购物车
/*	@RequestMapping(value="/insertProductMine",method=RequestMethod.POST)
	@ResponseBody
	public ResponseState insertProductMine(String productid){
		ResponseState responseState = new ResponseState();
		productService.insertProductMine(productid);
		responseState.setState("200");
		responseState.setMsg("加入wode购物车成功");
		return  responseState;
	}*/
	//app在我的购物单中删除
/*	@RequestMapping(value="/deleteProductMine",method=RequestMethod.POST)
	@ResponseBody
	public String deleteProductMine(String productid){
		String userid = UserUtils.getPrincipal().getId();
		productService.deleteProductMine(userid,productid);
		return  "{\"mes\":\"ok\"}";
	}*/
	
	//组合报价导入组件
/*	@RequestMapping(value = "/selectAssembly",method=RequestMethod.POST)
	@ResponseBody
	public List<ProductRecord> selectAssembly(){
		QueryProduct queryProduct = new QueryProduct();
		queryProduct.setIsAssembly("yes");
		List<ProductRecord> list= productService.selectListProduct(queryProduct);
		return list;
	}*/
	
	
	

		
	
	
	
	
	
	
}
