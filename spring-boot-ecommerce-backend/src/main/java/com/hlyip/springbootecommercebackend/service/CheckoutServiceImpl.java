package com.hlyip.springbootecommercebackend.service;

import com.hlyip.springbootecommercebackend.dao.CustomerRepository;
import com.hlyip.springbootecommercebackend.dto.Purchase;
import com.hlyip.springbootecommercebackend.dto.PurchaseResponse;
import com.hlyip.springbootecommercebackend.entity.Customer;
import com.hlyip.springbootecommercebackend.entity.Order;
import com.hlyip.springbootecommercebackend.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

   private CustomerRepository customerRepository;

   @Autowired
   public CheckoutServiceImpl(CustomerRepository customerRepository){
       this.customerRepository = customerRepository;
   }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
       //retrieve the order info from dto

        Order order = purchase.getOrder();

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderitems
        Set<OrderItem> orderItem = purchase.getOrderItems();
        orderItem.forEach(item -> order.add(item));

        //populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        //populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);
        //save to database
        customerRepository.save(customer);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);


    }

    private String generateOrderTrackingNumber() {
       // generate random id

        return UUID.randomUUID().toString();

    }
}
