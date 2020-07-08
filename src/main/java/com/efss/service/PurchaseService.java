package com.efss.service;
import com.efss.entity.purchase.PurchaseSupplier;
import com.efss.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PurchaseService")
public class PurchaseService extends BaseService{
	
	@Autowired
	private PurchaseMapper purchaseMapper;

	

	public List<PurchaseSupplier> selectPurchaseSupplier() {
		return purchaseMapper.selectPurchaseSupplier();
	}


    public int insertPurchaseSupplier(PurchaseSupplier purchaseSupplier) {
		return purchaseMapper.insertPurchaseSupplier(purchaseSupplier);
    }

	public int updatePurchaseSupplier(PurchaseSupplier purchaseSupplier){
		return  purchaseMapper.updatePurchaseSupplier(purchaseSupplier);
	}
}
