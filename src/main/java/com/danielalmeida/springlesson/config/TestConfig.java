package com.danielalmeida.springlesson.config;

import com.danielalmeida.springlesson.entities.User;
import com.danielalmeida.springlesson.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test") // @Profile limits the below class to "test" profile only
public class TestConfig implements CommandLineRunner {
  @Autowired // auto dependency injection
  private UserRepository userRepository;

  public void run(String... args) throws Exception{
    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
    User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777777", "123456");
    userRepository.saveAll(Arrays.asList(u1, u2));
  }
}
