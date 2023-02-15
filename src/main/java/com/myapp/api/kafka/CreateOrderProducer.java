package com.myapp.api.kafka;

import com.myapp.api.kafka.domain.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(CreateOrderProducer.class);

  @Value("${spring.kafka.topic.name}")
  String inputTopic;
  private KafkaTemplate<String, OrderEvent> kafkaTemplate;

  public CreateOrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(OrderEvent event) {
    LOGGER.info(String.format("Order event 1. => %s", event.toString()));
    kafkaTemplate.send(inputTopic, event);
  }




 /*
    // create Message
    Message<OrderEvent> message = MessageBuilder
        .withPayload(event)
        .setHeader(KafkaHeaders.TOPIC, topic.name())
        .build();
    kafkaTemplate.send(message);
  }*/
}
