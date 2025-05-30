package com.du.javaCourse.config;

import com.du.javaCourse.entities.Category;
import com.du.javaCourse.entities.Order;
import com.du.javaCourse.entities.User;
import com.du.javaCourse.entities.enums.OrderStatus;
import com.du.javaCourse.repositories.CategoryRepository;
import com.du.javaCourse.repositories.OrderRepository;
import com.du.javaCourse.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository,
                      CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Teste01", "teste1@gmail.com", "99999999", "123456");
        User u2 = new User(null, "Teste02", "teste2@gmail.com", "88888888", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        userRepository.saveAll(List.of(u1, u2));
        orderRepository.saveAll(List.of(o1, o2, o3));
        categoryRepository.saveAll(List.of(c1, c2, c3));

    }
}
