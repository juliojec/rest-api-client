package br.com.builders.resources;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.builders.models.User;
import br.com.builders.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<User> finById(@PathVariable Integer id) {
		Optional<User> user = userService.findById(id);
		return user.isPresent() ? ResponseEntity.ok(user.get()) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<User> finByName(@PathVariable String name) {
		Optional<User> user = userService.findByName(name);
		return user.isPresent() ? ResponseEntity.ok(user.get()) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{pageNumber}/{pageSize}")
	public Page<User> list(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		return userService.findAll(pageRequest);
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user, HttpServletResponse response) {
		user.setDateCreated(new Date());
		User userSave = userService.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		userService.deleteById(id);
	}

	@PutMapping
	public ResponseEntity<User> update(@RequestBody User user) {
		try {
			User userSave = userService.save(user);
			return ResponseEntity.ok(userSave);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

}