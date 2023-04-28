package org.vm93.u2w3wp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vm93.u2w3wp.model.Sonda;


@RestController
public class AlarmController {

	@PostMapping("/alarm")
	public ResponseEntity<Sonda> engageAlarm(@RequestBody Sonda s) throws Exception {
		return Sonda.alert(s);
	}
}
