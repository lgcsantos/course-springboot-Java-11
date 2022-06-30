package com.eduacandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduacandoweb.course.entities.Users;
import com.eduacandoweb.course.repositories.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository repository;
	
	public List<Users> findAll(){
		return repository.findAll();
	}
	
	public Users findById(Long Id) {
		Optional<Users> obj = repository.findById(Id);
		return obj.get();
	}
	
	public Users insert(Users obj) {
		return repository.save(obj);
	}

	public void Delete(Long id) {
		repository.deleteById(id);
	}
	
	
	
	public Users update(long id, Users obj) {
		Users entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Users entity, Users obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
	
	
}
