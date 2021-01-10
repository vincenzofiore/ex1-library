package it.favo.antopao.booklibrary.repositories;

import org.springframework.data.repository.CrudRepository;

import it.favo.antopao.booklibrary.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByName(String name);

}
