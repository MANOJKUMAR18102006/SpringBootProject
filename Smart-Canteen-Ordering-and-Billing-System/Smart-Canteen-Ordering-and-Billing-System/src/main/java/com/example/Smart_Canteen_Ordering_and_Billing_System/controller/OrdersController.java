package com.example.Smart_Canteen_Ordering_and_Billing_System.controller;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.Orders;
import com.example.Smart_Canteen_Ordering_and_Billing_System.Dto.OrderDto;
import com.example.Smart_Canteen_Ordering_and_Billing_System.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    
    @Autowired
    private OrdersService ordersService;
    
    @PostMapping
    public Orders createOrder(@RequestBody OrderDto orderDto) {
        return ordersService.createOrderFromDto(orderDto);
    }
    
    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }
    
    @GetMapping("/{id}")
    public Orders getOrder(@PathVariable Long id) {
        return ordersService.getOrderById(id);
    }
}