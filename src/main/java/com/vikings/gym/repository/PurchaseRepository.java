package com.vikings.gym.repository;

import com.vikings.gym.model.Purchase;
import com.vikings.gym.repository.projection.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
    @Query("select "+
            "ph.price as price, ph.createTime as purchaseTime  "+
            " from Purchase ph left join Program p on p.id=ph.programId "+
            "where ph.userId = :userId")
    List<PurchaseItem> finAllPurchasesOfUser(@Param("userId") Long userId);
}
