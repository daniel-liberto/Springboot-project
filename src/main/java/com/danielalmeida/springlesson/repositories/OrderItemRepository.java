package com.danielalmeida.springlesson.repositories;

import com.danielalmeida.springlesson.entities.OrderItem;
import com.danielalmeida.springlesson.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
