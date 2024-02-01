package com.danielalmeida.springlesson.services;

import com.danielalmeida.springlesson.entities.Category;
import com.danielalmeida.springlesson.entities.Product;
import com.danielalmeida.springlesson.repositories.CategoryRepository;
import com.danielalmeida.springlesson.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  @Autowired
  private ProductRepository repository;
  public List<Product> findAll(){
    return repository.findAll();
  }
  public Product findById(Long id){
    Optional<Product> obj = repository.findById(id);
    return obj.get();
  }
}
