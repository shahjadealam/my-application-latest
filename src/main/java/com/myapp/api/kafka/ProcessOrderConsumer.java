package com.myapp.api.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.api.kafka.domain.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProcessOrderConsumer {

  @Autowired
  OrderProcessor orderProcessor;
  private static final Logger LOGGER = LoggerFactory.getLogger(ProcessOrderConsumer.class);

 /* @KafkaListener(
      topics = "${spring.kafka.topic.output}"
      , groupId = "${spring.kafka.consumer.group-id}"
  )*/
  public void consume(OrderEvent event) throws JsonProcessingException {
    String message = new ObjectMapper().writeValueAsString(event);
    LOGGER.info("Order event received in output service => " + message);
    System.out.println("Consumed.." + event.getOrder().toString());
    orderProcessor.setOrderStatus(event);

    // save the order event into the database
  }
}
