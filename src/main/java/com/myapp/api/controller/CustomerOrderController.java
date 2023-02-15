package com.myapp.api.controller;

import com.myapp.api.dto.CustomerOrderRequest;
import com.myapp.api.entity.Customer;
import com.myapp.api.repository.CustomerOrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOrderController {

  @Autowired
  CustomerOrderRepository orderRepository;

  @PostMapping("/placeOrder")
  public Customer createOrder(@RequestBody CustomerOrderRequest request) {
    return orderRepository.save(request.getCustomer());
  }

  @GetMapping("/fetchOrders")
  public List<Customer> getAllOrders(){
    return orderRepository.findAll();
  }

  @GetMapping("/fetchByName/{name}")
  public Customer fetchByName(@PathVariable String name){
    return orderRepository.findByName(name);
  }
  @GetMapping("fetchById/{id}")
  public Customer fetchById(@PathVariable int id){
    return orderRepository.findByUserId(id);
  }
}
