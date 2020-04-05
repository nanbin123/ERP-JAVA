package com.efss.mapper;
import java.util.Date;
import java.util.List;

import com.efss.entity.finance.FinancialAccountingB;
import com.efss.entity.finance.ProfitList;
import org.apache.ibatis.annotations.Param;



public interface FinancialAccountingMapper {


	int insertFinancialAccountingB(FinancialAccountingB record);
	
	List<FinancialAccountingB> selectFinancialAccounting(@Param("dataDictionaryId") String[] dataDictionaryId,
                                                         @Param("type") String type, @Param("yearMosDay") String yearMosDay);

	int updateDeleteflagByid(@Param("id") String id);

	ProfitList selectProfit(@Param("yearmos") String yearmos, @Param("sysAreaid") String sysAreaid);
   
}