package com.danielalmeida.springlesson.repositories;

import com.danielalmeida.springlesson.entities.Category;
import com.danielalmeida.springlesson.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
