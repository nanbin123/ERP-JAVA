package com.efss.mapper;

import java.util.List;

import com.efss.entity.customer.Customer;
import com.efss.entity.customer.CustomerArrival;
import com.efss.entity.customer.Query;
import org.apache.ibatis.annotations.Param;


public interface CustomerMapper {

	List<Customer> selectCustOmer(Query query);

	List<CustomerArrival> selectCustomerArrival(@Param("id") String id,@Param("arrivalType") String arrivalType);

	int insertCustomerArrival(CustomerArrival customerArrival);

	/*Customer selectCustomerByid(@Param("id") String id);

	List<CustomerProduct> selectCustomerProduct(@Param("id") String id, @Param("isOrderProduct") String isOrderProduct);



	List<CustomerTailafter> selectCustomerTailafter(@Param("id") String id);

	void insertCustomerProduct(CustomerProduct customerProduct);
	
	void updateCustomerProductById(@Param("id") String id, @Param("number") String number);

	void insertCustomerTailafter(CustomerTailafter customerTailafter);

	void updateCustomerTailafter(CustomerTailafter customerTailafter);



	void updateCustomerArrival(CustomerArrival customerArrival);

	void updateCustomerByid(Customer customer);

	void deleteCustomerProductById(@Param("id") String id);
	
	void inserorder(Order order);

	Customer selectTotalMoney(@Param("id") String id);
	
	String selectDiscount(String selectUserId);

	Customer selectOrder(@Param("id") String id);
	
	List<Relation> selectRelation(@Param("id") String id);
	
	Customer selectApproveOrder(@Param("id") String id, @Param("userid") String userid);
	
	List<Approve> selectApprove(@Param("id") String id);

	void insertCustomer(Customer customer);

	List<Customer> selectReceivablesOrder(@Param("custnameOrPhone") String custnameOrPhone, @Param("id") String id);

	void insertReceoved(Received received);

	Received selectReceovedById(@Param("id") String id, @Param("userid") String userid);
	
	List<Approve> selectReceovedApprove(@Param("id") String id);

	void insertSalesreturn(Salesreturn salesreturn);

	void insertSalesreturnProduct(SalesreturnProduct salesreturnProduct);

	List<Salesreturn> selectSalesreturn(@Param("custnameOrPhone") String custnameOrPhone);

	Salesreturn selectSalesreturnById(@Param("id") String id, @Param("userid") String userid);

	List<SalesreturnProduct> selectSalesreturnProduct(@Param("id") String id);

	List<Approve> selectReturnApprove(@Param("id") String id);
	
	
	List<PaymenApprove> selectPaymentApprove(@Param("id") String id);
	

	void insertPayment(Payment payment);

	Payment selectPaymentById(@Param("id") String id, @Param("userid") String userid);

	void insertPaymentVoucher(PaymentVoucher paymentVoucher);

	List<PaymentVoucher> selectPaymentVoucher(@Param("paymentId") String paymentId, @Param("userid") String userid);

	String getReceivable(@Param("ordersId") String ordersId);

	List<SalesKanban> salectArea(SalesKanban salesKanban);

	List<SalesKanbanB> salectStorefrontAchievement(@Param("id") String id, @Param("timeFrame") String timeFrame);
	
	List<SalesKanbanB> salectUserAchievement(@Param("id") String id, @Param("timeFrame") String timeFrame);

	String selectGradeId(@Param("userid") String userid, @Param("name") String name);
	
	void insertGrade(Grade grade);
	
	void insertGradeB(GradeB GradeB);
	
	List<GradeB> selectGrade(@Param("name") String name, @Param("userid") String userid);
	
	String selectCountByGradeId(@Param("gradeId") String gradeId);
	
	int  deleteGrade(@Param("id") String id);
	
	int deleteGradeB(@Param("id") String id, @Param("gradeId") String gradeId);

	List<String> selectGradeMe(@Param("name") String name, @Param("userid") String userid);*/
	
}
