package com.example.Seller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Seller.Entity.Product;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    public Product findByName(String name);
    
} 