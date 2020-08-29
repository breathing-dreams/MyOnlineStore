package com.example.MyCheckoutCounter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MyCheckoutCounter.model.ProductCatalogue;

public interface ProdCatalogueRepository extends JpaRepository<ProductCatalogue, Long> {

}
