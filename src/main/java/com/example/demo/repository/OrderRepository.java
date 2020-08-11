package com.example.demo.repository;


import java.util.List;

import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM orders WHERE UPPER(customer) LIKE %?#{[0].toUpperCase()}%", nativeQuery = true)
    List<Order> findOrderByCustomer(String customer);
}