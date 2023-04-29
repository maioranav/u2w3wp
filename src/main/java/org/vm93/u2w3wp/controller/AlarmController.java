package org.vm93.u2w3wp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vm93.u2w3wp.factory.OggettiAllarmati;
import org.vm93.u2w3wp.model.Sonda;


@RestController
public class AlarmController {
	
	@Autowired @Qualifier("Sonda") public Sonda sondasingle;

	@PostMapping("/alarm")
	public ResponseEntity<OggettiAllarmati> engageAlarm(@RequestBody Sonda s) throws Exception {
		return sondasingle.sendStats(s); //singleton
	}
}
