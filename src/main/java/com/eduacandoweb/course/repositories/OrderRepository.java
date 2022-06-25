package com.eduacandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduacandoweb.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
