package it.favo.antopao.booklibrary.conrollers;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.favo.antopao.booklibrary.dto.ApplicationUserDTO;
import it.favo.antopao.booklibrary.model.ApplicationUser;
import it.favo.antopao.booklibrary.repositories.ApplicationUserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	private final ApplicationUserRepository applicationUserRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ModelMapper mapper;

	public UserController(ApplicationUserRepository applicationUserRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper mapper) {
		this.applicationUserRepository = applicationUserRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.mapper = mapper;
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody ApplicationUserDTO user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		applicationUserRepository.save(mapper.map(user, ApplicationUser.class));
	}
}
