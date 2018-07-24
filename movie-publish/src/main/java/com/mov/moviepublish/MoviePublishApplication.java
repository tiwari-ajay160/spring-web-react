package com.mov.moviepublish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableDiscoveryClient
@ComponentScan("com.mov.moviepublish.*")
public class MoviePublishApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviePublishApplication.class, args);
	}
}
