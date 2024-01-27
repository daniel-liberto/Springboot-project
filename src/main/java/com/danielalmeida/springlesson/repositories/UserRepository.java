package com.danielalmeida.springlesson.repositories;

import com.danielalmeida.springlesson.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
