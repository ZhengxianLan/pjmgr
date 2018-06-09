package com.citic.pjmgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages={"com.citic.pjmgr.domain"})
public class PjmgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(PjmgrApplication.class, args);
	}
}
