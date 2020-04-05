package com.efss.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.efss.controller.base.BaseController;
import com.efss.entity.customer.Customer;
import com.efss.entity.customer.CustomerArrival;
import com.efss.entity.customer.Query;
import com.efss.entity.finance.FinancialAccountingB;
import com.efss.service.CustomerService;
import com.efss.utils.IdGen;
import com.github.pagehelper.Page;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;


/**客户模块*/
@CrossOrigin
@Controller
@ResponseBody
@RequestMapping("customer")
public class CustomerController extends BaseController {

	@Resource
	private CustomerService queryCustService;

    
    /*查询客户列表*/
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="selectCustOmer",method=RequestMethod.POST)
	public Object selectCustOmer(Query query) {
		PageHelper.startPage(Integer.valueOf(query.getPage()), Integer.valueOf(query.getLimit()));
    	List<Customer> selectCustOmer = queryCustService.selectCustOmer(query);
		return buildPageSuccess((Page<Customer>) selectCustOmer);
	}

	//*通过客户id查询跟踪明细和到店明细*/
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="selectCustomerTAByid",method=RequestMethod.POST)
    public Object selectCustomerTAByid(String id, String arrivalType,String page, String limit) {
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(limit));
        List<CustomerArrival> customerArrivalList=queryCustService.selectCustomerTAByid(id,arrivalType);
        return buildPageSuccess((Page<CustomerArrival>) customerArrivalList);
    }

	//添加到店记录
	@RequiresPermissions("customer:saveandlist")
	@RequestMapping(value="insertCustomerArrival",method=RequestMethod.POST)
	public Object insertCustomerArrival(CustomerArrival customerArrival){
		customerArrival.setId(IdGen.uuid());
		queryCustService.insertCustomerArrival(customerArrival);
		return buildInsterSuccess();
	}


	/*    *//*通过id查询客户明细*//*
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="selectCustomerByid",method=RequestMethod.POST)
	public Customer selectCustomerByid(String id) {
		return queryCustService.selectCustomerByid(id);
	}

    
    *//*通过id修改客户明细*//*
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="updateCustomerByid",method=RequestMethod.POST)
    public ResponseState updateCustomer(Customer customer){
    	 ResponseState responseState = new ResponseState();
    	 queryCustService.updateCustomerByid(customer);
    	 responseState.setState("200");
		return responseState;
    }*/
    
   /* //添加预购产品
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="insertCustomerProduct",method=RequestMethod.POST)
  	public ResponseState insertCustomerProduct(String json) {
    	 List<CustomerProduct> list=JSON.parseArray(json, CustomerProduct.class);
    	 ResponseState responseState = new ResponseState();
    	 queryCustService.insertCustomerProduct(list);
    	 responseState.setState("200");
  		return responseState;
  	}
    
    //修改预购产品
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="updateCustomerProductById",method=RequestMethod.POST)
    public ResponseState updateCustomerProductById(String id,String number){
    	 ResponseState responseState = new ResponseState();
    	 queryCustService.updateCustomerProductById(id,number);
    	 responseState.setState("200");
		return responseState;
	}
    
    //删除预购产品
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="deleteCustomerProductById",method=RequestMethod.POST)
    public ResponseState deleteCustomerProductById(String id){
    	 ResponseState responseState = new ResponseState();
    	 queryCustService.deleteCustomerProductById(id);
    	 responseState.setState("200");
		return responseState;
	}
    
    
    //添加跟踪记录
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="insertCustomerTailafter",method=RequestMethod.POST)
    public ResponseState insertCustomerTailafter(CustomerTailafter customerTailafter){
    	 ResponseState responseState = new ResponseState();
    	 customerTailafter.setId(IdGen.uuid());
    	 queryCustService.insertCustomerTailafter(customerTailafter);
    	 responseState.setState("200");
		 return responseState;
    }
    //修改跟踪记录
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="updateCustomerTailafter",method=RequestMethod.POST)
    public ResponseState updateCustomerTailafter(CustomerTailafter customerTailafter){
    	 ResponseState responseState = new ResponseState();
    	 queryCustService.updateCustomerTailafter(customerTailafter);
    	 responseState.setState("200");
		 return responseState;
    }
    
    

    //修改到店记录
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="updateCustomerArrival",method=RequestMethod.POST)
    public ResponseState updateCustomerArrival(CustomerArrival customerArrival){
    	 ResponseState responseState = new ResponseState();
    	 queryCustService.updateCustomerArrival(customerArrival);
    	 responseState.setState("200");
		 return responseState;
    }
    //我的客户去下单
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="inserorder",method=RequestMethod.POST)
    public ResponseState inserorder(Order order){
    	 ResponseState responseState = new ResponseState();
    	 order.setId(IdGen.uuid()+"-DD");
    	 order.setOrderNumber(DateUtil.getString(new Date(), DateTypeEnum.yMdHms));
    	 order.setPlaceOrderTime(new Date());
    	 order.setUserid(UserUtils.getPrincipal().getId());
    	 queryCustService.inserorder(order);
    	 responseState.setState("200");
		 return responseState;
    }
    //点击下单按钮为前台通过id找到客户和计算订单总金额与设置的折扣
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="selectTotalMoney",method=RequestMethod.POST)
    public Customer selectTotalMoney(String id){
    	Customer customer=queryCustService.selectTotalMoney(id);
		return customer;
    }
    
    //点击下单按钮查看订单详情
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="selectOrder",method=RequestMethod.POST)
    public Customer selectOrder(String id){
    	Customer customer=queryCustService.selectOrder(id);
		return customer;
    }
    
    
    //保存客户信息
	@RequiresPermissions("customer:saveandlist")
    @RequestMapping(value="insertCustomer",method=RequestMethod.POST)
    public ResponseState insertCustomer(Customer customer){
    	ResponseState responseState = new ResponseState();
    	customer.setId(IdGen.uuid());
    	customer.setUserid(UserUtils.getPrincipal().getId());
    	customer.setCreateDate(new Date());
    	queryCustService.insertCustomer(customer);
    	responseState.setMsg("保存客户成功");
    	responseState.setState("200");
		return responseState;
    }
    
    //收款单,退货单查询订单
	@RequiresPermissions(value={"commonlyused:receivables","salesreturn:save"},logical=Logical.OR)	
    @RequestMapping(value="selectReceivablesOrder",method=RequestMethod.POST)
    public PageBean<Customer>  selectReceivablesOrder(String pageNo,String pageSize,String custnameOrPhone){
    	PageHelper.startPage(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
    	List<Customer> list=queryCustService.selectReceivablesOrder(custnameOrPhone);
    	 PageBean<Customer> pageBean = new PageBean<Customer>(list);
		return pageBean;
    }
    
	
    //根据id查询收款單退货单查询订单
	@RequiresPermissions("commonlyused:receivables")
    @RequestMapping(value="selectReceivablesOrderByid",method=RequestMethod.POST)
    public Object  selectReceivablesOrderByid(String id){
         Customer customer=queryCustService.selectReceivablesOrderByid(id);
		return customer;
    } 
    
	
    //收款单保存
	@RequiresPermissions("commonlyused:receivables")
    @RequestMapping(value="insertReceoved",method=RequestMethod.POST)
    public ResponseState insertReceoved(Received received,
    		@RequestParam("pictureFile")MultipartFile[] pictureFile,HttpServletRequest request){
    	ResponseState responseState = new ResponseState();
    	String uuid = IdGen.uuid();
    	if(pictureFile!=null&&pictureFile.length>0){//文件上传
    		String url = FileUpLoad.uploading(pictureFile,uuid, request);
        	received.setVoucher(url);
    	}
    	received.setId(uuid);
    	received.setCreateDate(new Date());
    	received.setUserid(UserUtils.getPrincipal().getId());
    	received.setSerialNumber(DateUtil.getString(new Date(), DateTypeEnum.yMdHms));    	
    	queryCustService.insertReceoved(received);
    	responseState.setMsg("保存收款单成功");
    	responseState.setState("200");
		return responseState;
    }
    
    //退款退货保存
	@RequiresPermissions("salesreturn:save")
    @RequestMapping(value="insertSalesreturn",method=RequestMethod.POST)
    public ResponseState insertSalesreturn(String json){
    	Salesreturn salesreturn=JSON.parseObject(json, Salesreturn.class);
    	ResponseState responseState = new ResponseState();
    	salesreturn.setId(IdGen.uuid());
    	salesreturn.setUserid(UserUtils.getPrincipal().getId());
    	salesreturn.setCreateDate(new Date());
    	salesreturn.setSalesreturnNumber(DateUtil.getString(new Date(), DateTypeEnum.yMdHms));
    	queryCustService.insertSalesreturn(salesreturn);
    	responseState.setMsg("保存退款退货单成功");
    	responseState.setState("200");
		return responseState;
    }
    //退款退货列表查询
    @RequiresPermissions("salesreturn:list")
    @RequestMapping(value="selectSalesreturn",method=RequestMethod.POST)
    public Object selectSalesreturn(String pageNo,String pageSize,String custnameOrPhone){
    	PageHelper.startPage(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
    	List<Salesreturn> list=queryCustService.selectSalesreturn(custnameOrPhone);
    	PageBean<Salesreturn> pageBean = new PageBean<Salesreturn>(list);
		return pageBean;
    }
    
    //退款退货根据id查询明细查询
    @RequiresPermissions("salesreturn:list")
    @RequestMapping(value="selectSalesreturnById",method=RequestMethod.POST)
    public Object selectSalesreturnById(String id){
    	Salesreturn salesreturn=queryCustService.selectSalesreturnById(id);
		return salesreturn;
    }
    //付款单保存
    @RequiresPermissions("commonlyused:payment")
    @RequestMapping(value="insertPayment",method=RequestMethod.POST)
    public Object insertPayment(Payment payment){
    	ResponseState responseState = new ResponseState();
    	payment.setId(IdGen.uuid());
    	payment.setCreateDate(new Date());
    	payment.setUserid(UserUtils.getPrincipal().getId());
    	payment.setSerialNumber(DateUtil.getString(new Date(), DateTypeEnum.yMdHms));
    	queryCustService.insertPayment(payment);
    	responseState.setMsg("保存付款单成功");
    	responseState.setState("200");
		return responseState;
    }
    
    //付款单通过id查询明细
    @RequiresPermissions("commonlyused:payment")
    @RequestMapping(value="selectPaymentById",method=RequestMethod.POST)
    public Object selectPaymentById(String id){
    	Payment payment=queryCustService.selectPaymentById(id);
		return payment;
    }
    
    //付款单审批人添加凭证
    @RequestMapping(value="insertPaymentVoucher",method=RequestMethod.POST)
    public Object insertPaymentVoucher(PaymentVoucher paymentVoucher){
    	ResponseState responseState = new ResponseState();
    	paymentVoucher.setId(IdGen.uuid());
    	paymentVoucher.setUserid(UserUtils.getPrincipal().getId());
    	queryCustService.insertPaymentVoucher(paymentVoucher);
    	responseState.setMsg("付款单添加凭证成功");
    	responseState.setState("200");
		return responseState;
    }
    
    //销售看板查询   公司：所有区域下的店面        我的：我所在店下的所有人
  	@RequestMapping(value = "/salesRegion",method=RequestMethod.POST)
  	@ResponseBody
  	public Object salesRegion(String pageNo,String pageSize,String timeFrame){
  		SalesKanban salesKanban = new SalesKanban();
  		salesKanban.setType("3");
  		salesKanban.setTimeFrame(timeFrame);
  		PageHelper.startPage(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
  		List<SalesKanban> list=queryCustService.salectKanban(salesKanban);
  		PageBean<SalesKanban> pageBean = new PageBean<SalesKanban>(list);
  		return pageBean;
  	}
  	//销售看板查询团队 ---所有店面下的人
  	@RequestMapping(value = "/salesStorefront",method=RequestMethod.POST)
  	@ResponseBody
  	public Object salesStorefront(String pageNo,String pageSize,String timeFrame){
  		SalesKanban salesKanban = new SalesKanban();
  		salesKanban.setType("4");
  		salesKanban.setTimeFrame(timeFrame);
  		PageHelper.startPage(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
  		List<SalesKanban> list=queryCustService.salesStorefront(salesKanban);
  		PageBean<SalesKanban> pageBean = new PageBean<SalesKanban>(list);
  		return pageBean;
  	}
  	//销售看板查询我的--我所在店下的所有人
  	@RequestMapping(value = "/salesPeople",method=RequestMethod.POST)
  	@ResponseBody
  	public Object salesPeople(String timeFrame){
  		SalesKanban salesKanban = new SalesKanban();  
  		String storefrontid = UserUtils.getPrincipal().getStorefrontid();
  		String[] split = storefrontid.split(",");
  		String splitst=split[4];
  		salesKanban.setId(splitst);
  		salesKanban.setTimeFrame(timeFrame);
  		SalesKanban sales=queryCustService.salesPeople(salesKanban);
  		return sales;
  	}
  	
  	//添加授权人
	@RequestMapping(value = "/insertGrade",method=RequestMethod.POST)
	@ResponseBody
  	public Object insertGrade(String json){
		Grade grade=JSON.parseObject(json, Grade.class);
		ResponseState responseState = new ResponseState();
		grade.setId(IdGen.uuid());
		grade.setUserid(UserUtils.getPrincipal().getId());
		queryCustService.insertGrade(grade);
		responseState.setState("200");
		responseState.setMsg("添加授权人成功");
		return responseState;
	}
	
	//查询授权人
	@RequestMapping(value = "/selectGrade",method=RequestMethod.POST)
	@ResponseBody
	public List<GradeB> selectGrade(String name){
		List<GradeB> grade= queryCustService.selectGrade(name,UserUtils.getPrincipal().getId());
		return grade;
	}
	//删除授权人
	@RequestMapping(value = "/deleteGradeB",method=RequestMethod.POST)
	@ResponseBody
	public Object deleteGradeB(String gradeId,String id){
		int i = queryCustService.deleteGradeB(gradeId,id);
		ResponseState responseState = new ResponseState();
		if(i>0){
			responseState.setState("200");
			responseState.setMsg("删除授权人成功");
		}
		return responseState;		
	}
	//首页待处理单据数量提示
	@RequestMapping(value = "/selectToBeProcessed",method=RequestMethod.POST)
	@ResponseBody
	public Object selectToBeProcessed(){
		ArrayList<ToBeProcessed> arrayList = new ArrayList<ToBeProcessed>();
		ToBeProcessed toBeProcessed1 = new ToBeProcessed();
		toBeProcessed1.setBillName("customer");
		toBeProcessed1.setNumber(1);
		ToBeProcessed toBeProcessed2 = new ToBeProcessed();
		toBeProcessed2.setBillName("verifier");
		toBeProcessed2.setNumber(2);
		arrayList.add(toBeProcessed1);
		arrayList.add(toBeProcessed2);
		return arrayList;
	}*/
  	
}
