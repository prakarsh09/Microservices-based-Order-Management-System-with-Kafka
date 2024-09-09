package com.enduser.enduser;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.enduser.enduser.Entity.OrderRes;

@Service
public class KafkaService {
    
    org.slf4j.Logger log=LoggerFactory.getLogger(KafkaService.class);

   
    
    @KafkaListener(topics ="offer",groupId = "user")
    public void consumeoffer(String message){
        log.info(message);
        
    }
    @KafkaListener(topics ="odd",groupId = "user")
    public void consumeorder(OrderRes orderRes){
       
        log.info("order saved"+orderRes);
       
    }
}
