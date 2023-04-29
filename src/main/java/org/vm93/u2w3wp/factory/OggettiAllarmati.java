package org.vm93.u2w3wp.factory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.vm93.u2w3wp.model.ControlRoom;
import org.vm93.u2w3wp.model.Sonda;

import ch.qos.logback.core.boolex.EvaluationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class OggettiAllarmati {
	public abstract OggettiAllarmati createSonda();
	public abstract OggettiAllarmati createSondaFake();
	
	public ResponseEntity<OggettiAllarmati> sendStats(Sonda s) throws Exception {
		try {
			if (s.getSmokeLevel() > -1 && s.getSmokeLevel() < 11) {
				log.info("Rilevazione sonda effettuata tramite API");
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
