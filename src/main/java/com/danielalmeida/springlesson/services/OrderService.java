package com.danielalmeida.springlesson.services;

import com.danielalmeida.springlesson.entities.Order;
import com.danielalmeida.springlesson.entities.User;
import com.danielalmeida.springlesson.repositories.OrderRepository;
import com.danielalmeida.springlesson.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
  @Autowired
  private OrderRepository repository;
  public List<Order> findAll(){
    return repository.findAll();
  }
  public Order findById(Long id){
    Optional<Order> obj = repository.findById(id);
    return obj.get();
  }
}
