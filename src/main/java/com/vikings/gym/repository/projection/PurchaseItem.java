package com.vikings.gym.repository.projection;

import java.time.LocalDateTime;

public interface PurchaseItem {
    Double getPrice();
    LocalDateTime getPurchaseTime();
}
