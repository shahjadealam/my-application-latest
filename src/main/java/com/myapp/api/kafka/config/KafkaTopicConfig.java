package com.myapp.api.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  @Value("${spring.kafka.topic.name}")
  private String topicName;

  @Value("${spring.kafka.topic.output}")
  private String topicOutput;

  // spring bean for kafka topic
  @Bean
  public NewTopic inputTopic(){
    return TopicBuilder.name(topicName)
        .build();
  }

  @Bean
  public NewTopic outputTopic(){
    return TopicBuilder.name(topicOutput)
        .build();
  }
}


/*
Needs to add these config in application.properties

#KAFKA PRODUCER
    spring.kafka.producer.bootstrap-servers=localhost:9092
    spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
    spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
    spring.kafka.topic.name=order_topics
    spring.kafka.topic.output=order_output
    spring.kafka.consumer.group-id=email

    #KAFKA CONSUMER
    spring.kafka.consumer.bootstrap-servers=localhost:9092
    spring.kafka.consumer.auto-offset-reset=earliest
    spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
    spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer
    spring.kafka.consumer.properties.spring.json.trusted.packages=*
*/
