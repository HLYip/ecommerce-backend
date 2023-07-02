package com.hlyip.springbootecommercebackend.service;

import com.hlyip.springbootecommercebackend.dto.Purchase;
import com.hlyip.springbootecommercebackend.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
