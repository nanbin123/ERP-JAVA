package com.efss.service;

import java.util.List;
import java.util.stream.Collectors;

import com.efss.entity.customer.Customer;
import com.efss.entity.customer.CustomerArrival;
import com.efss.entity.customer.Query;
import com.efss.mapper.CustomerMapper;
import com.efss.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;




@Service
public class CustomerService extends BaseService{

	@Autowired
	private CustomerMapper customerMapper;
	/*@Autowired
	private VerifierMapper verifierMapper;*/
	
	
	public List<Customer> selectCustOmer(Query query){
		List<Customer> list=customerMapper.selectCustOmer(query);
        //查找别人授权给我的
		/*List<String> strList=customerMapper.selectGradeMe("customer",UserUtils.getPrincipal().getId());
		String newStr = strList.stream().collect(Collectors.joining(","));
		query.setGradeMeUserid(newStr);*/
		return list;
	}

	public List<CustomerArrival> selectCustomerTAByid(String id,String arrivalType) {
		List<CustomerArrival> customerArrival = customerMapper.selectCustomerArrival(id,arrivalType);
		//List<CustomerTailafter> customerTailafter = customerMapper.selectCustomerTailafter(id);
		return customerArrival;
	}

	public int insertCustomerArrival(CustomerArrival customerArrival) {
		return customerMapper.insertCustomerArrival(customerArrival);
	}


