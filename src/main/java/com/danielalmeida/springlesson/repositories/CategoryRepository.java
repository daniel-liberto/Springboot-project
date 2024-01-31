package com.danielalmeida.springlesson.repositories;

import com.danielalmeida.springlesson.entities.Category;
import com.danielalmeida.springlesson.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
