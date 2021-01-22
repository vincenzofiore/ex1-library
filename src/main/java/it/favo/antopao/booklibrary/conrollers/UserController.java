package it.favo.antopao.booklibrary.conrollers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import it.favo.antopao.booklibrary.dto.UserDTO;
import it.favo.antopao.booklibrary.dto.UserListResultDTO;
import it.favo.antopao.booklibrary.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping("/sign-up")
	public void signUp(@Valid @RequestBody UserDTO user) {
		service.save(user);
	}

	@GetMapping("/list")
	@ApiOperation(value = "List users", authorizations = { @Authorization(value = "Bearer") })
	public UserListResultDTO list() {
		return service.findAll();
	}
}
