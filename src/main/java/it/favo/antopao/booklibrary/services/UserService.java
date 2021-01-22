package it.favo.antopao.booklibrary.services;

import it.favo.antopao.booklibrary.dto.UserDTO;
import it.favo.antopao.booklibrary.dto.UserListResultDTO;

public interface UserService {

	void save(UserDTO user);

	UserListResultDTO findAll();

}
