package com.example.Seller.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    
    @Id
    private String name;
    private Integer qty;
    private Integer price;
}
