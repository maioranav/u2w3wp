package org.vm93.u2w3wp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vm93.u2w3wp.model.Sonda;

import ch.qos.logback.core.boolex.EvaluationException;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AlarmController {

	@PostMapping("/alarm")
	public ResponseEntity<Sonda> engageAlarm(@RequestBody Sonda s) throws Exception {
		try {
			if (s.getSmokeLevel() > -1 && s.getSmokeLevel() < 11) {
				if (s.getSmokeLevel() > 5) {
					log.error("*::ALARM ENGAGED::* > Sonda id NUM, LAT= , LONG= , SMOKE=  < CRITIC!");
					return new ResponseEntity<>(s, HttpStatus.CREATED);
				} else {
					log.info("Sonda id num lat long, smokelev = OK");
					return new ResponseEntity<>(s, HttpStatus.OK);
				}
			} else {
				throw new EvaluationException("Value not valid for SMOKE LEVEL");
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
