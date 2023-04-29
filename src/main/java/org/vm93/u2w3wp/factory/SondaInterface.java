package org.vm93.u2w3wp.factory;

import org.springframework.http.ResponseEntity;
import org.vm93.u2w3wp.model.Sonda;

public interface SondaInterface {
	public ResponseEntity<Sonda> sendStats();
}
