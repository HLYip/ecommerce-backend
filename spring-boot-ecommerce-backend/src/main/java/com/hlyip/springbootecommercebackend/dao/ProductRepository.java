package com.hlyip.springbootecommercebackend.dao;

import com.hlyip.springbootecommercebackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


}
