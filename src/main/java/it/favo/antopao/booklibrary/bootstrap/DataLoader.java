package it.favo.antopao.booklibrary.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.favo.antopao.booklibrary.model.User;
import it.favo.antopao.booklibrary.repositories.RoleRepository;
import it.favo.antopao.booklibrary.repositories.UserRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

//	@Autowired
//	private PrivilegeRepository privilegeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (alreadySetup) {
			return;
		}

		createUserIfNotFound("testUser", "user", "test", "password", "user.test@gmail.com");

		alreadySetup = true;
		
	}

//	@Transactional
//	private Privilege createPrivilegeIfNotFound(String name) {
//		Privilege privilege = privilegeRepository.findByName(name);
//		if (privilege == null) {
//			privilege = new Privilege();
//			privilege.setName(name);
//			privilegeRepository.save(privilege);
//		}
//		return privilege;
//	}
//
//	@Transactional
//	private Role createRoleIfNotFound(String name, Set<Privilege> privileges) {
//
//		Role role = roleRepository.findByName(name);
//		if (role == null) {
//			role = new Role();
//			role.setName(name);
//			role.setPrivileges(privileges);
//			roleRepository.save(role);
//		}
//		return role;
//	}

//	@Transactional
	private User createUserIfNotFound(String username, String firstName, String password, String lastName,
			String email) {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			user = new User();
			user.setUsername(username);
			user.setPassword(passwordEncoder.encode(password));
			user.setLastName(lastName);
			user.setFirstName(firstName);
			user.setEmail(email);
			user.setEnabled(true);
			user.getRoles().add(roleRepository.findByName("USER_ROLE"));
			userRepository.save(user);
		}
		return user;
	}

}
