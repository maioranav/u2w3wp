package org.vm93.u2w3wp.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SondaRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.error("*::ALARM ENGAGED::* > Sonda id NUM, LAT= , LONG= , SMOKE=  < CRITIC!");

	}

}