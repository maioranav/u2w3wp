package org.vm93.u2w3wp.runner;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.vm93.u2w3wp.factory.OggettiAllarmati;
import org.vm93.u2w3wp.model.ControlRoom;
import org.vm93.u2w3wp.model.Sonda;

import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SondaRunner implements ApplicationRunner {
	
	@Autowired OggettiAllarmati oggAlrm;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		new Timer().scheduleAtFixedRate(new TimerTask(){
		    @Override
		    public void run(){
		    	Sonda s = (Sonda) oggAlrm.createSondaFake();
		    	log.info("Rilevazione sonda effettuata tramite runner");
		    	ControlRoom.alert(s);
		    }
		},0,5000);

	}

}
