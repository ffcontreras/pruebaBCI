package cl.bci.service;

import java.util.List;
import java.util.UUID;

import cl.bci.model.User;

public interface UserService {

	User createUser(User usr);

	List<User> findByEmail(String email);

	User updateUser(User user);

	List<User> getAllUsers();

	User getUserById(UUID userId);

	void deleteUser(UUID id);

}