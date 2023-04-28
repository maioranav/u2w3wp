package org.vm93.u2w3wp.runner;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.vm93.u2w3wp.model.ControlRoom;
import org.vm93.u2w3wp.model.Sonda;

import com.github.javafaker.Faker;

@Component
public class SondaRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		new Timer().scheduleAtFixedRate(new TimerTask(){
		    @Override
		    public void run(){
		    	Sonda s = randomSonda();
		    	ControlRoom.alert(s);
		    }
		},0,5000);

	}
	
	public static Sonda randomSonda() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		Sonda s = Sonda.builder().id(fake.number().numberBetween(3l, 10l)).lat(fake.address().latitude()).lon(fake.address().longitude()).smokeLevel(fake.number().numberBetween(0, 10)).build();
		return s;
		}

}
