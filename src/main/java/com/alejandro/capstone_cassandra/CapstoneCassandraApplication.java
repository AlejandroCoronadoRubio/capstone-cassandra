package com.alejandro.capstone_cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CapstoneCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneCassandraApplication.class, args);
	}
}
