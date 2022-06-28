package com.eduacandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eduacandoweb.course.entities.Order;
import com.eduacandoweb.course.entities.Users;
import com.eduacandoweb.course.entities.enums.OrderStatus;
import com.eduacandoweb.course.repositories.OrderRepository;
import com.eduacandoweb.course.repositories.UsersRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private OrderRepository ordersRepository;

	@Override
	public void run(String... args) throws Exception {


		Users u1 = new Users(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Users u2 = new Users(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		usersRepository.saveAll(Arrays.asList(u1, u2));
		ordersRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}

}
