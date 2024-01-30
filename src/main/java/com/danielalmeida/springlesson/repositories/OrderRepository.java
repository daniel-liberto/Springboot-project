package com.danielalmeida.springlesson.repositories;

import com.danielalmeida.springlesson.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
