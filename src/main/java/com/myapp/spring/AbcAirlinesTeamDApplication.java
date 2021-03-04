package com.myapp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.myapp.spring.repository.PassengerService;

//@ComponentScan(basePackageClasses = { Product.class, PassengerService.class, PassengerController.class })
//@ComponentScan(basePackageClasses = PassengerService.class)
@SpringBootApplication

public class AbcAirlinesTeamDApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcAirlinesTeamDApplication.class, args);
	}

}
