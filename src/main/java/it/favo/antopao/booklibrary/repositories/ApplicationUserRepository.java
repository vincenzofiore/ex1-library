package it.favo.antopao.booklibrary.repositories;

import org.springframework.data.repository.CrudRepository;

import it.favo.antopao.booklibrary.model.ApplicationUser;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {

	ApplicationUser findByUsername(String username);

}
