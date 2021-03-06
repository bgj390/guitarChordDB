package com.example.guitarChords;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.guitarChords.model.Chord;
import com.example.guitarChords.model.ChordRepository;
import com.example.guitarChords.model.StringA2;
import com.example.guitarChords.model.StringA2Repository;
import com.example.guitarChords.model.StringD3;
import com.example.guitarChords.model.StringD3Repository;
import com.example.guitarChords.model.StringE1;
import com.example.guitarChords.model.StringE1Repository;
import com.example.guitarChords.model.StringE6;
import com.example.guitarChords.model.StringE6Repository;
import com.example.guitarChords.model.StringG4;
import com.example.guitarChords.model.StringG4Repository;
import com.example.guitarChords.model.StringH5;
import com.example.guitarChords.model.StringH5Repository;
import com.example.guitarChords.model.UserRepository;
import com.example.guitarChords.model.User;

@SpringBootApplication
public class GuitarChordsApplication {
	private static final Logger log = LoggerFactory.getLogger(GuitarChordsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GuitarChordsApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner chordDemo(ChordRepository cRep,
									   UserRepository uRep,	
									   StringE6Repository e6Rep, 
									   StringH5Repository h5Rep, 
									   StringG4Repository g4Rep, 
									   StringD3Repository d3Rep, 
									   StringA2Repository a2Rep, 
									   StringE1Repository e1Rep) {
		return (args) -> {
			log.info("save some chords");
			
			// Create positions with names
			String mute =  	 "x|-----|-----|-----|-----|-----|-----|-----|";
			String empty = 	 "0|-----|-----|-----|-----|-----|-----|-----|";
			String first = 	 "[]-[x]-|-----|-----|-----|-----|-----|-----|";
			String second =  "[]-----|-[x]-|-----|-----|-----|-----|-----|";
			String third =   "[]-----|-----|-[x]-|-----|-----|-----|-----|";
			String fourth =  "[]-----|-----|-----|-[x]-|-----|-----|-----|";
			String fifth =   "[]-----|-----|-----|-----|-[x]-|-----|-----|";
			String sixth =   "[]-----|-----|-----|-----|-----|-[x]-|-----|";
			String seventh = "[]-----|-----|-----|-----|-----|-----|-[x]-|";
		
			// Save all positions for each String?#Rep using names
			e1Rep.save(new StringE1(mute));
			e1Rep.save(new StringE1(empty));
			e1Rep.save(new StringE1(first));
			e1Rep.save(new StringE1(second));
			e1Rep.save(new StringE1(third));
			e1Rep.save(new StringE1(fourth));
			e1Rep.save(new StringE1(fifth));
			e1Rep.save(new StringE1(sixth));
			e1Rep.save(new StringE1(seventh));
			
			a2Rep.save(new StringA2(mute));
			a2Rep.save(new StringA2(empty));
			a2Rep.save(new StringA2(first));
			a2Rep.save(new StringA2(second));
			a2Rep.save(new StringA2(third));
			a2Rep.save(new StringA2(fourth));
			a2Rep.save(new StringA2(fifth));
			a2Rep.save(new StringA2(sixth));
			a2Rep.save(new StringA2(seventh));
			
			d3Rep.save(new StringD3(mute));
			d3Rep.save(new StringD3(empty));
			d3Rep.save(new StringD3(first));
			d3Rep.save(new StringD3(second));
			d3Rep.save(new StringD3(third));
			d3Rep.save(new StringD3(fourth));
			d3Rep.save(new StringD3(fifth));
			d3Rep.save(new StringD3(sixth));
			d3Rep.save(new StringD3(seventh));
			
			g4Rep.save(new StringG4(mute));
			g4Rep.save(new StringG4(empty));
			g4Rep.save(new StringG4(first));
			g4Rep.save(new StringG4(second));
			g4Rep.save(new StringG4(third));
			g4Rep.save(new StringG4(fourth));
			g4Rep.save(new StringG4(fifth));
			g4Rep.save(new StringG4(sixth));
			g4Rep.save(new StringG4(seventh));
			
			h5Rep.save(new StringH5(mute));
			h5Rep.save(new StringH5(empty));
			h5Rep.save(new StringH5(first));
			h5Rep.save(new StringH5(second));
			h5Rep.save(new StringH5(third));
			h5Rep.save(new StringH5(fourth));
			h5Rep.save(new StringH5(fifth));
			h5Rep.save(new StringH5(sixth));
			h5Rep.save(new StringH5(seventh));
			
			e6Rep.save(new StringE6(mute));
			e6Rep.save(new StringE6(empty));
			e6Rep.save(new StringE6(first));
			e6Rep.save(new StringE6(second));
			e6Rep.save(new StringE6(third));
			e6Rep.save(new StringE6(fourth));
			e6Rep.save(new StringE6(fifth));
			e6Rep.save(new StringE6(sixth));
			e6Rep.save(new StringE6(seventh));
						
			// Create users: admin/admin, user/user
			uRep.deleteAll();
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			uRep.save(user1);
			uRep.save(user2);
			
				log.info("fetch all chords");
				for (Chord chord : cRep.findAll()) {
					log.info(chord.toString());
			}
		};
	}
}
