package com.vikings.gym.service;

import com.vikings.gym.model.Purchase;
import com.vikings.gym.repository.PurchaseRepository;
import com.vikings.gym.repository.projection.PurchaseItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseService implements IPurchaseService {
    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }
    @Override
    public Purchase savePurchase(Purchase purchase){
        purchase.setCreateTime(LocalDateTime.now());
        return purchaseRepository.save(purchase);
    }
    @Override
    public List<PurchaseItem> findPurchaseOfUser(Long userId)
    {
        return purchaseRepository.finAllPurchasesOfUser(userId);
    }

}
