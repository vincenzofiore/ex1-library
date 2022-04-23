/**
 * 
 */
package it.favo.antopao.booklibrary.model;

import java.util.Set;
import javax.persistence.CascadeType;
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
  private String shelfName;
  private Long shelfAddress;
  @ManyToOne(cascade = CascadeType.ALL)
  private Member owner;
  @OneToMany(mappedBy = "shelf")
  private Set<Volume> volume;
  private Long notes;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getShelfName() {
    return shelfName;
  }

  public void setShelfName(String shelfName) {
    this.shelfName = shelfName;
  }

  public Long getShelfAddress() {
    return shelfAddress;
  }

  public void setShelfAddress(Long shelfAddress) {
    this.shelfAddress = shelfAddress;
  }

  public Member getOwner() {
    return owner;
  }

  public void setOwner(Member owner) {
    this.owner = owner;
  }

  public Set<Volume> getVolume() {
    return volume;
  }

  public void setVolume(Set<Volume> volume) {
    this.volume = volume;
  }

  public Long getNotes() {
    return notes;
  }

  public void setNotes(Long notes) {
    this.notes = notes;
  }

}
