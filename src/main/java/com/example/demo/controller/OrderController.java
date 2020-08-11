package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.example.demo.exception.OrderException;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/order/{customer}")
    public List<Order> getAllOrders(@PathVariable(value="customer") String customer){
        List<Order> orders = orderRepository.findOrderByCustomer(customer);
        if(orders.isEmpty()) throw new OrderException();
        return orders;
    }

    @PostMapping("/order")
    public ResponseEntity<String> message(@Valid @NotNull @RequestBody Order order){
        orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.OK).body("Your order has been sent successfully, your registration number is ".concat(order.getId().toString()));
    }

    @PatchMapping("/order/{id}")
    public Order changeUnitById(@PathVariable(value="id") Long orderId, @RequestBody Order order){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent() == false) throw new OrderException();
        Order changedOrder = optionalOrder.get();
        changedOrder.setUnit(order.getUnit());
        return orderRepository.save(changedOrder);
    }
}