package com.myapp.api.kafka;

import com.myapp.api.kafka.domain.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProcessOrderProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProcessOrderProducer.class);

  @Value("${spring.kafka.topic.output}")
  String outputTopic;

  private KafkaTemplate<String, OrderEvent> kafkaTemplate;

  public ProcessOrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(OrderEvent event) {
    LOGGER.info(String.format("Order event in OrderProcessor PRoducer=> %s", event.toString()));
    kafkaTemplate.send(outputTopic, event);
  }

}
