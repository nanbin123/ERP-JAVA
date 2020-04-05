package com.efss.controller;



import com.efss.controller.base.BaseController;
import com.efss.entity.ResponseState;
import com.efss.entity.finance.FinancialAccountingB;
import com.efss.entity.finance.ProfitList;
import com.efss.entity.user.Principal;
import com.efss.service.FinancialAccountingService;
import com.efss.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *  财务记账
 */
@CrossOrigin
@Controller
@RequestMapping("financial")
public class FinancialAccountingController extends BaseController {
	
	@Autowired
	private FinancialAccountingService financialAccountingService;


	//财务记账查询
	@RequiresPermissions("bookkeeping:all")
	@RequestMapping(value="/selectFinancialAccounting",method=RequestMethod.POST)
	@ResponseBody
	public Object selectFinancialAccounting(String page,String limit,String[]  dataDictionaryId,String type,String yearMosDay){
		PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(limit));
		List<FinancialAccountingB> selectCascade = financialAccountingService.selectFinancialAccounting(dataDictionaryId,type,yearMosDay);
		return buildPageSuccess((Page<FinancialAccountingB>) selectCascade);
	}


	//财务记账添加
	@RequiresPermissions("bookkeeping:all")
	@RequestMapping(value="insert",method=RequestMethod.POST)
	@ResponseBody
	public Object insert(String json){
		FinancialAccountingB financialAccounting = JsonUtils.parseObject(json,FinancialAccountingB.class);
		if(financialAccounting.getNumber() ==null || String.valueOf(financialAccounting.getNumber())==""){
            financialAccounting.setNumber(1);
        }
		if(StringUtils.isNotBlank(financialAccounting.getMoneya())){
			financialAccounting.setType("s");//收入金额
			BigDecimal money = new BigDecimal(financialAccounting.getMoneya()).setScale(2,BigDecimal.ROUND_HALF_UP);
			financialAccounting.setMoney(money);
		}else if(StringUtils.isNotBlank(financialAccounting.getMoneyb())){
			financialAccounting.setType("z");//支出金额
			BigDecimal money = new BigDecimal(financialAccounting.getMoneyb()).setScale(2,BigDecimal.ROUND_HALF_UP);
			financialAccounting.setMoney(money);
		}
		financialAccounting.setId(IdGen.uuid());
		Principal principal = (Principal) UserUtils.getPrincipal();
		String userid =principal.getId();
		financialAccounting.setUserid(userid);
		financialAccounting.setCreateDate(new Date());
		financialAccountingService.insert(financialAccounting);
		return buildInsterSuccess();
	}



	@RequiresPermissions("bookkeeping:all")
	@RequestMapping(value="/updateDeleteflagByid",method=RequestMethod.POST)
	@ResponseBody
	public ResponseState updateDeleteflagByid(String id){		
		 int updateDeleteflagByid = financialAccountingService.updateDeleteflagByid(id);
		 ResponseState responseState = new ResponseState();
		 if(updateDeleteflagByid>0){
			 responseState.setState("200");
			 responseState.setMsg("作废成功");
			 return responseState;
		 }
		return responseState;
	}
	
	/**
	 * 盈亏表查询
	 * @param yearmos
	 * @param sysAreaid
	 * @return
	 */
	@RequestMapping(value="selectProfit",method=RequestMethod.POST)
	@ResponseBody
	public ProfitList selectProfit(String yearmos, String sysAreaid){
		if(yearmos == null||"".equals(yearmos)){
			yearmos = DateUtil.getString(new Date(), DateTypeEnum._yM);
		}
		ProfitList profitList=financialAccountingService.selectProfit(yearmos,sysAreaid);
		return profitList==null?new ProfitList():profitList;
	}
	
	

}
