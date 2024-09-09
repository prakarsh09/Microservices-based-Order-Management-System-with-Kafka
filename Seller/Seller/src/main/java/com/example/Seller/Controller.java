package com.example.Seller;

import org.springframework.web.bind.annotation.RestController;

import com.example.Seller.OrderRes;
import com.example.Seller.Entity.Product;
import com.example.Seller.Entity.offers;
import com.example.Seller.Entity.orderentt;
import com.example.Seller.Repo.ProductRepository;

import java.time.LocalDateTime;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controller {
 
    @Autowired
private ProductRepository productRepository;

@Autowired
private KafkaService kafkaService; 

@PostMapping("/add")
public String AddProduct(@RequestBody Product entity) {
   productRepository.save(entity);
    
    return "done";
}

@PostMapping("/order")
public String order(@RequestBody orderentt entity) {
 Product item=productRepository.findById(entity.getName()).get();
 int avail=item.getQty();
 int req=entity.getQty();
 
 if(avail>=req){
   OrderRes orderRes=new OrderRes();
 orderRes.setItem(entity.getName());
 orderRes.setPlacedby(entity.getEmail());
 orderRes.setQty(entity.getQty());
      this.kafkaService.SendOrderRes("odd", orderRes);
    this.kafkaService.update("offer","Your order of"+req+" "+entity.getName()+"has been placed ");
    item.setQty(avail-req);
    productRepository.save(item);
    
    return "order placed";
 }
 else if (avail<req) {
    this.kafkaService.update("offer","Order cannot be placed, available qty="+avail);
    return "order not placed";
 }
 else{
    return "item not available";
 }

   
}

@PostMapping("/offer")
public String postoffer(@RequestBody offers offer) {
    kafkaService.update("offer",offer.getMessage());
    
    return "offer sent";
}



}
