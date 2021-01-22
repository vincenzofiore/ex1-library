package it.favo.antopao.booklibrary.services;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.favo.antopao.booklibrary.dto.UserDTO;
import it.favo.antopao.booklibrary.dto.UserItemDTO;
import it.favo.antopao.booklibrary.dto.UserListResultDTO;
import it.favo.antopao.booklibrary.model.User;
import it.favo.antopao.booklibrary.repositories.RoleRepository;
import it.favo.antopao.booklibrary.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final String USER_ROLE = "USER_ROLE";
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ModelMapper mapper;

	public UserServiceImpl(UserRepository userRepository, //
			RoleRepository roleRepository, //
			BCryptPasswordEncoder bCryptPasswordEncoder, //
			ModelMapper mapper) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.mapper = mapper;
	}

	@Override
	public void save(UserDTO user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		User newUser = mapper.map(user, User.class);
		newUser.setRoles(Collections.singleton(roleRepository.findByName(USER_ROLE)));
		newUser.setEnabled(true);
		userRepository.save(newUser);
	}

	@Override
	@Transactional
	public UserListResultDTO findAll() {
		UserListResultDTO result = new UserListResultDTO();
		result.getUsers(). //
				addAll(StreamSupport //
				.stream(userRepository.findAll().spliterator(), false) //
						.map(user -> mapper.map(user, UserItemDTO.class)).collect(Collectors.toSet()));
		return result;
	}

}
