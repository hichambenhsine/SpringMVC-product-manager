package com.example.springmvcproductmanager.repository;

import com.example.springmvcproductmanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
