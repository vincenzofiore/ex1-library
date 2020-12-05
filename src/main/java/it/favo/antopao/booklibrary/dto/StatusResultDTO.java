package it.favo.antopao.booklibrary.dto;

public class StatusResultDTO extends BasicResultDTO {
	
	private StatusEnum status;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

}
