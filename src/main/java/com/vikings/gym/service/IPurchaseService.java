package com.vikings.gym.service;

import com.vikings.gym.model.Purchase;
import com.vikings.gym.repository.projection.PurchaseItem;

import java.util.List;

public interface IPurchaseService {
    Purchase savePurchase(Purchase purchase);

    List<PurchaseItem> findPurchaseOfUser(Long userId);
}
