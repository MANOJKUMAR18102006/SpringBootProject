package com.example.Smart_Canteen_Ordering_and_Billing_System.repository;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByCategory(String category);
    List<MenuItem> findByAvailable(boolean available);
}