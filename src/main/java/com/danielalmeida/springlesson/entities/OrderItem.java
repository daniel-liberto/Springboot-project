package com.danielalmeida.springlesson.entities;

import com.danielalmeida.springlesson.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private OrderItemPK id = new OrderItemPK();
  private Integer quantity;
  private Double price;

  public OrderItem() {}

  public OrderItem(Order order, Product product, Integer quantity, Double price) {
    id.setOrder(order);
    id.setProduct(product);
    this.quantity = quantity;
    this.price = price;
  }

  public void setOrder(Order order){
    id.setOrder(order);
  }
  @JsonIgnore
  public Order getOrder(){
    return id.getOrder();
  }
  public void setProduct(Product product){
    id.setProduct(product);
  }
  public Product getProduct(){
    return id.getProduct();
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderItem orderItem = (OrderItem) o;
    return Objects.equals(id, orderItem.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
