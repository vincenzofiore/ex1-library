package it.favo.antopao.booklibrary.repositories;

import org.springframework.data.repository.CrudRepository;

import it.favo.antopao.booklibrary.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