	/*public Customer selectCustomerByid(String id) {
		 Customer customer = customerMapper.selectCustomerByid(id);
		 //no 包含0的 不是订单产品的
		 List<CustomerProduct> customerProduct = customerMapper.selectCustomerProduct(id,"no");
		 customer.setCustomerProducts(customerProduct);
		return customer;
	}

	
	
	
	public void insertCustomerProduct(List<CustomerProduct> list) {
		for (CustomerProduct customerProduct : list) {
			customerProduct.setId(IdGen.uuid()+"-YG");
			customerProduct.setNumber("0");
			customerMapper.insertCustomerProduct(customerProduct);
		}
		
	}
	
	public void updateCustomerProductById(String id,String number){
		customerMapper.updateCustomerProductById(id,number);
	}
	
	public void deleteCustomerProductById(String id) {
		customerMapper.deleteCustomerProductById(id);
	}
	
	
	public void insertCustomerTailafter(CustomerTailafter customerTailafter) {
		customerMapper.insertCustomerTailafter(customerTailafter);
		
	}
	public void updateCustomerTailafter(CustomerTailafter customerTailafter) {
		customerMapper.updateCustomerTailafter(customerTailafter);
		
	}

	public void updateCustomerArrival(CustomerArrival customerArrival) {
		customerMapper.updateCustomerArrival(customerArrival);
		
	}
	public void updateCustomerByid(Customer customer) {
		customerMapper.updateCustomerByid(customer);
	}
	public void inserorder(Order order) {
		//加载审批人
		NodeOne selectNodeOne = verifierMapper.selectNodeOne(UserUtils.getPrincipal().getId(), "在线下单");
		if(selectNodeOne!=null){
			order.setApproveId(selectNodeOne.getApproveId());
		}
		customerMapper.inserorder(order);
	}
	public Customer selectTotalMoney(String id) {
		Customer totalMoney = customerMapper.selectTotalMoney(id);
		String discount = customerMapper.selectDiscount(UserUtils.getPrincipal().getId());
		totalMoney.setDiscount(discount);
		*//*List<Approve> approveB = verifierMapper.selectApprove(UserUtils.getPrincipal().getId(), "在线下单");
		totalMoney.setApprove(approveB);*//*
		return totalMoney;
	}
	public Customer selectOrder(String id) {
		Customer order=customerMapper.selectOrder(id);
		List<Relation> relation=customerMapper.selectRelation(order.getId());
		order.setRelation(relation);
		//查询审核人
		List<Approve> approve = customerMapper.selectApprove(id);
		order.setApprove(approve);
		return order;
	}
	
	public Customer selectApproveOrder(String id) {
		Customer order=customerMapper.selectApproveOrder(id,UserUtils.getPrincipal().getId());
		//订单产品 yes是订单产品的
		List<CustomerProduct> customerProduct = customerMapper.selectCustomerProduct(id,"yes");
		order.setCustomerProducts(customerProduct);
		//查询审核人
		List<Approve> approve = customerMapper.selectApprove(id);
		order.setApprove(approve);
		return order;
	}
	public void insertCustomer(Customer customer) {
		customerMapper.insertCustomer(customer);
		
	}
	public List<Customer> selectReceivablesOrder(String custnameOrPhone) {
		List<Customer> list=customerMapper.selectReceivablesOrder(custnameOrPhone,null);
		return list;
	}
	
	public Customer selectReceivablesOrderByid(String id) {
		List<Customer> list=customerMapper.selectReceivablesOrder(null,id);
		for (Customer customer : list) {
			List<CustomerProduct> customerProduct = customerMapper.selectCustomerProduct(customer.getCustomerId(),"yes");
			customer.setCustomerProducts(customerProduct);
		}
		return list.get(0);
	}
	
	
	
	public void insertReceoved(Received received) {
		//加载审批人
		NodeOne selectNodeOne = verifierMapper.selectNodeOne(UserUtils.getPrincipal().getId(), "收款单");
		if(selectNodeOne!=null){
			received.setApproveId(selectNodeOne.getApproveId());
		}
		//通过order id得到已收款
		String receivable=customerMapper.getReceivable(received.getOrdersId());
		if(StringUtils.isNotBlank(receivable)){
			received.setReceivable(receivable);
		}
		customerMapper.insertReceoved(received);
	}
	
	//通过id查询收款单明细
    public Received selectReceovedById(String id){
    	Received received=customerMapper.selectReceovedById(id,UserUtils.getPrincipal().getId());
    	List<Approve> approveB = customerMapper.selectReceovedApprove(id);
    	received.setApprove(approveB);
		return received;
    }
	public void insertSalesreturn(Salesreturn salesreturn) {
		//加载审批人
		NodeOne selectNodeOne = verifierMapper.selectNodeOne(UserUtils.getPrincipal().getId(), "退货单");
		if(selectNodeOne!=null){
			salesreturn.setApproveId(selectNodeOne.getApproveId());
		}
		customerMapper.insertSalesreturn(salesreturn);
		List<SalesreturnProduct> list = salesreturn.getList();
		for (SalesreturnProduct salesreturnProduct : list) {
			salesreturnProduct.setId(IdGen.uuid());
			salesreturnProduct.setSalesreturnId(salesreturn.getId());
			customerMapper.insertSalesreturnProduct(salesreturnProduct);
		}
		
	}
	public List<Salesreturn> selectSalesreturn(String custnameOrPhone) {
		return customerMapper.selectSalesreturn(custnameOrPhone);
	}
	public Salesreturn selectSalesreturnById(String id) {
		Salesreturn salesreturn = customerMapper.selectSalesreturnById(id,UserUtils.getPrincipal().getId());
		//查询退货单审核人
		List<Approve> approve = customerMapper.selectReturnApprove(id);
		salesreturn.setApprove(approve);
		List<SalesreturnProduct> list=customerMapper.selectSalesreturnProduct(salesreturn.getId());
		salesreturn.setList(list);
		return salesreturn;
	}
	public void insertPayment(Payment payment) {
		//加载审批人
		NodeOne selectNodeOne = verifierMapper.selectNodeOne(UserUtils.getPrincipal().getId(), "付款单");
		if(selectNodeOne!=null){
			payment.setApproveId(selectNodeOne.getApproveId());
		}
		customerMapper.insertPayment(payment);
	}
	*//**
	 * @param id
	 * @return
	 *//*
	public Payment selectPaymentById(String id) {
		Payment payment = customerMapper.selectPaymentById(id,UserUtils.getPrincipal().getId());
		//查询付款单审核人
		List<PaymenApprove> approve = customerMapper.selectPaymentApprove(id);
		for (PaymenApprove paymenApprove : approve) {
			List<PaymentVoucher> paymentVoucher=customerMapper.selectPaymentVoucher(id,paymenApprove.getUserid());
			paymenApprove.setPaymentVoucher(paymentVoucher);
		}
		payment.setApprove(approve);
		return payment;
	}
	public void insertPaymentVoucher(PaymentVoucher paymentVoucher) {
		customerMapper.insertPaymentVoucher(paymentVoucher);
		
	}
	
	public List<SalesKanban> salectKanban(SalesKanban salesKanban) {
		String officeid = UserUtils.getPrincipal().getOfficeid();
		salesKanban.setOfficeid(officeid);
		List<SalesKanban> salesKanbanList=customerMapper.salectArea(salesKanban);
		//3  代表区域    查询区域下店面的业绩			
		for (SalesKanban sales : salesKanbanList) {			
			List<SalesKanbanB> list=customerMapper.salectStorefrontAchievement(sales.getId(),salesKanban.getTimeFrame());
			sales.setList(list);
		}	
		return salesKanbanList;
	}
	public List<SalesKanban> salesStorefront(SalesKanban salesKanban) {
		String officeid = UserUtils.getPrincipal().getOfficeid();
		salesKanban.setOfficeid(officeid);
		List<SalesKanban> salesKanbanList=customerMapper.salectArea(salesKanban);
		for (SalesKanban sales : salesKanbanList) {
			List<SalesKanbanB> list=customerMapper.salectUserAchievement(sales.getId(),salesKanban.getTimeFrame());
			sales.setList(list);
		}
		return salesKanbanList;
	}
	public SalesKanban salesPeople(SalesKanban salesKanban) {
		List<SalesKanban> salesKanbanList=customerMapper.salectArea(salesKanban);
		SalesKanban sales = salesKanbanList.get(0);
		List<SalesKanbanB> list=customerMapper.salectUserAchievement(sales.getId(),salesKanban.getTimeFrame());
		sales.setList(list);
		return sales;
	}
	
	public void insertGrade(Grade grade) {
		String id = customerMapper.selectGradeId(UserUtils.getPrincipal().getId(),grade.getName());
		if(StringUtils.isBlank(id)){
			customerMapper.insertGrade(grade);
			id=grade.getId();
		}
		List<GradeB> list = grade.getList();
		for (GradeB gradeB : list) {
			gradeB.setId(IdGen.uuid());
			gradeB.setGradeId(id);
			customerMapper.insertGradeB(gradeB);
		}
	}
	
	public List<GradeB> selectGrade(String name,String userid){
		return customerMapper.selectGrade(name,userid);
	}
	public int deleteGradeB(String gradeId,String id){
		String countid= customerMapper.selectCountByGradeId(gradeId);
		if("1".equals(countid)){
			customerMapper.deleteGrade(gradeId);
		}
		return customerMapper.deleteGradeB(id,gradeId);
	}*/
}
