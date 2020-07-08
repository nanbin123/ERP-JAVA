package com.efss.mapper;

import com.efss.entity.purchase.PurchaseSupplier;

import java.util.List;

public interface PurchaseMapper {

    List<PurchaseSupplier> selectPurchaseSupplier();

    int insertPurchaseSupplier(PurchaseSupplier purchaseSupplier);

    int updatePurchaseSupplier(PurchaseSupplier purchaseSupplier);
}
