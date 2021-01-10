package it.favo.antopao.booklibrary.repositories;

import org.springframework.data.repository.CrudRepository;

import it.favo.antopao.booklibrary.model.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

	Privilege findByName(String name);

}
