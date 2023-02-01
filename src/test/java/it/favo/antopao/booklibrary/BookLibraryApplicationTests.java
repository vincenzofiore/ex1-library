package it.favo.antopao.booklibrary;

import static org.assertj.core.api.Assertions.assertThat;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class BookLibraryApplicationTests {

	@Autowired
	@Qualifier("jasyptStringEncryptor")
	StringEncryptor stringEncryptor;

	@Test
	void contextLoads() {
		// given
		final String plainUsername = "ex1user";
		final String plainPassword = "3X1@g3n23";

		// when
		final String encUsername = stringEncryptor.encrypt(plainUsername);
		final String encPassword = stringEncryptor.encrypt(plainPassword);

		final String actPlainUsername = stringEncryptor.decrypt(encUsername);
		final String actPlainPassword = stringEncryptor.decrypt(encPassword);

		// then
		assertThat(actPlainUsername) //
				.isNotNull() //
				.isEqualTo(plainUsername);
		assertThat(actPlainPassword) //
				.isNotNull() //
				.isEqualTo(plainPassword);
	}

}
