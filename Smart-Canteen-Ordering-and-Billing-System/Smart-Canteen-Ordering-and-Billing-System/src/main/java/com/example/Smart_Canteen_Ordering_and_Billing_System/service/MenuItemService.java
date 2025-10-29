package com.example.Smart_Canteen_Ordering_and_Billing_System.service;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.MenuItem;
import com.example.Smart_Canteen_Ordering_and_Billing_System.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuItemService {
    
    @Autowired
    private MenuItemRepository menuItemRepository;
    
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }
    
    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }
    
    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }
    
    public List<MenuItem> getAvailableItems() {
        return menuItemRepository.findByAvailable(true);
    }
}