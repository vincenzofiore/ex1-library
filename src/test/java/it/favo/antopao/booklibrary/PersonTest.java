package it.favo.antopao.booklibrary;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.favo.antopao.booklibrary.model.Person;

class PersonTest {
	
	@BeforeEach
	void setUp() {
		
	}
	
	@Test
	void testPerson() throws Exception {
		//given
		Person borrower = new Person();
		Set<Person> borrowers = new HashSet<>();
		
		//when
		borrowers.add(borrower);
		boolean addSameRes = borrowers.add(borrower);
		
		//then
		assertFalse(addSameRes);
	}

}
