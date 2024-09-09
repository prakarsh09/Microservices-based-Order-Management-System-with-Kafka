package com.example.Seller;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrderRes {
    
    private int id;
    private String item;
    private Integer qty;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
   LocalDateTime datetime;
    private String placedby;
}
