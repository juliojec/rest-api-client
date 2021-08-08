package br.com.builders.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.builders.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByName(String name);
	
	Optional<User> findById(Integer id);
	
}