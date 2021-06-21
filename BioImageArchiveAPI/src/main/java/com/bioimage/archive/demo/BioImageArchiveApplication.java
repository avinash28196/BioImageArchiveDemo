package com.bioimage.archive.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BioImageArchiveApplication {
	private static final Logger logger = LoggerFactory.getLogger(BioImageArchiveApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BioImageArchiveApplication.class, args);
	}

}
