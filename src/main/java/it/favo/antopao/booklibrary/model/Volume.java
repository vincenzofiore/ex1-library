/**
 * 
 */
package it.favo.antopao.booklibrary.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Volume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Book book;

	private String format;

	@OneToOne
	private Member owner;

	@ManyToOne
	private Shelf shelf;

	@OneToMany(mappedBy = "volume")
	private Set<Loan> loan;

	private Date inserDate;
	private String loanState;
	private Boolean availableForLoan;
	private Boolean availableForConsultation;
	private Long notes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Member getOwner() {
		return owner;
	}
	public void setOwner(Member owner) {
		this.owner = owner;
	}


	public Date getInserDate() {
		return inserDate;
	}
	public void setInserDate(Date inserDate) {
		this.inserDate = inserDate;
	}
	public String getLoanState() {
		return loanState;
	}
	public void setLoanState(String loanState) {
		this.loanState = loanState;
	}
	public Boolean getAvailableForLoan() {
		return availableForLoan;
	}
	public void setAvailableForLoan(Boolean availableForLoan) {
		this.availableForLoan = availableForLoan;
	}
	public Boolean getAvailableForConsultation() {
		return availableForConsultation;
	}
	public void setAvailableForConsultation(Boolean availableForConsultation) {
		this.availableForConsultation = availableForConsultation;
	}
	public Long getNotes() {
		return notes;
	}
	public void setNotes(Long notes) {
		this.notes = notes;
	}

	public Set<Loan> getLoan() {
		return loan;
	}

	public void setLoan(Set<Loan> loan) {
		this.loan = loan;

	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}


}

