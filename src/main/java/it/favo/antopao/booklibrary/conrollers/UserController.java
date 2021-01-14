package it.favo.antopao.booklibrary.conrollers;

import java.util.Collections;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.favo.antopao.booklibrary.dto.UserDTO;
import it.favo.antopao.booklibrary.model.User;
import it.favo.antopao.booklibrary.repositories.RoleRepository;
import it.favo.antopao.booklibrary.repositories.UserRepository;

@RestController
@RequestMapping("/booklibrary/users")
public class UserController {

	private static final String USER_ROLE = "USER_ROLE";
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ModelMapper mapper;

	public UserController(UserRepository userRepository, //
			RoleRepository roleRepository, //
			BCryptPasswordEncoder bCryptPasswordEncoder, //
			ModelMapper mapper) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.mapper = mapper;
	}

	@PostMapping("/sign-up")
	public void signUp(@Valid @RequestBody UserDTO user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		User newUser = mapper.map(user, User.class);
		newUser.setRoles(Collections.singleton(roleRepository.findByName(USER_ROLE)));
		newUser.setEnabled(true);
		userRepository.save(newUser);
	}
}
