package com.myLearning.springBoot.banner;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBannerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootBannerApplication.class, args);
		
		SpringApplication springApplication = new SpringApplication(SpringBootBannerApplication.class);
		springApplication.setBannerMode(Mode.CONSOLE);		
		springApplication.run(args);
		
		
	
	}

}
