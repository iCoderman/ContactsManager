package contacts.manager.app.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import contacts.manager.app.dto.NewUserDTO;
import contacts.manager.app.dto.UserInfoDTO;
import contacts.manager.app.model.User;
import contacts.manager.app.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET)
	public UserInfoDTO getUserInfo(Principal principal) {
		User user = userService.findUserByEmail(principal.getName());
		return user != null ? new UserInfoDTO(user.getId(), user.getEmail()) : null;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@RequestBody NewUserDTO user) {
		userService.createUser(user.getEmail(), user.getPlainTextPassword());
	}


	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> errorHandler(Exception exc) {
		LOGGER.error(exc.getMessage(), exc);
		return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
