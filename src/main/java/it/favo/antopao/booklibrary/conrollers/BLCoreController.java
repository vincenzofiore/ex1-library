package it.favo.antopao.booklibrary.conrollers;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.favo.antopao.booklibrary.dto.StatusEnum;
import it.favo.antopao.booklibrary.dto.StatusResultDTO;
import it.favo.antopao.booklibrary.dto.UserEnum;

@RestController
@RequestMapping("/booklibrary/core")
public class BLCoreController {
	
	
	@GetMapping("{user}/status")
	public StatusResultDTO getStatus(@PathVariable(name = "user") final UserEnum user) {
		StatusResultDTO result = new StatusResultDTO();
		Map<UserEnum, StatusEnum> statusMap = new EnumMap<>(UserEnum.class);
		statusMap.put(UserEnum.ANTONELLA, StatusEnum.RIPOSATI);
		statusMap.put(UserEnum.PAOLA, StatusEnum.DEVI_STUDIARE);
		statusMap.put(UserEnum.VINCENZO, StatusEnum.STAI_CARICO);
		result.setStatus(statusMap.get(user));
		return result;
	}

}
