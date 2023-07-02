package com.hlyip.springbootecommercebackend.dao;

import com.hlyip.springbootecommercebackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
