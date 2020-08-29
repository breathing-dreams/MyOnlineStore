package com.example.MyCheckoutCounter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MyCheckoutCounter.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
