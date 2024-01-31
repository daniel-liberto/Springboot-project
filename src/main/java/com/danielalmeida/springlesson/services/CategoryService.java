package com.danielalmeida.springlesson.services;

import com.danielalmeida.springlesson.entities.Category;
import com.danielalmeida.springlesson.entities.User;
import com.danielalmeida.springlesson.repositories.CategoryRepository;
import com.danielalmeida.springlesson.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository repository;
  public List<Category> findAll(){
    return repository.findAll();
  }
  public Category findById(Long id){
    Optional<Category> obj = repository.findById(id);
    return obj.get();
  }
}
