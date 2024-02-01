package com.danielalmeida.springlesson.config;

import com.danielalmeida.springlesson.entities.Category;
import com.danielalmeida.springlesson.entities.Order;
import com.danielalmeida.springlesson.entities.Product;
import com.danielalmeida.springlesson.entities.User;
import com.danielalmeida.springlesson.entities.enums.OrderStatus;
import com.danielalmeida.springlesson.repositories.CategoryRepository;
import com.danielalmeida.springlesson.repositories.OrderRepository;
import com.danielalmeida.springlesson.repositories.ProductRepository;
import com.danielalmeida.springlesson.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test") // @Profile limits the below class to "test" profile only
public class TestConfig implements CommandLineRunner {
  @Autowired // auto dependency injection
  private UserRepository userRepository;
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private ProductRepository productRepository;

  public void run(String... args) throws Exception{
    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
    User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777777", "123456");
    userRepository.saveAll(Arrays.asList(u1, u2));
    Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
    Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,u2);
    Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    Category cat1 = new Category(null, "Electronics");
    Category cat2 = new Category(null, "Books");
    Category cat3 = new Category(null, "Computers");
    categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    Product p1 = new Product(null, "The Lord of the Rings", "Movie based on a book", 90.5, "");
    Product p2 = new Product(null, "Smart TV", "Smart tv 4k HDR Premium", 2190.0, "");
    Product p3 = new Product(null, "Macbook Pro", "Perfect for working and overall entertainment", 1250.0, "");
    Product p4 = new Product(null, "PC Gamer", "Totally focused on modern games", 1200.0, "");
    Product p5 = new Product(null, "Rails for Dummies", "Good book for newcomers to rails world", 100.99, "");
    productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
  }

}
