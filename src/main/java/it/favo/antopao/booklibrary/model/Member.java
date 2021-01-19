package it.favo.antopao.booklibrary.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private User applicationUserId;
	private String name;
	private String surname;
	private Date insDate;
	private String telNumber;
	private String email;
	private String address;

	@OneToMany(mappedBy = "member")
	private Set<Shelf> shelf;

	@ManyToMany(mappedBy = "owner")
	private Set<Volume> volume;

	@OneToMany(mappedBy = "owner")
	private Set<Loan> outLoan;

	@OneToMany(mappedBy = "borrower")
	private Set<Loan> inLoan;

	@Lob
	private String note;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the applicationUserId
	 */
	public User getApplicationUserId() {
		return applicationUserId;
	}
	/**
	 * @param applicationUserId the applicationUserId to set
	 */
	public void setApplicationUserId(User applicationUserId) {
		this.applicationUserId = applicationUserId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the insDate
	 */
	public Date getInsDate() {
		return insDate;
	}
	/**
	 * @param insDate the insDate to set
	 */
	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}
	/**
	 * @return the telNumber
	 */
	public String getTelNumber() {
		return telNumber;
	}
	/**
	 * @param telNumber the telNumber to set
	 */
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}


	public Set<Volume> getVolume() {
		return volume;
	}

	public void setVolume(Set<Volume> volume) {
		this.volume = volume;
	}

	public Set<Loan> getOutLoan() {
		return outLoan;
	}

	public void setOutLoan(Set<Loan> outLoan) {
		this.outLoan = outLoan;
	}

	public Set<Loan> getInLoan() {
		return inLoan;
	}

	public void setInLoan(Set<Loan> inLoan) {
		this.inLoan = inLoan;
	}

	public Set<Shelf> getShelf() {
		return shelf;
	}

	public void setShelf(Set<Shelf> shelf) {
		this.shelf = shelf;
	}
	
	
	
		
}
