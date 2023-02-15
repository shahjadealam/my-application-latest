package com.myapp.api.kafka;

import com.myapp.api.kafka.domain.OrderEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {

  @Autowired
  ProcessOrderProducer orderProcessorProducer;
  private Set<String> orderStatus = new HashSet<>();
  Map<String, Set<String>> oderStatus = new HashMap<>();

  public OrderEvent processOrder(OrderEvent orderEvent){
    orderStatus.add(orderEvent.getStatus());
    orderEvent.setStatus("CREATED");
    orderProcessorProducer.sendMessage(orderEvent);
    return orderEvent;
  }

  public void setOrderStatus(OrderEvent event){
    orderStatus.add(event.getStatus());
    oderStatus.put(event.getOrder().getOrderId(), orderStatus);
  }

  public List<String> getOrderStatus(String orderId){
    List<String> response = null;
    if(oderStatus.get(orderId) != null) {
      response = oderStatus.get(orderId).stream().collect(Collectors.toList());
      response.add(0, "OrderID:" + orderId);
    }
    return response;
  }

}
