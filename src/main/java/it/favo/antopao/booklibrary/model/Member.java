package it.favo.antopao.booklibrary.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity

public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Long applicationUserId;
	private String name;
	private String surname;
	private Date insDate;
	private String telNumber;
	private String email;
	private String address;
	@Lob
	private String note;
	
}
