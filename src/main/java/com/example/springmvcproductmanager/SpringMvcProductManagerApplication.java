package com.example.springmvcproductmanager;

import com.example.springmvcproductmanager.entity.Product;
import com.example.springmvcproductmanager.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMvcProductManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcProductManagerApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(7000)
                    .quantity(20)
                    .build());
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1000)
                    .quantity(45)
                    .build());
            productRepository.save(Product.builder()
                    .name("TV")
                    .price(5000)
                    .quantity(10)
                    .build());
            productRepository.save(Product.builder()
                    .name("Smart Phone")
                    .price(13000)
                    .quantity(40)
                    .build());
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }

}
