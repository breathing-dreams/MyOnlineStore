package com.example.MyCheckoutCounter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MyCheckoutCounter.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}
