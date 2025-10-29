package com.example.Smart_Canteen_Ordering_and_Billing_System.controller;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.MenuItem;
import com.example.Smart_Canteen_Ordering_and_Billing_System.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuItemController {
    
    @Autowired
    private MenuItemService menuItemService;
    
    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }
    
    @PostMapping
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.saveMenuItem(menuItem);
    }
    
    @GetMapping("/{id}")
    public MenuItem getMenuItem(@PathVariable Long id) {
        return menuItemService.getMenuItemById(id);
    }
    
    @GetMapping("/available")
    public List<MenuItem> getAvailableItems() {
        return menuItemService.getAvailableItems();
    }
}