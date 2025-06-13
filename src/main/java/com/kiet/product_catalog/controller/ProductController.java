package com.kiet.product_catalog.controller;

import com.kiet.product_catalog.model.Product;
import com.kiet.product_catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "list";
    }

    @GetMapping("/product/new")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping("/product")
    public String saveProduct(@ModelAttribute Product product) {
        service.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/product/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        Product product = service.getProductById(id).orElseThrow();
        model.addAttribute("product", product);
        return "form";
    }

    @GetMapping("/products/category/{cat}")
    public String filterByCategory(@PathVariable String cat, Model model) {
        model.addAttribute("products", service.getProductsByCategory(cat));
        return "list";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        service.deleteProductById(id);
        return "redirect:/products";
    }
}