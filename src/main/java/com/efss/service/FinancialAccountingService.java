package com.efss.service;

import java.util.Date;
import java.util.List;

import com.efss.entity.finance.FinancialAccountingB;
import com.efss.entity.finance.ProfitList;
import com.efss.mapper.FinancialAccountingMapper;
import com.efss.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FinancialAccountingService extends BaseService{


	@Autowired
	private FinancialAccountingMapper financialAccountingMapper;
	
    public void insert(FinancialAccountingB record){
			financialAccountingMapper.insertFinancialAccountingB(record);
    }
    

	public List<FinancialAccountingB> selectFinancialAccounting(String[] dataDictionaryId, String type, String yearMosDay){
		return financialAccountingMapper.selectFinancialAccounting(dataDictionaryId,type,yearMosDay);
	}


	public int updateDeleteflagByid(String id) {		
		return financialAccountingMapper.updateDeleteflagByid(id);
	}


	public ProfitList selectProfit(String yearmos, String sysAreaid) {
		return financialAccountingMapper.selectProfit(yearmos,sysAreaid);
	}
}
