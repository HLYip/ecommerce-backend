package com.hlyip.springbootecommercebackend.controller;

import com.hlyip.springbootecommercebackend.dto.Purchase;
import com.hlyip.springbootecommercebackend.dto.PurchaseResponse;
import com.hlyip.springbootecommercebackend.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:8000")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;

    }

    @GetMapping("/purchase")
    public String test(){

        return "this route works";
    }



}
