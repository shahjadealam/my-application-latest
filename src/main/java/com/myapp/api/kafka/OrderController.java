package com.myapp.api.kafka;

import com.myapp.api.kafka.domain.Order;
import com.myapp.api.kafka.domain.OrderEvent;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

  private CreateOrderProducer orderProducer;
  private OrderProcessor orderProcessor;

  public OrderController(CreateOrderProducer orderProducer, OrderProcessor orderProcessor) {
    this.orderProducer = orderProducer;
    this.orderProcessor = orderProcessor;
  }

  @PostMapping("/orders")
  public String placeOrder(@RequestBody Order order) {
    order.setOrderId(UUID.randomUUID().toString());
    OrderEvent orderEvent = new OrderEvent();
    orderEvent.setStatus("PENDING");
    orderEvent.setMessage("order status is in pending state");
    orderEvent.setOrder(order);
    orderProducer.sendMessage(orderEvent);
    return "Order placed successfully with order ID..." + order.getOrderId();
  }

  @GetMapping("/status/{orderId}")
  public List<String> getOrderStatus(@PathVariable String orderId){
    return orderProcessor.getOrderStatus(orderId);
  }
}
