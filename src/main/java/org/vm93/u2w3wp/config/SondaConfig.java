package org.vm93.u2w3wp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.vm93.u2w3wp.model.Sonda;


@Configuration
public class SondaConfig {
	
	@Bean("Sonda")
	@Scope("singleton")
	public Sonda sondaSingle() {
		return new Sonda();
	}

}
