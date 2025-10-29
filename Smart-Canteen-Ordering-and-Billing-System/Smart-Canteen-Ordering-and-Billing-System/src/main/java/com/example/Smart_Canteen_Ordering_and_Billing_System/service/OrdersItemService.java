package com.example.Smart_Canteen_Ordering_and_Billing_System.service;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.OrdersItem;
import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.Orders;
import com.example.Smart_Canteen_Ordering_and_Billing_System.repository.OrdersItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdersItemService {
    
    @Autowired
    private OrdersItemRepository ordersItemRepository;
    
    public OrdersItem saveOrderItem(OrdersItem orderItem) {
        return ordersItemRepository.save(orderItem);
    }
    
    public List<OrdersItem> getOrderItemsByOrder(Orders order) {
        return ordersItemRepository.findByOrder(order);
    }
}