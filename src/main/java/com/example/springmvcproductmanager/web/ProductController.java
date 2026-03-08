package com.example.springmvcproductmanager.web;

import com.example.springmvcproductmanager.entity.Product;
import com.example.springmvcproductmanager.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @GetMapping("/delete")
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/formProducts")
    public String formProducts(Model model){
        model.addAttribute("product",new Product());
        return "formProducts";
    }

    @PostMapping("/save")
    public String save(Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "formProducts";
        }
        productRepository.save(product);
        return "redirect:/index";
    }

    @GetMapping("/editProduct")
    public String editProduct(Model model,Long id){
        Product product=productRepository.findById(id).get();
        model.addAttribute("product",product);
        return "formProducts";
    }
}