package cl.bci.api;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.NativeWebRequest;

import cl.bci.model.ErrorResponse;
import cl.bci.model.NewUserDTO;
import cl.bci.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Validated
@Api(value = "users", description = "The users API for BCI")
public interface UsersApi {

	default Optional<NativeWebRequest> getRequest() {
		return Optional.empty();
	}

	@ApiOperation(value = "", nickname = "addUser", notes = "Creates a new user in the DB.  Duplicates (email) are not allowed", response = User.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "user response", response = User.class),
			@ApiResponse(code = 500, message = "unexpected error", response = ErrorResponse.class) })
	@PostMapping(value = "/users", produces = { "application/json" }, consumes = { "application/json" })
	default ResponseEntity<?> addUser(
			@ApiParam(value = "User to add", required = true) @Valid @RequestBody NewUserDTO newUser) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "", nickname = "deleteUser", notes = "deletes a single user, based on the ID supplied", tags = {})
	@ApiResponses(value = { @ApiResponse(code = 204, message = "user deleted"),
			@ApiResponse(code = 500, message = "unexpected error", response = ErrorResponse.class) })
	@DeleteMapping(value = "/users/{id}", produces = { "application/json" })
	default ResponseEntity<?> deleteUser(
			@ApiParam(value = "ID of user to delete", required = true) @PathVariable("id") UUID id) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@ApiOperation(value = "", nickname = "findUserById", notes = "Returns a user based on a single ID", response = User.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "user response", response = User.class),
			@ApiResponse(code = 200, message = "unexpected error", response = ErrorResponse.class) })
	@GetMapping(value = "/users/{id}", produces = { "application/json" })
	default ResponseEntity<?> findUserById(
			@ApiParam(value = "ID of user to fetch", required = true) @PathVariable("id") UUID id) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@ApiOperation(value = "", nickname = "findUsers", notes = "Returns all users from the system", response = User.class, responseContainer = "List", tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "user response", response = User.class, responseContainer = "List"),
			@ApiResponse(code = 200, message = "unexpected error", response = ErrorResponse.class) })
	@GetMapping(value = "/users", produces = { "application/json" })
	default ResponseEntity<?> findUsers() {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}
	
	@ApiOperation(value = "", nickname = "updateUsers", notes = "Update a single user from the system", response = User.class,  tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "user response", response = User.class),
			@ApiResponse(code = 200, message = "unexpected error", response = ErrorResponse.class) })
	@PatchMapping(value = "/users", produces = { "application/json" })
	default ResponseEntity<?> updateUser(@ApiParam(value = "User to update", required = true) @Valid @RequestBody User updatedUser) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

}
