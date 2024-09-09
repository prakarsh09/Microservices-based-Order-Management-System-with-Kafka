package com.enduser.enduser.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
