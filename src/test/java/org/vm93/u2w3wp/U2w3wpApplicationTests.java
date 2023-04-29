package org.vm93.u2w3wp;

import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.vm93.u2w3wp.model.Sonda;

import com.github.javafaker.Faker;

@SpringBootTest
class U2w3wpApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testSondaFumo() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		Sonda s = Sonda.builder().id(fake.number().numberBetween(3l, 10l)).lat(fake.address().latitude()).lon(fake.address().longitude()).smokeLevel(fake.number().numberBetween(0, 10)).build();
		assertNotNull((Object) s.getSmokeLevel());
	}

}
