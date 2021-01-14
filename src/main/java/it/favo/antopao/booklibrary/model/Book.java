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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String isbn;
	private String title;

	@ManyToMany(mappedBy = "book")
	private Set<Author> authors;

	private String publisher;
	private Date publicationDate;
	private String language;
	private Boolean originaLanguage;
	private Long notes;

	@OneToMany(mappedBy = "book")
	private Set<Volume> volume;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Boolean getOriginaLanguage() {
		return originaLanguage;
	}

	public void setOriginaLanguage(Boolean originaLanguage) {
		this.originaLanguage = originaLanguage;
	}

	public Long getNotes() {
		return notes;
	}

	public void setNotes(Long notes) {
		this.notes = notes;
	}

	public Set<Volume> getVolume() {
		return volume;
	}

	public void setVolumes(Set<Volume> volume) {
		this.volume = volume;
	}



}
