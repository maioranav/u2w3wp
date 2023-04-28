package org.vm93.u2w3wp.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ControlRoom {

	public static void alert(Sonda s) {
		if (s.getSmokeLevel() > 5) {
		log.error("*::ALARM ENGAGED::* > Sonda " + s.getId() + ", LAT=" + s.getLat() + " , LONG=" + s.getLon() + " , SMOKE=" + s.getSmokeLevel() + " < CRITIC!");
		} else {			
		//	log.info("Sonda " + s.getId() + ", LAT=" + s.getLat() + " , LONG=" + s.getLon() + " , SMOKE=" + s.getSmokeLevel() + " OK");
		}
	}
	
	
}
