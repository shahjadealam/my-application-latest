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
public class CreateOrderConsumer {

  @Autowired
  OrderProcessor orderProcessor;
  private static final Logger LOGGER = LoggerFactory.getLogger(CreateOrderConsumer.class);

/*  @KafkaListener(
      topics = "${spring.kafka.topic.name}"
      , groupId = "${spring.kafka.consumer.group-id}"
  )*/
  public void consume(OrderEvent event) throws JsonProcessingException {
    String order = new ObjectMapper().writeValueAsString(event);
    LOGGER.info("Order event received in In OrderConsumer Class => " + order);
    orderProcessor.processOrder(event);
    // save the order event into the database
  }
}
