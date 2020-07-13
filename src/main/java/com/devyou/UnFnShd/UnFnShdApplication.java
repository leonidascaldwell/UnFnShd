package com.devyou.UnFnShd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration //***may not need
//@ComponentScan
public class UnFnShdApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnFnShdApplication.class, args);
	}

}
