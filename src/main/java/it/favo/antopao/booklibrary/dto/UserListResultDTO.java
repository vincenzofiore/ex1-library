package it.favo.antopao.booklibrary.dto;

import java.util.HashSet;
import java.util.Set;

public class UserListResultDTO extends BasicResultDTO {

	private Set<UserItemDTO> users = new HashSet<>();

	public Set<UserItemDTO> getUsers() {
		return users;
	}

}
