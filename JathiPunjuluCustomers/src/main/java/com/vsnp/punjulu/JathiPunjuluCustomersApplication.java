package com.vsnp.punjulu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class JathiPunjuluCustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(JathiPunjuluCustomersApplication.class, args);
	}

}
