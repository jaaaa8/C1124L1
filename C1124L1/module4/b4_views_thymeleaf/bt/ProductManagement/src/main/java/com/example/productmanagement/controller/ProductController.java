package com.example.productmanagement.controller;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.service.IProductService;
import com.example.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

@RequestMapping("/products")
public class ProductController {
    @Autowired
    private final IProductService productService = new ProductService();


    @GetMapping("")
    public String listProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("/add-form")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "/add";
    }

    @GetMapping("/add")
    public String addProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.addNew(product);
        redirectAttributes.addFlashAttribute("success", "Product added successfully!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String showEditProductForm(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @GetMapping("/update")
    public String updateProduct(Product product, RedirectAttributes redirectAttributes){
        productService.updateProduct(product);
        redirectAttributes.addFlashAttribute("success", "Product updated successfully!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteProductForm(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @GetMapping("/delete")
    public String deleteProduct(Product product, RedirectAttributes redirectAttributes){
        if (product != null) {
            productService.deleteProduct(product);
            redirectAttributes.addFlashAttribute("success", "Product deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Product not found!");
        }
        return "redirect:/products";
    }

    @GetMapping("/{id}/detail")
    public String viewProductDetails(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.detailProduct(id));
        return "/detail";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam("keyword") String keyword, Model model) {
        List<Product> products = productService.findByName(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        return "/list"; // KHÔNG redirect
    }

}
