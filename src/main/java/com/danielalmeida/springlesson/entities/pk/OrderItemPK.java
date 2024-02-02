package com.danielalmeida.springlesson.entities.pk;

import com.danielalmeida.springlesson.entities.Order;
import com.danielalmeida.springlesson.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemPK implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  public void setOrder(Order order) {
    this.order = order;
  }

  public Order getOrder() {
    return order;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Product getProduct() {
    return product;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderItemPK that = (OrderItemPK) o;
    return Objects.equals(order, that.order) && Objects.equals(product, that.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(order, product);
  }
}
