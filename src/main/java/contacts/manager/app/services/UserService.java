package contacts.manager.app.services;

import static contacts.manager.app.services.ValidationUtils.assertMatches;
import static contacts.manager.app.services.ValidationUtils.assertNotBlank;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contacts.manager.app.dao.UserRepository;
import contacts.manager.app.model.User;

/**
 *
 * Business service for User entity related operations
 *
 */
@Service
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	private static final Pattern PASSWORD_REGEX = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}");

	private static final Pattern EMAIL_REGEX = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	@Autowired
	private UserRepository userRepository;

	/**
	 *
	 * creates a new user in the database
	 * @param email - the user email
	 * @param password - the user plain text password
	 */
	@Transactional
	public void createUser(String email, String password) {
		assertNotBlank(email, "Email cannot be empty.");
		assertMatches(email, EMAIL_REGEX, "Invalid email.");
		assertNotBlank(password, "Password cannot be empty.");
		assertMatches(password, PASSWORD_REGEX, "Password must have at least 6 characters, with 1 numeric and 1 uppercase character.");

		if (userRepository.findByEmail(email) != null) {
			throw new IllegalArgumentException("The email is not available.");
		}

		User user = new User(null, email, new BCryptPasswordEncoder().encode(password), null);

		userRepository.save(user);
	}

	@Transactional(readOnly = true)
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}


}
