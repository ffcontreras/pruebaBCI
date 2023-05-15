package cl.bci.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.bci.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	List<User> findByEmail(String email);

}
