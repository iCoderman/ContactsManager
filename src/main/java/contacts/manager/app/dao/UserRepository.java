package contacts.manager.app.dao;

import org.springframework.data.repository.CrudRepository;

import contacts.manager.app.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

	// todo: write query
	//boolean isUsernameAvailable(String username);
}
