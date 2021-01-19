/**
 * 
 */
package it.favo.antopao.booklibrary.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author A. Favorito on 19-01-2021
 *
 * 
 */
@Entity
public class Shelf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String shelf_name;
	private Long shelf_address;

	@ManyToOne
	private Member member;

	@OneToMany(mappedBy = "shelf")
	private Set<Volume> volume;

	private Long notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShelf_name() {
		return shelf_name;
	}

	public void setShelf_name(String shelf_name) {
		this.shelf_name = shelf_name;
	}

	public Long getShelf_address() {
		return shelf_address;
	}

	public void setShelf_address(Long shelf_address) {
		this.shelf_address = shelf_address;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
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

	public void setVolume(Set<Volume> volume) {
		this.volume = volume;
	}

	}


