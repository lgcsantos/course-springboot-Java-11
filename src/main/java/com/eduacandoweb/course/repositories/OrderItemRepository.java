package com.eduacandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduacandoweb.course.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
