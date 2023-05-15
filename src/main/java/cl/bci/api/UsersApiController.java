package cl.bci.api;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import cl.bci.model.ErrorResponse;
import cl.bci.model.NewUserDTO;
import cl.bci.model.User;
import cl.bci.service.UserService;

@Controller
@RequestMapping("${openapi.users.base-path:/api}")
public class UsersApiController implements UsersApi {

	private final NativeWebRequest request;

	@Value("${mail.validation.regex}")
	private String mailRegex;

	@Value("${password.validation.regex}")
	private String passwordRegex;

	@Value("${error.pass.format}")
	private String errorPassFormat;

	@Value("${error.mail.format}")
	private String errorMailFormat;

	@Value("${error.mail.duplicated}")
	private String errorMailDuplicated;

	@Autowired
	private UserService userService;

	@org.springframework.beans.factory.annotation.Autowired
	public UsersApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	public boolean validateMail(String emailStr) {
		Matcher matcher = Pattern.compile(mailRegex, Pattern.CASE_INSENSITIVE).matcher(emailStr);
		return matcher.matches();
	}

	public boolean validatePassword(String emailStr) {
		Matcher matcher = Pattern.compile(passwordRegex, Pattern.CASE_INSENSITIVE).matcher(emailStr);
		return matcher.matches();
	}

	@Override
	public ResponseEntity<?> addUser(@Valid NewUserDTO newUser) {

		if (!validateMail(newUser.getEmail())) {
			return new ResponseEntity<>(new ErrorResponse(errorMailFormat), HttpStatus.BAD_REQUEST);
		}

		if (!validatePassword(newUser.getPassword())) {
			return new ResponseEntity<>(new ErrorResponse(errorPassFormat), HttpStatus.BAD_REQUEST);
		}

		if (!userService.findByEmail(newUser.getEmail()).isEmpty()) {
			return new ResponseEntity<>(new ErrorResponse(errorMailDuplicated), HttpStatus.BAD_REQUEST);
		}
		User createdUser = new User();
		BeanUtils.copyProperties(newUser, createdUser);
		try {
			return new ResponseEntity<>(userService.createUser(createdUser), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<?> findUsers() {
		try {
			return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> deleteUser(UUID id) {
		try {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> findUserById(UUID id) {
		try {
			User userById = userService.getUserById(id);

			if (Objects.isNull(userById)) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(userById, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> updateUser(User user) {
		try {
			userService.updateUser(user);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
