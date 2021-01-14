package it.favo.antopao.booklibrary;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.favo.antopao.booklibrary.model.Member;

class MemberTest {
	
	@BeforeEach
	void setUp() {
		
	}
	
	@Test
	void testPerson() throws Exception {
		//given
		Member borrower = new Member();
		Set<Member> borrowers = new HashSet<>();
		
		//when
		borrowers.add(borrower);
		boolean addSameRes = borrowers.add(borrower);
		
		//then
		assertFalse(addSameRes);
	}

}
