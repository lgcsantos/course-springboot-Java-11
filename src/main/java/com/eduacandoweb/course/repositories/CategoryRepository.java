package com.eduacandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduacandoweb.course.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
