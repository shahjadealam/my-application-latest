package com.myapp.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {
  @Id
  private int pid;
  @NotNull(message = "name can't be empty or null")
  private String name;
  @NotNull(message = "quantity can't be empty or null")
  private int quantity;
  @NotNull(message = "Price can't be empty or null")
  private double price;

  public Product(String name, int quantity, double price) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }
}
