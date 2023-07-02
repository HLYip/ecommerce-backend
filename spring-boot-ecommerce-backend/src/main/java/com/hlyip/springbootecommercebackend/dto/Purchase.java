package com.hlyip.springbootecommercebackend.dto;

import com.hlyip.springbootecommercebackend.entity.Address;
import com.hlyip.springbootecommercebackend.entity.Customer;
import com.hlyip.springbootecommercebackend.entity.Order;
import com.hlyip.springbootecommercebackend.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;




}
