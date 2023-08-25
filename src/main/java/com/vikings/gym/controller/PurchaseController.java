package com.vikings.gym.controller;

import com.vikings.gym.model.Purchase;
import com.vikings.gym.security.UserPrincipal;
import com.vikings.gym.service.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController
{
    @Autowired
    private IPurchaseService purchaseService;
    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase)
    {
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> geAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal)
    {
        return ResponseEntity.ok(purchaseService.findPurchaseOfUser(userPrincipal.getId()));
    }
}
