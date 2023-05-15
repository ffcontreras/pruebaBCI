package cl.bci.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cl.bci.model.User;
import cl.bci.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public User createUser(User usr) {
		return userRepository.save(usr);
	}

	@Override
	public User updateUser(User usr) {
		userRepository.findById(usr.getId()).ifPresent(user -> userRepository.save(user));
		return usr;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(UUID userId) {

		Optional<User> userRepoDB = userRepository.findById(userId);
		if (userRepoDB.isPresent()) {
			return userRepoDB.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteUser(UUID id) {
		userRepository.findById(id).ifPresent(idValue -> userRepository.delete(idValue));
	}

	@Override
	public List<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}