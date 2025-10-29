package com.example.Smart_Canteen_Ordering_and_Billing_System.repository;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.OrdersItem;
import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrdersItemRepository extends JpaRepository<OrdersItem, Long> {
    List<OrdersItem> findByOrder(Orders order);
}