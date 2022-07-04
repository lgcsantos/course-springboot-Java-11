package com.eduacandoweb.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eduacandoweb.course.entities.Users;
import com.eduacandoweb.course.repositories.UsersRepository;
import com.eduacandoweb.course.resources.exceptions.DatabaseException;
import com.eduacandoweb.course.services.exceptions.ResourceNotFoundException;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository repository;
	
	public List<Users> findAll(){
		return repository.findAll();
	}
	
	public Users findById(Long Id) {
		Optional<Users> obj = repository.findById(Id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(Id));
	}
	
	public Users insert(Users obj) {
		return repository.save(obj);
	}

	public void Delete(Long id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new  ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	
	
	public Users update(long id, Users obj) {
		try {
		Users entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new  ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Users entity, Users obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
	
	
}
