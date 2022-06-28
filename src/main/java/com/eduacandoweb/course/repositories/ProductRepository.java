package com.eduacandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduacandoweb.course.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
