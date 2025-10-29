package com.example.Smart_Canteen_Ordering_and_Billing_System.service;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.*;
import com.example.Smart_Canteen_Ordering_and_Billing_System.Dto.OrderDto;
import com.example.Smart_Canteen_Ordering_and_Billing_System.Dto.OrderItemDto;
import com.example.Smart_Canteen_Ordering_and_Billing_System.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class OrdersService {
    
    @Autowired
    private OrdersRepository ordersRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private MenuItemRepository menuItemRepository;
    
    @Autowired
    private OrdersItemRepository ordersItemRepository;
    
    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }
    
    public Orders createOrderFromDto(OrderDto orderDto) {
        User user = userRepository.findById(orderDto.getUserId()).orElse(null);
        if (user == null) return null;
        
        Orders order = new Orders();
        order.setUser(user);
        order.setTotalAmount(orderDto.getTotalAmount());
        order = ordersRepository.save(order);
        
        List<OrdersItem> orderItems = new ArrayList<>();
        for (OrderItemDto itemDto : orderDto.getItems()) {
            MenuItem menuItem = menuItemRepository.findById(itemDto.getMenuItemId()).orElse(null);
            if (menuItem != null) {
                OrdersItem orderItem = new OrdersItem();
                orderItem.setOrder(order);
                orderItem.setMenuItem(menuItem);
                orderItem.setQuantity(itemDto.getQuantity());
                orderItem.setPrice(itemDto.getPrice());
                orderItems.add(ordersItemRepository.save(orderItem));
            }
        }
        order.setOrderItems(orderItems);
        return order;
    }
    
    public List<Orders> getOrdersByUser(User user) {
        return ordersRepository.findByUser(user);
    }
    
    public Orders getOrderById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }
    
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }
}