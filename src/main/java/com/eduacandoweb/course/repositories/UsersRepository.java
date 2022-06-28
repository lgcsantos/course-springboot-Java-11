package com.eduacandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduacandoweb.course.entities.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {

}
