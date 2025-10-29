package com.example.Smart_Canteen_Ordering_and_Billing_System.controller;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.*;
import com.example.Smart_Canteen_Ordering_and_Billing_System.service.OrdersService;
import com.example.Smart_Canteen_Ordering_and_Billing_System.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

@Controller
public class WebController {
    
    @Autowired
    private OrdersService ordersService;
    
    @Autowired
    private MenuItemRepository menuItemRepository;
    
    @Autowired
    private OrdersItemRepository ordersItemRepository;
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    
    @GetMapping("/web/menu")
    public String menu() {
        return "menu";
    }
    
    @GetMapping("/web/orders")
    public String orders(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/";
        }
        
        List<Orders> userOrders = ordersService.getOrdersByUser(loggedInUser);
        model.addAttribute("orders", userOrders);
        model.addAttribute("username", loggedInUser.getUsername());
        return "orders";
    }
    
    @GetMapping("/web/payment")
    public String payment() {
        return "payment";
    }
    
    @PostMapping("/web/payment")
    public String processPayment(@RequestParam String item, @RequestParam String quantity, @RequestParam String price, HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/";
        }
        
        // Store order details in session for payment page
        session.setAttribute("orderItem", item);
        session.setAttribute("orderQuantity", quantity);
        session.setAttribute("orderPrice", price);
        
        model.addAttribute("item", item);
        model.addAttribute("quantity", quantity);
        model.addAttribute("price", price);
        model.addAttribute("total", Integer.parseInt(price) * Integer.parseInt(quantity));
        
        return "payment";
    }
    
    @GetMapping("/receipt")
    public String receipt() {
        return "receipt";
    }
    
    @PostMapping("/receipt")
    public String processPaymentFinal(@RequestParam String paymentMethod, @RequestParam String customerName, HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/";
        }
        
        // Get order details from session
        String item = (String) session.getAttribute("orderItem");
        String quantity = (String) session.getAttribute("orderQuantity");
        String price = (String) session.getAttribute("orderPrice");
        
        if (item != null && quantity != null && price != null) {
            // Find or create MenuItem
            MenuItem menuItem = menuItemRepository.findAll().stream()
                .filter(mi -> mi.getName().equals(item))
                .findFirst()
                .orElseGet(() -> {
                    MenuItem newItem = new MenuItem();
                    newItem.setName(item);
                    newItem.setPrice(BigDecimal.valueOf(Integer.parseInt(price)));
                    newItem.setDescription("Menu item");
                    newItem.setCategory("Food");
                    return menuItemRepository.save(newItem);
                });
            
            // Create and save order
            Orders order = new Orders();
            order.setUser(loggedInUser);
            order.setTotalAmount(BigDecimal.valueOf(Integer.parseInt(price) * Integer.parseInt(quantity)));
            order.setStatus("COMPLETED");
            order = ordersService.saveOrder(order);
            
            // Create and save order item
            OrdersItem orderItem = new OrdersItem();
            orderItem.setOrder(order);
            orderItem.setMenuItem(menuItem);
            orderItem.setQuantity(Integer.parseInt(quantity));
            orderItem.setPrice(BigDecimal.valueOf(Integer.parseInt(price)));
            ordersItemRepository.save(orderItem);
            
            // Clear session data
            session.removeAttribute("orderItem");
            session.removeAttribute("orderQuantity");
            session.removeAttribute("orderPrice");
            
            // Add data to model for receipt
            model.addAttribute("item", item);
            model.addAttribute("quantity", quantity);
            model.addAttribute("price", price);
            model.addAttribute("total", Integer.parseInt(price) * Integer.parseInt(quantity));
            model.addAttribute("paymentMethod", paymentMethod);
            model.addAttribute("customerName", customerName);
        }
        
        return "receipt";
    }
}