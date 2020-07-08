package com.efss.controller;
import com.efss.controller.base.BaseController;
import com.efss.entity.purchase.PurchaseSupplier;
import com.efss.service.PurchaseService;
import com.efss.utils.IdGen;
import com.efss.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.List;

/**
 * 采购模块
 * @author nanbin
 */
@CrossOrigin
@Controller
@ResponseBody
@RequestMapping("purchase")
public class PurchaseController extends BaseController {
	@Autowired
	private PurchaseService purchaseService;


    /**
     * 查询供应商
     */
   @RequiresPermissions("purchase:all")
   @RequestMapping(value="selectPurchaseSupplier")
   public  Object selectPurchaseSupplier(){
       List<PurchaseSupplier> purchaseSupplier=purchaseService.selectPurchaseSupplier();
       if(purchaseSupplier !=null){
            return buildJsonSuccess(purchaseSupplier);
       }
	   return buildJsonWrapErr();
	}
    /**
     * 添加供应商
     */
    @RequiresPermissions("purchase:all")
    @RequestMapping(value="insertPurchaseSupplier")
    public  Object insertPurchaseSupplier(PurchaseSupplier purchaseSupplier){
        purchaseSupplier.setId(IdGen.uuid());
        purchaseSupplier.setUserid(UserUtils.getPrincipal().getId());
        purchaseSupplier.setDelflag("0");
        purchaseSupplier.setCreateDate(new Date());
       int resultInt=purchaseService.insertPurchaseSupplier(purchaseSupplier);
       if(resultInt>0){
           return buildInsterSuccess();
       }
        return buildJsonWrapErr();
    }

    /**
     * 修改供应商
     */
    @RequiresPermissions("purchase:all")
    @RequestMapping(value="updatePurchaseSupplier")
    public  Object updatePurchaseSupplier(PurchaseSupplier purchaseSupplier){
        int resultInt=purchaseService.updatePurchaseSupplier(purchaseSupplier);
        if(resultInt>0){
            return buildInsterSuccess();
        }
        return buildJsonWrapErr();
    }



}
