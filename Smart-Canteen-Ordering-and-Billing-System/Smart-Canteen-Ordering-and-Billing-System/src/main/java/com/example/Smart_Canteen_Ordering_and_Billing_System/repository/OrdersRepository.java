package com.example.Smart_Canteen_Ordering_and_Billing_System.repository;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.Orders;
import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByUser(User user);
    List<Orders> findByStatus(String status);
}