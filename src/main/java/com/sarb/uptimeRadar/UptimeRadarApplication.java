package com.sarb.uptimeRadar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class UptimeRadarApplication {

	public static void main(String[] args) {
		SpringApplication.run(UptimeRadarApplication.class, args);
	}

}
