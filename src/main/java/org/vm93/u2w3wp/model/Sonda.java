package org.vm93.u2w3wp.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ch.qos.logback.core.boolex.EvaluationException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sonda {

	private Long id;
	private String lat;
	private String lon;
	private Integer smokeLevel;

	public ResponseEntity<Sonda> sendStats(Sonda s) throws Exception {
		try {
			if (s.getSmokeLevel() > -1 && s.getSmokeLevel() < 11) {
				ControlRoom.alert(s);
				return new ResponseEntity<>(s, HttpStatus.OK);
			} else {
				throw new EvaluationException("Value not valid for SMOKE LEVEL");
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
