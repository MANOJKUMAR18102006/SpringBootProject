package com.example.Smart_Canteen_Ordering_and_Billing_System.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    
    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }
    
    @GetMapping("/orders")
    public String orders() {
        return "orders";
    }
    
    @GetMapping("/payment")
    public String payment() {
        return "payment";
    }
    
    @PostMapping("/payment")
    public String processPayment(@RequestParam String item, @RequestParam String quantity, @RequestParam String price) {
        return "redirect:/payment";
    }
    
    @GetMapping("/receipt")
    public String receipt() {
        return "receipt";
    }
    
    @PostMapping("/receipt")
    public String processPaymentFinal(@RequestParam String paymentMethod, @RequestParam String customerName) {
        return "receipt";
    }
}