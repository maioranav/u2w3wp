package org.vm93.u2w3wp.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ch.qos.logback.core.boolex.EvaluationException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Sonda {
	
	private Long id;
	private Double lat;
	private Double lon;
	private Integer smokeLevel;
	
	public static ResponseEntity<Sonda> alert(Sonda s) throws Exception {
		try {
			if (s.getSmokeLevel() > -1 && s.getSmokeLevel() < 11) {
				if (s.getSmokeLevel() > 5) {
					log.error("*::ALARM ENGAGED::* > Sonda " + s.getId() + ", LAT=" + s.getLat() + " , LONG=" + s.getLon() + " , SMOKE=" + s.getSmokeLevel() + " < CRITIC!");
					return new ResponseEntity<>(s, HttpStatus.CREATED);
				} else {
					log.info("Sonda " + s.getId() + ", LAT=" + s.getLat() + " , LONG=" + s.getLon() + " , SMOKE=" + s.getSmokeLevel() + " OK");
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
