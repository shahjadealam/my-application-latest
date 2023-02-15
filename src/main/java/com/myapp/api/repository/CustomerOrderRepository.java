package com.myapp.api.repository;

import com.myapp.api.entity.Customer;
import com.myapp.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<Customer,Integer> {
  Customer findByName(String name);
  Customer findByUserId(int id);
}
