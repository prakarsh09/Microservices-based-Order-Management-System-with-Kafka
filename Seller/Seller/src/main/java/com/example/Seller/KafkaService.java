package com.example.Seller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.example.Seller.OrderRes;

@Service
public class KafkaService {
    @Autowired
private KafkaTemplate<String,String> kafkaTemplate1;
  
@Autowired
private KafkaTemplate<String,Object> kafkaTemplate2;

    public void update(String topic ,String confmessage){
        CompletableFuture<SendResult<String,String>> future=kafkaTemplate1.send(topic,confmessage);
        future.whenComplete((result,ex)->{
            if(ex==null){
                System.out.println("message sent");
            } else{
                System.out.println("unable to send");
            }
        });
    }

    public void SendOrderRes(String topic,OrderRes orderRes ){
        CompletableFuture<SendResult<String,Object>> future=kafkaTemplate2.send(topic,orderRes);
        future.whenComplete((result,ex)->{
            if(ex==null){
                System.out.println("message sent");
            } else{
                System.out.println("unable to send");
            }
        });
    }
}
