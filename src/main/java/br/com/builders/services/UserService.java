package br.com.builders.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.builders.models.User;
import br.com.builders.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findByName(String name) {
		return userRepository.findByName(name);
	}
	
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}
	
	public Page<User> findAll(PageRequest pageRequest) {
		return userRepository.findAll(pageRequest);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}
}
