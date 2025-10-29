package com.example.Smart_Canteen_Ordering_and_Billing_System.controller;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.OrdersItem;
import com.example.Smart_Canteen_Ordering_and_Billing_System.service.OrdersItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-items")
public class OrdersItemController {
    
    @Autowired
    private OrdersItemService ordersItemService;
    
    @PostMapping
    public OrdersItem addOrderItem(@RequestBody OrdersItem orderItem) {
        return ordersItemService.saveOrderItem(orderItem);
    }
}