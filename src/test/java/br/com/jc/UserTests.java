package br.com.jc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import br.com.jc.models.User;
import br.com.jc.repositories.UserRepository;
import br.com.jc.services.UserService;

@SpringBootTest
public class UserTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	public void getUsersTest() {
		PageRequest pageRequest = PageRequest.of(0, 5);
		List<User> users = Stream.of(new User(new Date(), "Julio", 35, true), new User(new Date(), "Ana", 36, true)).collect(Collectors.toList());
		Page<User> userPage = new PageImpl<>(users, pageRequest, users.size());
		when(repository.findAll(pageRequest)).thenReturn(userPage);
		assertEquals(2, service.findAll(pageRequest).getContent().size());
	}

	@Test
	public void saveUserTest() {
		User user = new User(new Date(), "Julio", 35, true);
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.save(user));
	}
	
	@Test
	public void findByNameUserTest() {
		String name = "Julio Cesar";
		User user = new User(new Date(), name, 35, true);
		when(repository.save(user)).thenReturn(user);
		User userSave = service.save(user);
		assertEquals(name, userSave.getName());
	}
	
	@Test
	public void deleteByIdUserTest() {
		User user = new User(new Date(), "Julio", 35, true);
		user.setId(9999999);
		service.deleteById(user.getId());
		verify(repository, times(1)).deleteById(user.getId());
	}
	
	@Test
	public void deleteUserTest() {
		User user = new User(new Date(), "Julio", 35, true);
		service.deleteUser(user);
		verify(repository, times(1)).delete(user);
	}
}
